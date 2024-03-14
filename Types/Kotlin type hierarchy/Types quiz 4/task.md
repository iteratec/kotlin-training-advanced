You work with a magnificent 3rd party library and you've encountered the following function:

```kotlin
// Sends all emails from the queue, no arguments needed
fun sendEmails(x: Nothing?) {
    println("All emails sent!")
}
```
You really need to call this function from your code. What would be the correct way to do that?