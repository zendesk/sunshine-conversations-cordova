# supportkit-cordova
Cordova (PhoneGap) bindings for SupportKit

# Basic Setup

## Install with Plugman

	cordova plugin add io.supportkit.sktcordovaplugin

## Init SupportKit with appToken

	SupportKit.init({
    	"appToken" : "your\_supportkit\_app\_token",
    	"conversationAccentColor" : "#FFFFFF" // optional, default is #00B0FF
	});

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

## Track events to show whispers

    SupportKit.track("Slapped kid");