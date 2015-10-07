# supportkit-cordova
Cordova (PhoneGap) bindings for [SupportKit](https://supportkit.io).

# Basic Setup

## Install SupportKit

Install SupportKit iOS or Android libraries,

On iOS: Nothing, you just need to init SupportKit (check below)

On Android: [http://docs.supportkit.io/android/#adding-supportkit-to-your-app](http://docs.supportkit.io/android/#adding-supportkit-to-your-app)

## Install Cordova plugin

	cordova plugin add io-supportkit-sktcordovaplugin

You should now see supportkit-cordova.js and the SupportKitCordova source files in your project directory.

## Init SupportKit with appToken

### iOS

In your javascript:

	SupportKit.init({
    	"appToken" : "your-supportkit-app-token",
    	"conversationAccentColor" : "#FFFFFF" // optional, default is #00B0FF
	});

**IMPORTANT**: This call must be made **AFTER** the `deviceready` event of Cordova.

See [http://docs.supportkit.io/api/Classes/SKTSettings.html](http://docs.supportkit.io/api/Classes/SKTSettings.html) for other init settings.

### Android

Init SupportKit(natively) in the Application class, for example:

	public class MainApplication extends Application {
	    public void onCreate() {
	        super.onCreate();
	        SupportKit.init(this, "your-supportkit-app-token");
	    }
	}

The javascript init call will not work in Android. It must be done natively.

See [http://docs.supportkit.io/api/android/](http://docs.supportkit.io/api/android/) for other init settings.


## Show SupportKit

Now, you're ready to show the SupportKit chat window.

	SupportKit.show();

# Awesome Setup

## Add user info

	SupportKit.setUser({
		"firstName" : "Erlich",
		"lastName" : "Bachman",
		"email" : "erlich.bachman@aviato.com",
		"signedUpAt" : 1397606400000 // unix timestamp in milliseconds
	});

## Add custom user properties

	SupportKit.setUserProperties({
		"tv_show" : "Silicon Valley",
		"episodes" : "Server Space, The Lady, Bad Money",
		"net_worth" : 1000000
	});

## Track events to show SupportKit Whispers

    SupportKit.track("Slapped kid");

## Set Default Recommended Articles (iOS only)

	SupportKit.setDefaultRecommendations(["http://m.imdb.com/name/nm3042755", "http://m.imdb.com/name/nm2554352"])

## Set Top Recommended Article (iOS only)

	SupportKit.setTopRecommendation("https://supportkit.zendesk.com/hc/en-us/articles/201900704-Giving-your-users-the-right-answer-at-the-right-time")
