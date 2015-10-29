var Smooch = {

    init: function(settings, success, error) {
        //Initialization on Android must be done in Application Class.
        cordova.exec(success, error, 'SmoochCordova', 'init', [settings]);
    },

    show: function(success, error) {
        cordova.exec(success, error, "SmoochCordova", "show", []);
    },
    
    showConversation: function(success, error) {
        cordova.exec(success, error, "SmoochCordova", "showConversation", []);
    },

    setUser: function(user, success, error) {  
        cordova.exec(success, error, "SmoochCordova", "setUser", [user]);
    },

    setUserProperties: function(properties, success, error) {  
        cordova.exec(success, error, "SmoochCordova", "setUserProperties", [properties]);
    },

    track: function(eventName, success, error) {
        cordova.exec(success, error, "SmoochCordova", "track", [eventName]);
    }
};
