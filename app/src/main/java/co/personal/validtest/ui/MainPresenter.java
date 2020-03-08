package co.personal.validtest.ui;

import android.content.Context;

import java.util.ArrayList;

import co.personal.validtest.insfraestructure.interfaces.SecurityRepository;
import co.personal.validtest.model.ResponseValid;
import co.personal.validtest.model.Artist;
import co.personal.validtest.networkservice.NetworkAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainPresenter {

    private MainView mView;
    private Context mContext;
    Retrofit mRetrofit;
    private SecurityRepository mSecurityRepository;

    public MainPresenter(MainView mView, Context mContext, Retrofit mRetrofit, SecurityRepository mSecurityRepository) {
        this.mView = mView;
        this.mContext = mContext;
        this.mRetrofit = mRetrofit;
        this.mSecurityRepository = mSecurityRepository;
    }

    public String setMessage(String message) {
        return message;
    }

    public void getService1() {
       Call call = mRetrofit.create(NetworkAPI.class).getService1();
        call.enqueue(new Callback<ResponseValid>() {
            @Override
            public void onResponse(Call<ResponseValid> call, Response<ResponseValid> response) {

                if(response.isSuccessful()){
                    ResponseValid mResponse = response.body();
                    mView.getDataService1(manipulateData(mResponse));
                }
            }

            @Override
            public void onFailure(Call<ResponseValid> call, Throwable t) {

            }
        });
    }

    ArrayList<Artist> manipulateData(ResponseValid resultData){
            ArrayList<Artist> mArtistList;
            mArtistList = new ArrayList();

            for (int i=0;i<resultData.getTopartists().getArtist().size();i++){
                mArtistList.add(resultData.getTopartists().getArtist().get(i));
            }
        return mArtistList;
    }
}
