/*
 * SupportKitCordova.m
 * SupportKit Cordova/Phonegap Plugin
 *
 * Learn more and sign up at http://supportkit.io
 *
*/

#import "SupportKitCordova.h"
#import <SupportKit/SupportKit.h>

@implementation SupportKitCordova

- (void)init:(CDVInvokedUrlCommand *)command {
    NSDictionary *settings = [command argumentAtIndex:0];
    
    SKTSettings *sktSettingsObj = [[SKTSettings alloc] init];
    [sktSettingsObj setValuesForKeysWithDictionary:settings];
    [SupportKit initWithSettings:sktSettingsObj];

    [self sendSuccess:command];
}

- (void)show:(CDVInvokedUrlCommand *)command {
    [SupportKit show];

    [self sendSuccess:command];
}

- (void)showConversation:(CDVInvokedUrlCommand *)command {
    [SupportKit showConversation];

    [self sendSuccess:command];
}

- (void)track:(CDVInvokedUrlCommand *)command {
    NSString *eventName = [command argumentAtIndex:0];
    [SupportKit track:eventName];

    [self sendSuccess:command];
}

#pragma mark - User

- (void)setUser:(CDVInvokedUrlCommand *)command {
    NSDictionary *user = [command argumentAtIndex:0];
    
    SKTUser *currentUser = [SKTUser currentUser];
    [currentUser setValuesForKeysWithDictionary:user];
    
    id timestamp = [user valueForKey:@"signedUpAt"];
    if (timestamp && [timestamp isKindOfClass:[NSNumber class]]) {
        [currentUser setSignedUpAt:[NSDate dateWithTimeIntervalSince1970:[timestamp doubleValue]]];
    }
}

- (void)setUserProperties:(CDVInvokedUrlCommand *)command {
    NSDictionary *properties = [command argumentAtIndex:0];

    SKTUser *currentUser = [SKTUser currentUser];
    [currentUser addProperties:properties];

    [self sendSuccess:command];
}

#pragma mark - Private Methods

- (void)sendSuccess:(CDVInvokedUrlCommand *)command {
    CDVPluginResult *pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
