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

- (void)init:(CDVInvokedUrlCommand*)command {

    NSString *appToken = [command.arguments objectAtIndex:0];
    NSMutableDictionary *settingsDict = nil;

    if([command.arguments count] > 1) {
      settingsDict = [[command.arguments objectAtIndex:1 withDefault:nil] mutableCopy];
    }

    if (!settingsDict) {
        settingsDict = [[NSMutableDictionary alloc] init];
    }

    [SupportKit init:[SKTSettings settingsWithAppToken:appToken]];
}

- (void) show:(CDVInvokedUrlCommand*)command {
    [SupportKit show];
}

- (void)showConversation:(CDVInvokedUrlCommand*)command {
    [SupportKit showConversation];
}

- (void)setNameAndEmail:(CDVInvokedUrlCommand*)command {
    NSString *firstName = [command.arguments objectAtIndex:0];
    NSString *lastName = [command.arguments objectAtIndex:1];
    NSString *email = [command.arguments objectAtIndex:2];

    SKTUser* curUser = [SKTUser currentUser];
    curUser.firstName = firstName;
    curUser.lastName = lastName;
    curUser.email = email;
}

- (void)track:(CDVInvokedUrlCommand*)command {
    NSString *eventName = [command.arguments objectAtIndex:0];
    [SupportKit track:eventName];
}

@end
