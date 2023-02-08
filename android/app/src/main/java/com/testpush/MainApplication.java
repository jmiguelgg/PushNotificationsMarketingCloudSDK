package com.testpush;

import android.app.Application;
import android.util.Log;

import com.facebook.react.PackageList;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint;
import com.facebook.react.defaults.DefaultReactNativeHost;
import com.facebook.soloader.SoLoader;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.notifications.NotificationCustomizationOptions;

import java.util.List;

public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost =
      new DefaultReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
          return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
          @SuppressWarnings("UnnecessaryLocalVariable")
          List<ReactPackage> packages = new PackageList(this).getPackages();
          // Packages that cannot be autolinked yet can be added manually here, for example:
          // packages.add(new MyReactNativePackage());
          return packages;
        }

        @Override
        protected String getJSMainModuleName() {
          return "index";
        }

        @Override
        protected boolean isNewArchEnabled() {
          return BuildConfig.IS_NEW_ARCHITECTURE_ENABLED;
        }

        @Override
        protected Boolean isHermesEnabled() {
          return BuildConfig.IS_HERMES_ENABLED;
        }
      };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);
    MarketingCloudSdk.init(this,
            MarketingCloudConfig.builder()
                    .setApplicationId("1ab557be-899f-4e6b-b9f2-6b440a82c1a5")
                    .setAccessToken("6lWOsJKQEb7MZgkYc3lUwzdR")
                    .setSenderId("AAAAaqYkHrc:APA91bHHkg-vlDh1dal0XgLZb2fP_W4vpEfj3rfkB2pto6nyEodZuPUVcT0LmFVyocIJz3oLumDXaLpsv0iQ88cblhsCmMk82bJYE-8baMfN_gT-BvPTya8YvQCROsppu-624hBebvOC")
                    .setMarketingCloudServerUrl("https://mcmqczd118jdz8xqdfsbxdwh96f0.device.marketingcloudapis.com/")
                    .setNotificationCustomizationOptions(NotificationCustomizationOptions.create(R.drawable.common_google_signin_btn_icon_disabled))
                    .setAnalyticsEnabled(true)
                    .setGeofencingEnabled(true)
                    .setInboxEnabled(true)
                    .setDelayRegistrationUntilContactKeyIsSet(true)
                    .build(this),
            initializationStatus -> Log.e("[MainApplication]: INIT", initializationStatus.toString()));
    if (BuildConfig.IS_NEW_ARCHITECTURE_ENABLED) {
      // If you opted-in for the New Architecture, we load the native entry point for this app.
      DefaultNewArchitectureEntryPoint.load();
    }
    ReactNativeFlipper.initializeFlipper(this, getReactNativeHost().getReactInstanceManager());
  }
}
