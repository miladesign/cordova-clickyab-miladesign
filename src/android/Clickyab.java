package ir.clickyab.cordova;

import com.clickyab.ClickYabFullAd;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

interface Plugin {
	public CordovaWebView getWebView();
	public CordovaInterface getCordova();
	public CallbackContext getCallbackContextKeepCallback();
}

interface PluginDelegate {
	public void _setUp();
	public void _showFullAd(String token);
    public void onPause(boolean multitasking);
    public void onResume(boolean multitasking);
    public void onDestroy();
}

public class Clickyab extends CordovaPlugin implements PluginDelegate, Plugin {
	protected CallbackContext callbackContextKeepCallback;
	protected PluginDelegate pluginDelegate;
	
	@Override
	public void pluginInitialize() {
		super.pluginInitialize();
	}	
		
	@Override
	public void onPause(boolean multitasking) {
		super.onPause(multitasking);
		pluginDelegate.onPause(multitasking);
	}
    
	@Override
	public void onResume(boolean multitasking) {
		super.onResume(multitasking);
		pluginDelegate.onResume(multitasking);
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		pluginDelegate.onDestroy();
	}

	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if ("setUp".equals(action)) {
			setUp(action, args, callbackContext);
			return true;
		}
		
		if ("showFullAd".equals(action)) {
			showFullAd(action, args, callbackContext);
			return true;
		}
		
		return false;
	}

	private void setUp(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
	    callbackContextKeepCallback = callbackContext;
	    cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_setUp();
			}
		});
	}

	private void showFullAd(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		final String token = args.getString(0);
	    cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				_showFullAd(token);
			}
		});
	}
	
	public CordovaWebView getWebView() {
		return webView;
	}

	public CordovaInterface getCordova() {
		return cordova;
	}

	public CallbackContext getCallbackContextKeepCallback() {
		return callbackContextKeepCallback;
	}
	
	/// Initialize
	public void _setUp() {
		pluginDelegate._setUp();
	}
	
	public void _showFullAd(String token) {
		ClickYabFullAd myads = new ClickYabFullAd(cordova.getActivity() , token);
		myads.show();
		pluginDelegate._showFullAd(token);
	}

}