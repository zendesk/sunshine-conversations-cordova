package io.supportkit.cordova;

import io.supportkit.core.*;
import io.supportkit.ui.ConversationActivity;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

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

public class SupportKitCordova extends CordovaPlugin {

	@Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("init")) {
            Log.w("SupportKitCordova", "Initialize must be done from the Application Class");
            return true;
        } else if (action.equals("show") || action.equals("showConversation")) {
            this.show(callbackContext);
        } else if (action.equals("setUser")) {
            this.setUser(args, callbackContext);
        } else if (action.equals("setUserProperties")) {
            this.setUserProperties(args, callbackContext);
        } else if (action.equals("track")) {
            this.track(args, callbackContext);
        } else {
        	callbackContext.error("SupportKit method not supported");
        	return false;
        }

        return true;
    }

    private void show(CallbackContext callbackContext) {
        ConversationActivity.show(this.cordova.getActivity());
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

    private void setUserProperties(JSONArray args, CallbackContext callbackContext) {
        try {
            Map<String, Object> customProps = new HashMap<String, Object>();
            customProps = toMap(args.getJSONObject(0));
            User.getCurrentUser().addProperties(customProps);

            callbackContext.success();
        } catch (JSONException e) {
            callbackContext.error(e.getMessage());
        }
    }

    private void track(JSONArray args, CallbackContext callbackContext) {
        try {
            String eventName = args.getString(0);
            SupportKit.track(eventName);

            callbackContext.success();
        } catch (JSONException e) {
            callbackContext.error(e.getMessage());
        }

    }

    private static Map<String, Object> toMap(JSONObject object) throws JSONException {
        Map<String, Object> map = new HashMap<String, Object>();

        Iterator<String> keysItr = object.keys();
        while(keysItr.hasNext()) {
            String key = keysItr.next();
            Object value = object.get(key);

            if(value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }

            else if(value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            map.put(key, value);
        }
        return map;
    }

    private static List<Object> toList(JSONArray array) throws JSONException {
        List<Object> list = new ArrayList<Object>();
        for(int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            if(value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }

            else if(value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            list.add(value);
        }
        return list;
    }
}