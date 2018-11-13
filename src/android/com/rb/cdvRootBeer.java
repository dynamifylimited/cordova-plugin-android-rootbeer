/**
 */
package com.rb;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;
import com.scottyab.rootbeer.RootBeer;
import com.scottyab.rootbeer.util.Utils;
import java.util.HashMap;
import java.util.Map;

public class cdvRootBeer extends CordovaPlugin {

    private static final String TAG = "cdvRootBeer";

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        Log.d(TAG, "Initializing cdvRootBeer");
    }

    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        RootBeer rootBeer = new RootBeer(this.cordova.getActivity().getApplicationContext());

        switch (EvaluationType.toEvaluationType(action)) {
            case IS_ROOTED:
                try {
                    callbackContext.success(rootBeer.isRooted() ? "true" : "false");
                    Log.i(TAG, "isRooted  " + (rootBeer.isRooted()));
                } catch (Exception e) {
                    Log.e(TAG, "Error in isRooted" + e);
                    callbackContext.error("false");
                }
                break;
            case IS_ROOTED_WITHOUT_BUSY_BOX_CHECK:
                try {
                    callbackContext.success(rootBeer.isRootedWithoutBusyBoxCheck() ? "true" : "false");
                    Log.i(TAG, "Rooted without Busybox " + (rootBeer.isRootedWithoutBusyBoxCheck() ? "detected" : "not detected"));
                } catch (Exception e) {
                    Log.e(TAG, "Error" + e);
                    callbackContext.error("false");
                }
                break;
            case IS_SELINUX_FLAG_IN_ENABLED:
                try {
                    callbackContext.success(Utils.isSelinuxFlagInEnabled() ? "true" : "false");
                    Log.i(TAG, "SELinux Flag " + (Utils.isSelinuxFlagInEnabled() ? "Disabled" : "Enabled"));
                } catch (Exception e) {
                    Log.e(TAG, "Error" + e);
                    callbackContext.error("false");
                }
                break;
            case DETECT_ROOT_MANAGEMENT_APPS:
                try {
                    callbackContext.success(rootBeer.detectRootManagementApps() ? "true" : "false");
                    Log.i(TAG, "RootManagement Apps " + (rootBeer.detectRootManagementApps() ? "detected" : "not detected"));
                } catch (Exception e) {
                    Log.e(TAG, "Error" + e);
                    callbackContext.error("false");
                }
                break;
            case DETECT_POTENTIALLY_DANGEROUS_APPS:
                try {
                    callbackContext.success(rootBeer.detectPotentiallyDangerousApps() ? "true" : "false");
                    Log.i(TAG, "Potentially Dangerous Apps " + (rootBeer.detectPotentiallyDangerousApps() ? "detected" : "not detected"));
                } catch (Exception e) {
                    Log.e(TAG, "Error" + e);
                    callbackContext.error("false");
                }
                break;
            case DETECT_ROOT_CLOAKING_APPS:
                try {
                    callbackContext.success(rootBeer.detectRootCloakingApps() ? "true" : "false");
                    Log.i(TAG, "Root cloaking apps " + (rootBeer.detectRootCloakingApps() ? "detected" : "not detected"));
                } catch (Exception e) {
                    Log.e(TAG, "Error" + e);
                    callbackContext.error("false");
                }
                break;
            case CHECK_FOR_BUSY_BOX_BINARY:
                try {
                    callbackContext.success(rootBeer.checkForBusyBoxBinary() ? "true" : "false");
                    Log.i(TAG, "Busybox Check " + (rootBeer.checkForBusyBoxBinary() ? "detected" : "not detected"));
                } catch (Exception e) {
                    Log.e(TAG, "Error" + e);
                    callbackContext.error("false");
                }
                break;
            case CHECK_FOR_SU_BINARY:
                try {
                    callbackContext.success(rootBeer.checkForSuBinary() ? "true" : "false");
                    Log.i(TAG, "SU Binary Check " + (rootBeer.checkForSuBinary() ? "detected" : "not detected"));
                } catch (Exception e) {
                    Log.e(TAG, "Error" + e);
                    callbackContext.error("false");
                }
                break;
            case CHECK_SU_EXISTS:
                try {
                    callbackContext.success(rootBeer.checkSuExists() ? "true" : "false");
                    Log.i(TAG, "SU Binary Exists " + (rootBeer.checkSuExists() ? "detected" : "not detected"));
                } catch (Exception e) {
                    Log.e(TAG, "Error" + e);
                    callbackContext.error("false");
                }
                break;
            case CHECK_FOR_RW_PATHS:
                try {
                    callbackContext.success(rootBeer.checkForRWPaths() ? "true" : "false");
                    Log.i(TAG, "RW Paths " + (rootBeer.checkSuExists() ? "detected" : "not detected"));
                } catch (Exception e) {
                    Log.e(TAG, "Error" + e);
                    callbackContext.error("false");
                }
                break;
            case CHECK_FOR_DANGEROUS_PROPS:
                try {
                    callbackContext.success(rootBeer.checkForDangerousProps() ? "true" : "false");
                    Log.i(TAG, "Potentially Dangerous Props " + (rootBeer.checkForDangerousProps() ? "detected" : "not detected"));
                } catch (Exception e) {
                    Log.e(TAG, "Error" + e);
                    callbackContext.error("false");
                }
                break;
            case CHECK_FOR_ROOT_NATIVE:
                try {
                    callbackContext.success(rootBeer.checkForRootNative() ? "true" : "false");
                    Log.i(TAG, "Native Root " + (rootBeer.checkForRootNative() ? "detected" : "not detected"));
                } catch (Exception e) {
                    Log.e(TAG, "Error" + e);
                    callbackContext.error("false");
                }
                break;
            case DETECT_TEST_KEYS:
                try {
                    callbackContext.success(rootBeer.detectTestKeys() ? "true" : "false");
                    Log.i(TAG, "Detect Test Keys " + (rootBeer.detectTestKeys() ? "detected" : "not detected"));
                } catch (Exception e) {
                    Log.e(TAG, "Error" + e);
                    callbackContext.error("false");
                }
                break;
            case CHECK_FOR_MAGISK_BINARY:
                try {
                    callbackContext.success(rootBeer.checkForMagiskBinary() ? "true" : "false");
                    Log.i(TAG, "Magisk " + (rootBeer.checkForMagiskBinary() ? "detected" : "not detected"));
                } catch (Exception e) {
                    Log.e(TAG, "Error" + e);
                    callbackContext.error("false");
                }
                break;
            default:
                callbackContext.error("false");
        }

        return true;
    }

    private enum EvaluationType {
        IS_ROOTED("isRooted"),
        IS_ROOTED_WITHOUT_BUSY_BOX_CHECK("isRootedWithoutBusyBoxCheck"),
        IS_SELINUX_FLAG_IN_ENABLED("isSelinuxFlagInEnabled"),
        DETECT_ROOT_MANAGEMENT_APPS("detectRootManagementApps"),
        DETECT_POTENTIALLY_DANGEROUS_APPS("detectPotentiallyDangerousApps"),
        DETECT_TEST_KEYS("detectTestKeys"),
        DETECT_ROOT_CLOAKING_APPS("detectRootCloakingApps"),
        CHECK_FOR_BUSY_BOX_BINARY("checkForBusyBoxBinary"),
        CHECK_FOR_SU_BINARY("checkForSuBinary"),
        CHECK_SU_EXISTS("checkSuExists"),
        CHECK_FOR_RW_PATHS("checkForRWPaths"),
        CHECK_FOR_DANGEROUS_PROPS("checkForDangerousProps"),
        CHECK_FOR_ROOT_NATIVE("checkForRootNative"),
        CHECK_FOR_MAGISK_BINARY("checkForMagiskBinary"),
        NOVALUE("");

        private static final Map<String, EvaluationType> map;

        static {
            map = new HashMap<String, EvaluationType>();
            for (EvaluationType v : EvaluationType.values()) {
                map.put(v.valueType, v);
            }
        }

        private final String valueType;

        EvaluationType(final String type) {
            valueType = type;
        }

        public static EvaluationType toEvaluationType(String type) {
            try {
                return map.get(type);
            } catch (Exception ex) {
                return NOVALUE;
            }
        }

        @Override
        public String toString() {
            return valueType;
        }
    }

}
