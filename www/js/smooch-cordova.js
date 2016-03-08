var Smooch = {
  init: function(settings, success, error) {
    //Initialization on Android must be done in Application Class.
    cordova.exec(success, error, 'SmoochCordova', 'init', [settings]);
  },

  show: function(success, error) {
    cordova.exec(success, error, "SmoochCordova", "show", []);
  },

  setUser: function(user, success, error) {
    cordova.exec(success, error, "SmoochCordova", "setUser", [user]);
  },

  setUserProperties: function(properties, success, error) {
    cordova.exec(success, error, "SmoochCordova", "setUserProperties", [properties]);
  },

  track: function(eventName, success, error) {
    cordova.exec(success, error, "SmoochCordova", "track", [eventName]);
  },

  login: function(userId, jwt, success, error) {
    cordova.exec(success, error, "SmoochCordova", "login", [userId, jwt]);
  },

  logout: function(success, error) {
    cordova.exec(success, error, "SmoochCordova", "logout", []);
  }
};

module.exports = Smooch;
