package ir.clickyab.cordova;

import com.clickyab.ClickYabFullAd;
import android.app.Activity;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

public class MdClickyab extends CordovaPlugin
{
  static CallbackContext callbackContextKeepCallback;
  static Activity mActivity = null;

  public void initialize(CordovaInterface mCordovaInterface, CordovaWebView mCordovaWebView)
  {
    super.initialize(mCordovaInterface, mCordovaWebView);
  }

  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    if (action.equals("init"))
    {
      init(action, args, callbackContext);
      return true;
    }
    if (action.equals("showFullAd"))
    {
      showFullAd(action, args, callbackContext);
      return true;
    }
    return false;
  }

  public void init(String action, JSONArray args, CallbackContext callbackContext)
  {
    mActivity = this.cordova.getActivity();
    callbackContextKeepCallback = callbackContext;
  }


  public void showFullAd(String action, JSONArray args, CallbackContext callbackContext) throws JSONException
  {
	  final String token = args.getString(0);
	  ClickYabFullAd myads = new ClickYabFullAd(mActivity , token);
	  myads.show();
  }


  public void onPause(boolean paramBoolean) {
    super.onPause(paramBoolean);
  }

  public void onResume(boolean paramBoolean)
  {
    super.onResume(paramBoolean);
  }

  public void onDestroy()
  {
    super.onDestroy();
  }

}