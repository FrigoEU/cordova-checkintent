package org.caresolutions.cordova.plugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.Intent;

import java.util.List;

/**
* This class checks if an intent is supported by Android
*/
public class CheckIntent extends CordovaPlugin {

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
      if (action.equals("checkIntent")) {
        String intentStr = args.getString(0);
        String typeStr = args.getString(1);
        Intent intent = new Intent(intentStr);
        intent.setType(typeStr);
        PackageManager manager = this.cordova.getActivity().getPackageManager();
        List<ResolveInfo> infos = manager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        if (infos.size() > 0) {
          callbackContext.success("true");
        } else {
          callbackContext.success("false");
        }
        return true;
      }
      return false;
  }
}
