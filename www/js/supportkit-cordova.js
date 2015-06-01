var SupportKit = {

    init: function (appToken, settings) {
        if (settings && typeof settings === "object") {
            cordova.exec (null, null, "SupportKitCordova", "init", [appToken, settings]);
        } else {
            cordova.exec (null, null, "SupportKitCordova", "init", [appToken]);
        }
    },

    showConversation: function () {
        cordova.exec (null, null, "SupportKitCordova", "showConversation", []);
    },

    show: function () {
        cordova.exec (null, null, "SupportKitCordova", "show", []);
    },

    setNameAndEmail: function (firstName, lastName, email) {
        var lFirstName = "";
        var lLastName = "";
        var lEmail = "";

        if (firstName && typeof firstName === "string") {
            lFirstName = name;
        }
        if (lastName && typeof lastName === "string") {
            lLastName = email;
        }
        if (email && typeof email === "string") {
            lEmail = email;
        }        
        cordova.exec (null, null, "SupportKitCordova", "setNameAndEmail", [lFirstName, lLastName, lEmail]);
    },

    track: function (eventName) {
        if (eventName && typeof eventName === "string") {
            cordova.exec (null, null, "SupportKitCordova", "track", [eventName]);
        }
    }
};
