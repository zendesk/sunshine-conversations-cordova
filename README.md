> Maintainer needed. PRs welcomed. If you actively use this and want to become a maintainer let us know at help@smooch.io.

# smooch-cordova
Cordova (PhoneGap) bindings for [Smooch](https://smooch.io).

# Basic Setup

## Install Smooch

For iOS: [http://docs.smooch.io/#manual-method](http://docs.smooch.io/#manual-method)

For Android: Gradle does the work for you!

## Install Cordova plugin

cordova plugin add smooch-cordova

You should now see smooch-cordova.js and the SmoochCordova source files in your project directory.

## Init Smooch with appId

### iOS

In your javascript:

```js
Smooch.init({
  	"appId" : "your-smooch-app-id",
  	"conversationAccentColor" : "#FFFFFF" // optional, default is #00B0FF
});
```

**IMPORTANT**: This call must be made **AFTER** the `deviceready` event of Cordova.

See [http://docs.smooch.io/api/ios/Classes/SKTSettings.html](http://docs.smooch.io/api/ios/Classes/SKTSettings.html) for other init settings.

### Android

In `io.smooch.cordova.SmoochApplication.java`, change `<your_app_id>` to your app id. This file is located inside the `src` folder of the android project.

Locate the file called AndroidManifest.xml in the root of your Android project. Inside the `<application>` tag, add `android:name="io.smooch.cordova.SmoochApplication"`

That's it!
See [http://docs.smooch.io/api/android/](http://docs.smooch.io/api/android/) for other init settings.

To enable push notifications, follow the docs [here](http://docs.smooch.io/android/#configuring-push-notifications).

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

## Login

With JWT:
```js
Smooch.login("userId", "jwt");
```

Without:
```js
Smooch.login("userId");
```

# Common errors

If you stumble upon this error when building for android:
```
Error: /yourapp/platforms/android/gradlew: Command failed with exit code 1 Error output:
/yourapp/platforms/android/build/intermediates/res/merged/debug/values-v26/values-v26.xml:15:21-54: AAPT: No resource found that matches the given name: attr 'android:keyboardNavigationCluster'.

/yourapp/platforms/android/build/intermediates/res/merged/debug/values-v26/values-v26.xml:15: error: Error: No resource found that matches the given name: attr 'android:keyboardNavigationCluster'.

FAILURE: Build failed with an exception.
```

Make sure to set the target to `android-26` in `platforms/android/project-properties`
