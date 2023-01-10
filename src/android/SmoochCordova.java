package io.smooch.cordova;

import io.smooch.core.*;
import io.smooch.ui.ConversationActivity;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SmoochCordova extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("init")) {
            Log.w("SmoochCordova", "Initialize must be done from the Application Class");
            callbackContext.success();
            return true;
        } else if (action.equals("show")) {
            this.show(callbackContext);
        } else if (action.equals("setUser")) {
            this.setUser(args, callbackContext);
        } else if (action.equals("setUserProperties")) {
            this.setUserProperties(args, callbackContext);
        } else if (action.equals("getUserProperties")) {
            this.getUserProperties(callbackContext);
        } else if (action.equals("login")) {
            this.login(args, callbackContext);
        } else if (action.equals("logout")) {
            this.logout(callbackContext);
        } else {
            callbackContext.error("Smooch method not supported");
            return false;
        }

        return true;
    }

    private void show(CallbackContext callbackContext) {
//        ConversationActivity.show(this.cordova.getActivity());
        ConversationActivity.builder()
                .withFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .show(this.cordova.getActivity()
                .getApplicationContext());
        callbackContext.success();

    }

    private void setUser(JSONArray args, CallbackContext callbackContext) {
        try {
            JSONObject userInfo = args.getJSONObject(0);
            final User user = User.getCurrentUser();

            if (userInfo.has("email")) {
                user.setEmail(userInfo.getString("email"));
            }
            if (userInfo.has("firstName")) {
                user.setFirstName(userInfo.getString("firstName"));
            }
            if (userInfo.has("lastName")) {
                user.setLastName(userInfo.getString("lastName"));
            }
            if (userInfo.has("signedUpAt")) {
                user.setSignedUpAt(new Date(userInfo.getLong("signedUpAt")));
            }

            callbackContext.success();
        } catch (JSONException e) {
            callbackContext.error(e.getMessage());
        }
    }

    private void getUserProperties( CallbackContext callbackContext) {
        Log.d("Zingle", "getUserProperties called from Java " + User.getCurrentUser().getMetadata().toString());
        Map<String, Object> userMetaData = new HashMap<String, Object>();
        userMetaData = User.getCurrentUser().getMetadata();

        JSONObject metaDataObject = new JSONObject(userMetaData);
        callbackContext.success(metaDataObject);
    }

    private void setUserProperties(JSONArray args, CallbackContext callbackContext) {
        try {
            Map<String, Object> customProps = new HashMap<String, Object>();
            customProps = toMap(args.getJSONObject(0));
            User.getCurrentUser().addMetadata(customProps);
                    //.addProperties(customProps);

            callbackContext.success();
        } catch (JSONException e) {
            callbackContext.error(e.getMessage());
        }
    }

    private void login(JSONArray args, final CallbackContext callbackContext) {
        try {
            final String userId = args.getString(0);
            String jwt = args.getString(1);

            if (userId.equals("null")) {
                Log.w("SmoochCordova", "You must provide a userId when logging in.");
                return;
            }

            if (jwt.equals("null")) {
                Log.w("SmoochCordova", "You must provide a jwt when logging in.");
                return;
            }

            Smooch.login(userId, jwt, new SmoochCallback() {
                @Override
                public void run(Response response) {
                    if (response.getError() == null) {
                        callbackContext.success();
                    } else {
                        callbackContext.error(response.getError());
                    }
                }
            });
        } catch (JSONException e) {
            callbackContext.error(e.getMessage());
        }
    }

    private void logout(final CallbackContext callbackContext) {
        Smooch.logout(new SmoochCallback() {
            @Override
            public void run(Response response) {
                if (response.getError() == null) {
                    callbackContext.success();
                } else {
                    callbackContext.error(response.getError());
                }
            }
        });
    }

    private static Map<String, Object> toMap(JSONObject object) throws JSONException {
        Map<String, Object> map = new HashMap<String, Object>();

        Iterator<String> keysItr = object.keys();
        while (keysItr.hasNext()) {
            String key = keysItr.next();
            Object value = object.get(key);

            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            map.put(key, value);
        }
        return map;
    }

    private static List<Object> toList(JSONArray array) throws JSONException {
        List<Object> list = new ArrayList<Object>();
        for (int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            list.add(value);
        }
        return list;
    }
}
