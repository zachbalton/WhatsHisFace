# WhatsHisFace
WhatsHisFace is simply a personal learning project of mine for some newer Android features. The idea behind the app was to solve my 
constant problem of always forgetting the names of actors but remembering what  movies they're in. The user inputs Movie titles 
and the app cross checks the casts to make a best guess as to who the user is trying to think of.

### Development Goals:
The main goal is to learn Android's new [Data Binding Library](http://developer.android.com/tools/data-binding/guide.html) that Google
recently revealed and currently has available in beta. The introduction of data binding on Android allows for an intuitive implementation
of the MVVM pattern as well. Since I used MVP when I made the initial version of this app, I'm restructuring it with MVVM to better learn
the pattern and its place in Android development.


### Libraries:

Retrofit (http://square.github.io/retrofit/)

GSON (https://github.com/google/gson)

Logger (https://github.com/orhanobut/logger)

Picasso (http://square.github.io/picasso/)


### Other Resources

Remote data is retrieved from [Open Movie Database's](http://OMDbAPI.com) publically accessible REST API.
