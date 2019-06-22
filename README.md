# optional-data-structures
Optional interface wrappers (or full implementations) for common data structures.

This project aims to explore how the Optional class can be incorporated to
change the way we interact with standard data structures.

# Data Structures

- [OStack](#ostack)
- [OQueue](#oqueue)

## OStack

### Stack Usage
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

### OStack Usage

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

## OQueue

### Queue Usage

The same concept mentioned for Stack also applies to Queue:

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

Like in Stack, changing the loop condition to `i != null` will produce an exception (`NoSuchElementException`):

```java
for (Integer i = queue.remove(); i != null; i = queue.remove()) {
    System.out.println(i);
}
```

### OQueue Usage

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
