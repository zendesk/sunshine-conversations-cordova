# smooch-cordova
Cordova (PhoneGap) bindings for [Smooch](https://smooch.io).

# Basic Setup

## Install Smooch

For iOS: [http://docs.smooch.io/#manual-method](http://docs.smooch.io/#manual-method)
For Android: Gradle does the work for you!

## Install Cordova plugin

cordova plugin add cordova-plugin-smooch

You should now see smooch-cordova.js and the SmoochCordova source files in your project directory.

## Init Smooch with appToken

### iOS

In your javascript:

```js
Smooch.init({
  	"appToken" : "your-smooch-app-token",
  	"conversationAccentColor" : "#FFFFFF" // optional, default is #00B0FF
});
```

**IMPORTANT**: This call must be made **AFTER** the `deviceready` event of Cordova.

See [http://docs.smooch.io/api/ios/Classes/SKTSettings.html](http://docs.smooch.io/api/ios/Classes/SKTSettings.html) for other init settings.

### Android

In `io.smooch.cordova.SmoochApplication`, change `<your_app_token>` to your app token.

That's it!
See [http://docs.smooch.io/api/android/](http://docs.smooch.io/api/android/) for other init settings.

To enable push notifications, follow the docs [here](http://docs.smooch.io/android/#configuring-push-notifications).
You can safely ignore Step 3! That work has been done for you :)

## Show Smooch

Now, you're ready to show the Smooch chat window.

```js
Smooch.show();
```

# Awesome Setup

## Add user info

```js
Smooch.setUser({
	"firstName" : "Erlich",
	"lastName" : "Bachman",
	"email" : "erlich.bachman@aviato.com",
	"signedUpAt" : 1397606400000 // unix timestamp in milliseconds
});
```
## Add custom user properties

```js
Smooch.setUserProperties({
	"tv_show" : "Silicon Valley",
	"episodes" : "Server Space, The Lady, Bad Money",
	"net_worth" : 1000000
});
```

## Track events to show Smooch Whispers
```js
Smooch.track("Slapped kid");
```
