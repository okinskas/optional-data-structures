# optional-data-structures

Optional interface wrappers for common data structures. This project aims to explore how the Optional class
can be incorporated to change the way we interact with standard data structures. The underlying data
structures remain unchanged with only the API differing by providing Optional-based interactions.

A common problem the Optional class aims to solve is relying on a developer to perform null-checking
on potentially nullable values. Any values returned that are potentially null can cause NullPointerExceptions
if their methods are invoked. Optional acts as a contract between developers and the API to enforce checks in
scenarios where it is needed; with `null`, there is nothing that prevents the developer from not checking.

It goes without saying that this approach is not strictly better or worse thant the standard;
this project simply aims to explore an alternative approach.

# Data Structures

- [OStack](#ostack)
- [OQueue](#oqueue)
- [OMap](#omap)

## OStack

### Stack Usage Problems
Typical usage of a Stack might look like the following:

```java
while (!stack.empty()) {
    System.out.println(stack.pop());
}
```

However, structuring a for-loop to iterate through a stack is not practical:

```java
for (Integer i = stack.pop(); !stack.empty(); i = stack.pop()) {
    System.out.println(i);
}
```

Given a stack containing `{0,1,2,3}` with 3 being at the top of the stack, the output would look as follows:

```
3
2
1
```

Trying to `pop()` again outside of the loop throws an `EmptyStackException`. Where did the 0 go? It was actually consumed
in the iteration of the for loop without the body of the loop being executed. This behaviour can be observed by
paying attention to the ordering:

Given a stack containing `{0,1}`

```java
System.out.println(i)   // prints 1, and loop body finishes
i = stack.pop()         // updates i = 0
!stack.empty()          // now fails after the last update of i
                        // loop exits
```

As a result, the execution of the body for the 0 element is skipped.

### Solution: OStack Usage

The `OStack` data structure provides the same interface as the typical Stack but returns
Optional objects as opposed to the object itself. It does not provide an `empty()` method due to the
use of Optionals.

Using an OStack, we can now implement a for loop like so: 

```java
for (Optional<Integer> i = ostack.pop(); i.isPresent(); i = ostack.pop()) {
    System.out.println(i.get());
}
```

The output of this operation with the inputs seen previously, `{0,1,2,3}`, we get:


```
3
2
1
0
```

Aside: 

The only difference in functionality is that OStack does not permit pushing `null` onto the stack as
this prevents the API design from operating as intended (i.e. early break from loops when encountering a `null`).

## OQueue

### Queue Usage Problems

The same concepts mentioned for Stack also apply to Queue:

Queue: `{0,1,2,3}`

```java
for (Integer i = queue.remove(); !queue.isEmpty(); i = queue.remove()) {
    System.out.println(i);
}
```

Output:

```bash
0
1
2
```

### Solution: OQueue Usage

OQueue: `{0,1,2,3}`

```java
for (Optional<Integer> i = oqueue.remove(); i.isPresent(); i = oqueue.remove()) {
    System.out.println(i.get())
}
```

Output:

```bash
0
1
2
3
```

Aside: 

The only difference in functionality is that OQueue does not permit adding `null` to the queue as
this prevents the API design from operating as intended (i.e. early break from loops when encountering a `null`).


# OMap

## Map Usage Problems

When using a Map, we very frequently perform null checking or unintentionally invoke
methods on a nullable element:

```java
List list = map.get(0);
if (list != null) {
    list.add(56)
}
```

This requires developers to remember to null-check which goes against what was discussed
in the [header](#optional-data-structures).

We also have tools for more functional-style approaches:

```java
map.computeIfPresent(0, (k, list) -> {
    list.add(56);
    return list;
})
```

This seems cleaner although using the OMap can improve it further.

## Solution: OMap Usage

With the OMap, we can implement the code seen above in the following way:

```java
map.get(0).ifPresent(list -> list.add(56));
```

The computeIfPresent method requires the user to have domain knowledge about the arguments
and the need for the return statement. I'd argue this is more clear for the use-case and
is more descriptive at a glance.

