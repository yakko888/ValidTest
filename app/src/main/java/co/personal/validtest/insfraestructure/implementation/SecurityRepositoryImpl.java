package co.personal.validtest.insfraestructure.implementation;

import co.personal.validtest.insfraestructure.interfaces.SecurityRepository;
import retrofit2.Retrofit;

public class SecurityRepositoryImpl implements SecurityRepository{

    protected static final String TAG = SecurityRepository.class.getSimpleName();
    Retrofit retrofit;

    public SecurityRepositoryImpl(Retrofit retrofit)
    {
        this.retrofit = retrofit;
    }
}
