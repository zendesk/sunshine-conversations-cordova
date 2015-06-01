/*
 * SupportKitCordova.h
 * SupportKit Cordova/Phonegap Plugin
 *
 * Learn more and sign up at http://supportkit.io
 *
*/

#import <Cordova/CDV.h>

@interface SupportKitCordova : CDVPlugin

- (void) init:(CDVInvokedUrlCommand*)command;

- (void) show:(CDVInvokedUrlCommand*)command;

- (void) showConversation:(CDVInvokedUrlCommand*)command;

- (void) setNameAndEmail:(CDVInvokedUrlCommand*)command;

- (void) track:(CDVInvokedUrlCommand*)command;

@end
