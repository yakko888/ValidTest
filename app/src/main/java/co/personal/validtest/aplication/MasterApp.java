package co.personal.validtest.aplication;

import static co.personal.validtest.utilities.Constants.BASE_URL;
import android.app.Application;

public class MasterApp extends Application{
    public static final String TAG = MasterApp.class.getName();

    private static String sCurrentScreenTag;
    private static AppComponent mAppComponent;

    public static AppComponent getAppComponent() {
        return mAppComponent;
    }

    public static void setCurrentScreenTag(String tag)
    {
        sCurrentScreenTag = tag;
    }

    public static boolean isApplicationRunning()
    {
        return sCurrentScreenTag != null;
    }


    @Override
    public void onCreate()
    {
        super.onCreate();

        initializeServices();
    }

    private void initializeServices() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(BASE_URL))
                .repositoryModule(new RepositoryModule())
                .build();
    }
}
