# Flows

Suspending functions returns only single values. If you want to return multiple values you can use collections.

## List
In this case the list values have to be created completely (hot) inside the suspend function.
If the computing of every entry is CPU intensive, we have to wait until the creation of the list is finished.

## Sequences
The values of the sequence will be created when they are used (cold). But the sequence builder is not suspendable, so the 
creation of the values will block the main thread.

## Flows
Flows are (like sequences) cold. The *flow* builder provides a suspend callback for the creation of the values.
So it will not block the thread.
Flows can be created also with *flowOf* (like *listOf*) or with the collection extension *asFlow*.