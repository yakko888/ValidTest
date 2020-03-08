package co.personal.validtest.aplication;

import javax.inject.Singleton;

import co.personal.validtest.ui.MainActivity;
import dagger.Component;

@Singleton
@Component(
        modules ={
                AppModule.class,
                NetModule.class,
                RepositoryModule.class,
                SqliteModule.class
        }
)


public interface AppComponent {
    void inject(MainActivity activity);
}