package co.personal.validtest.aplication;

import android.app.Application;

import javax.inject.Singleton;

import co.personal.validtest.insfraestructure.implementation.ImageManagerImpl;
import co.personal.validtest.insfraestructure.implementation.InternetManager;
import co.personal.validtest.insfraestructure.interfaces.ImageManagerLocal;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    protected Application mApplication;


    public AppModule(Application mAplication) {
        this.mApplication = mAplication;
    }

    @Provides
    @Singleton
    public Application providesApplication(){
        return mApplication;
    }

    @Provides
    @Singleton
    public ImageManagerLocal providesImageManager(Application application)
    {
        return new ImageManagerImpl(application);
    }

    @Provides
    @Singleton
    public InternetManager providesInternetManager(Application application)
    {
        return new InternetManager(application);
    }

}
