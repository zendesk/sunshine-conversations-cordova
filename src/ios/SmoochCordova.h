/*
 * SmoochCordova.h
 * Smooch Cordova/Phonegap Plugin
 *
 * Learn more and sign up at http://smooch.io
 *
*/

#import <Cordova/CDV.h>

@interface SmoochCordova : CDVPlugin

- (void)init:(CDVInvokedUrlCommand *)command;
- (void)show:(CDVInvokedUrlCommand *)command;
- (void)showConversation:(CDVInvokedUrlCommand* )command;
- (void)track:(CDVInvokedUrlCommand *)command;

- (void)setUser:(CDVInvokedUrlCommand *)command;
- (void)setUserProperties:(CDVInvokedUrlCommand *)command;

@end
