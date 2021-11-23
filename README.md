# fobSolutionsTask

Requirements:
- First of all, if you want to work this project, you must have a Java and chromedriver. Chromedriver's version has to be same with your Google Chrome's version.

In this project, what do we test?
- We have 3 different scenarios, we are using TestNG for run our tests.

Scenario 1: Open wego.here.com and create a route between 2 locations and verify that different route options (Drive route, Public transport route, Bike route etc.) are calculated.
     We will create a route. User will go the the url and wait for the page load. I used threads for waiting functions. Afther that, user will choose the first location from the search,
and will click the first suggestion then user will enter the second location's name to search and will click the first suggestion again. 
Route options will be listed and we will check them.

Scenario 2: Open wego.here.com and sign in. Search a location and collect it (with the “star” on the UI). Verify from the “Collections” (option from the side menu) that collected place exists and that it is the place that was collected.
     In this scenario, our user will enter the url. User have to login for collect a location. So afer the login, user will search a location and collection it. After that, from the side
menu bar, user can go to the Collections. We will verify the collection here.

Scenario 3: Open www.gsmarena.com and search for a mobile device. Based on specifications, verify that the device supports GPS
     After our user go to the given url, we will make a search with a phone name. We will click the phone and from the specifications, we will check the GPS support.

