/*
 * SupportKitCordova.h
 * SupportKit Cordova/Phonegap Plugin
 *
 * Learn more and sign up at http://supportkit.io
 *
*/

#import <Cordova/CDV.h>

@interface SupportKitCordova : CDVPlugin

- (void)init:(CDVInvokedUrlCommand *)command;
- (void)show:(CDVInvokedUrlCommand *)command;
- (void)showConversation:(CDVInvokedUrlCommand* )command;
- (void)track:(CDVInvokedUrlCommand *)command;

- (void)setUser:(CDVInvokedUrlCommand *)command;
- (void)setUserProperties:(CDVInvokedUrlCommand *)command;

- (void)setDefaultRecommendations:(CDVInvokedUrlCommand *)command;
- (void)setTopRecommendation:(CDVInvokedUrlCommand *)command;
@end
