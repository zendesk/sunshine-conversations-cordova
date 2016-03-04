#!/usr/bin/env node

module.exports = function(context) {

  var fs = context.requireCordovaModule('fs'),
    path = context.requireCordovaModule('path');

  var platformRoot = path.join(context.opts.projectRoot, 'platforms/android');
  var manifestFile = path.join(platformRoot, 'AndroidManifest.xml');

  if (fs.existsSync(manifestFile)) {
    fs.readFile(manifestFile, 'utf8', function(err, data) {
      if (err) {
        throw new Error('Unable to find AndroidManifest.xml: ' + err);
      }

      var appClass = 'io.smooch.cordova.SmoochApplication';

      if (data.indexOf(appClass) != -1) {
        var result = data.replace('android:name="' + appClass + '"', '');

        fs.writeFile(manifestFile, result, 'utf8', function(err) {
          if (err)
            throw new Error('Unable to write into AndroidManifest.xml: ' + err);
        })
      }
    });
  }
};
