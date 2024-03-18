# Buffer

Assume that the production and the consumption of values takes both some time. Normally emitting new values
will be triggered if the collection of the last one is finished. 
So we need in this example for each value approx. 400ms. With *buffer* we can collect the next value(s) before the 
current value is processed.

Try it out.