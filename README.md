# PecodeTestTask

A Simple Android Mobile Application which implement navigation between fragments and their creation/removing.


### Technologies & Methodologies which used:
- Kotlin
- Material UI
- Android SDK

### The App Scenario

The application has few different buttons:
1) “+” — create a new fragment with max page the number +1. Clicking on "+" on page 1 will create a page with the number 2. clicking again will create a page with the number 3 and so on.
2) “Create new notification” — clicking on this button will create a notification with the text "notification and the
   number of pages".
3) “-” — will delete the last fragment, all notifications which were created from that fragment. Also
   if you click “-” on last fragment program should scroll to previous fragment.
   User will be able to navigate  all fragments. (create ViewPager with possibility swipe right/left)

Clicking on a notification will open a fragment with the same page number where that notification was
created. App will be save created fragments if you reopen it.

### Supported Android Versions

Targets Android Version:
- Android 11.0 ( R ), (API level 30)

Minimum Android Version:
- Android 5.0 (Lollipop), (API level 21) 