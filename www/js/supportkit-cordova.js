var SupportKit = {

    init: function(settings, success, error) {
        cordova.exec(success, error, 'SupportKitCordova', 'init', [settings]);
    },

    show: function(success, error) {
        cordova.exec(success, error, "SupportKitCordova", "show", []);
    },
    
    showConversation: function(success, error) {
        cordova.exec(success, error, "SupportKitCordova", "showConversation", []);
    },

    setUser: function(user, success, error) {  
        cordova.exec(success, error, "SupportKitCordova", "setUser", [user]);
    },

    setUserProperties: function(properties, success, error) {  
        cordova.exec(success, error, "SupportKitCordova", "setUserProperties", [properties]);
    },

    track: function(eventName, success, error) {
        cordova.exec(success, error, "SupportKitCordova", "track", [eventName]);
    }
};
