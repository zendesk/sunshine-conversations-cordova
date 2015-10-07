# supportkit-cordova
Cordova (PhoneGap) bindings for SupportKit

# Basic Setup

## Install SupportKit

Install SupportKit by adding the require bundle and frameworks: [http://docs.supportkit.io/#manual-method](http://docs.supportkit.io/#manual-method)

## Install Cordova plugin

	cordova plugin add io.supportkit.sktcordovaplugin

## Init SupportKit with appToken

### iOS
	SupportKit.init({
    	"appToken" : "your-supportkit-app-token",
    	"conversationAccentColor" : "#FFFFFF" // optional, default is #00B0FF
	});

See [http://docs.supportkit.io/api/Classes/SKTSettings.html](http://docs.supportkit.io/api/Classes/SKTSettings.html) for init settings.

### Android

Init SupportKit in the Application class, for example:

	public class MainApplication extends Application {
	    public void onCreate() {
	        super.onCreate();
	        SupportKit.init(this, "your-supportkit-app-token");
	    }
	}

See [http://docs.supportkit.io/api/android/](http://docs.supportkit.io/api/android/) for init settings.


## Show SupportKit

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