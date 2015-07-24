# supportkit-cordova
Cordova (PhoneGap) bindings for SupportKit

# Basic Setup

## Install SupportKit

Install SupportKit by adding the require bundle and frameworks: [http://docs.supportkit.io/#manual-method](http://docs.supportkit.io/#manual-method)

## Install Cordova plugin

	cordova plugin add io.supportkit.sktcordovaplugin

Then copy the [`supportkit-cordova.js`](https://github.com/supportkit/supportkit-cordova/blob/master/www/js/supportkit-cordova.js) file from the `www/js` directory of this repo into the `www` directory (or the directory of your choice) of your Cordova app.

Then import the `supportkit-cordova.js` file in the `index.html` of your Cordova app:

	<script type="text/javascript" src="supportkit-cordova.js"></script>

**IMPORTANT**: This import must be made **AFTER** the import of `cordova.js`. 

## Init SupportKit with appToken

	SupportKit.init({
    	"appToken" : "your-supportkit-app-token",
    	"conversationAccentColor" : "#FFFFFF" // optional, default is #00B0FF
	});
	
**IMPORTANT**: This call or any other SupportKit calls must be made **AFTER** the `deviceready` event of Cordova.

See [http://docs.supportkit.io/api/Classes/SKTSettings.html](http://docs.supportkit.io/api/Classes/SKTSettings.html) for other properties you can set. 

## Show SupportKit

	SupportKit.show();

# Awesome Setup

## Add user info

	SupportKit.setUser({
		"firstName" : "Erlich",
		"lastName" : "Bachman",
		"email" : "erlich.bachman@aviato.com",
		"signedUpAt" : 1397606400 // unix timestamp
	});

## Add custom user properties

	SupportKit.setUserProperties({
		"tv_show" : "Silicon Valley",
		"episodes" : "Server Space, The Lady, Bad Money",
		"net_worth" : 1000000
	});

## Track events to show SupportKit Whispers

    SupportKit.track("Slapped kid");

## Set Default Recommended Articles
	
	SupportKit.setDefaultRecommendations(["http://m.imdb.com/name/nm3042755", "http://m.imdb.com/name/nm2554352"])

## Set Top Recommended Article

	SupportKit.setTopRecommendation("https://supportkit.zendesk.com/hc/en-us/articles/201900704-Giving-your-users-the-right-answer-at-the-right-time")
