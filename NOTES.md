
# MVVM Repository Pattern.
The project is divided in to 4 layers: The Model layer where the data presented in the application are present.
The Repository layer where the api call objects are accessed. 
The ViewModel layer which handles the information presented
The View layer where the fragments which are responsible for receiving and presenting data received
from the ViewModel layer. 

# Internet Validity.
There is also a layer between the ViewModel and Fragment used to check and make sure that 
there is an internet connection and if it's actually connected to the internet by pinging
google servers.
ConnectionLiveData which checks if there is network connectivity using ConnectivityManager 
and DoesNetworkHaveInternet which pings google servers
inside networkutils folder.
Source for this code: Mitch Tabian/CodingWithMitch Youtube channel.

Kotlin Coroutines to fetch the data using suspend functions and coroutine scopes aka viewModelScope etc.

# Navigation.
Android Jetpack Navigation component to navigate between screens. Navigation safe args to send
arguments/data from the ListFragment to the DetailFragment by serializing the Model Data Class
and passing it to the args.

# Utility
Util class for Glide image processing and ProgressDrawable to display a circle drawable before
an image is loaded in to view.

RecyclerView to display the list of Beauty Products with all the information.

# Unit Tests.
There was an attempt to implement Unit Tests using Google Truth for Assertion, Robolectric, Android Core and JUnit.
To create efficient and logical tests, I would need to study the necessary documentation.
I did attempt a test to check if data is being received which should pass if there is an internet connection
and fail if the internet is not connected.


# Layout.
Coordinator Layout with disappearing toolbars and fading image if scrolled to the bottom in Detail Fragment.
CardView for the list Item.
I thought these were cool UI details.
Configuration/Screen Orientation changes are handled by configChanges inside the Android Manifest.

ViewBinding was used to bind the views to the data.

# Future Improvements
Implement Unit/Integration/UI Tests.
Show loading/Error loading views if there is no internet connection on start up.


# How To Use
A click/tap on a list item will take the user to the details of the item that was tapped.
The detail view should show an image, the name of the product, the price and the details about the item.
You can scroll down to see more of the detail text which will in turn cause the image to fade
in to the toolbar.
You can navigate back to the previous screen either with the toolbar button or the back button on your phone.

Tested on OnePlus 5T A5010
