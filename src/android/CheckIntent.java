package org.apache.cordova.plugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.pm;

/**
* This class checks if an intent is supported by Android
*/
public class CheckIntent extends CordovaPlugin {

@Override
public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    if (action.equals("checkIntent")) {
      String intent = args.getString(0);
      PackageManager manager = context.getPackageManager();
      List<ResolveInfo> infos = manager.queryIntentActivities(intent, 0);
      if (infos.size() > 0) {
        callbackContext.success(true);
      } else {
        callbackContext.success(false);
      }
      return true;
    }
    return false;
}
