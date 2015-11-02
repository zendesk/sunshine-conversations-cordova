# smooch-cordova
Cordova (PhoneGap) bindings for [Smooch](https://smooch.io).

# Basic Setup

## Install Smooch

Install Smooch iOS or Android libraries,

On iOS: [http://docs.smooch.io/#manual-method](http://docs.smooch.io/#manual-method)

On Android: [http://docs.smooch.io/android/#adding-smooch-to-your-app](http://docs.smooch.io/android/#adding-smooch-to-your-app)

## Install Cordova plugin

	cordova plugin add io-smooch-smcordovaplugin

You should now see smooch-cordova.js and the SmoochCordova source files in your project directory.

## Init Smooch with appToken

### iOS

In your javascript:

	Smooch.init({
    	"appToken" : "your-smooch-app-token",
    	"conversationAccentColor" : "#FFFFFF" // optional, default is #00B0FF
	});
	
**IMPORTANT**: This call must be made **AFTER** the `deviceready` event of Cordova.

See [http://docs.smooch.io/api/Classes/SKTSettings.html](http://docs.smooch.io/api/Classes/SKTSettings.html) for other init settings.

### Android

Init Smooch(natively) in the Application class, for example:

	public class MainApplication extends Application {
	    public void onCreate() {
	        super.onCreate();
	        Smooch.init(this, "your-smooch-app-token");
	    }
	}

The javascript init call will not work in Android. It must be done natively.

See [http://docs.smooch.io/api/android/](http://docs.smooch.io/api/android/) for other init settings.


## Show Smooch

Now, you're ready to show the Smooch chat window.

	Smooch.show();

# Awesome Setup

## Add user info

	Smooch.setUser({
		"firstName" : "Erlich",
		"lastName" : "Bachman",
		"email" : "erlich.bachman@aviato.com",
		"signedUpAt" : 1397606400000 // unix timestamp in milliseconds
	});

## Add custom user properties

	Smooch.setUserProperties({
		"tv_show" : "Silicon Valley",
		"episodes" : "Server Space, The Lady, Bad Money",
		"net_worth" : 1000000
	});

## Track events to show Smooch Whispers

    Smooch.track("Slapped kid");
