# Processing latest value

*conflate* drops the emitted values which can't immediately processed. Another way is to cancel the processing
of the current value every time a new value is emitted. For this you can use the terminal operator *collectLatest*.

Try it out.