package co.personal.validtest.aplication;

import javax.inject.Singleton;

import co.personal.validtest.insfraestructure.implementation.SecurityRepositoryImpl;
import co.personal.validtest.insfraestructure.interfaces.SecurityRepository;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public SecurityRepository provideSecurityRepository(Retrofit retrofit)
    {
        return new SecurityRepositoryImpl(retrofit);
    }
}
