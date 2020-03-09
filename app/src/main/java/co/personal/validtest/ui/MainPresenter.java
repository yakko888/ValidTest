package co.personal.validtest.ui;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import co.personal.validtest.insfraestructure.implementation.InternetManager;
import co.personal.validtest.insfraestructure.interfaces.SecurityRepository;
import co.personal.validtest.model.Picture;
import co.personal.validtest.model.ResponseValid;
import co.personal.validtest.model.Artist;
import co.personal.validtest.networkservice.NetworkAPI;
import co.personal.validtest.sqlite.SqliteController;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainPresenter {

    private MainView mView;
    private Context mContext;
    Retrofit mRetrofit;
    InternetManager mInternetManager;
    private SecurityRepository mSecurityRepository;
    SqliteController mSqliteController;


    public MainPresenter(MainView mView, Context mContext, Retrofit mRetrofit, SecurityRepository mSecurityRepository) {
        this.mView = mView;
        this.mContext = mContext;
        this.mRetrofit = mRetrofit;
        this.mSecurityRepository = mSecurityRepository;
        mInternetManager = new InternetManager(mContext);
        mSqliteController = new SqliteController(mContext);
    }

    public String setMessage(String message) {
        return message;
    }

    public void getService1() {

        if(mInternetManager.isOnline()){
            mView.showProgressBar();
            Call call = mRetrofit.create(NetworkAPI.class).getService1();
            call.enqueue(new Callback<ResponseValid>() {
                @Override
                public void onResponse(Call<ResponseValid> call, Response<ResponseValid> response) {

                    if(response.isSuccessful()){
                        mView.hideProgressBar();
                        ResponseValid mResponse = response.body();
                        mView.getDataReciclerView(manipulateData(mResponse));
                    }
                }

                @Override
                public void onFailure(Call<ResponseValid> call, Throwable t) {

                }
            });
        }else{
            if(mSqliteController.getDataExistSqlite()>0){

                mView.getDataReciclerView(mSqliteController.getAllDataSqlite());
                mView.showMessage("Datos reflejados estan ubicados localmente, no poseé internet en este momento..");

            }else{
                mView.showMessage("No posee y internet y no posee datos registrados localmente....");
            }
        }
    }

    ArrayList<Picture> manipulateData(ResponseValid resultData){

        ArrayList<Picture> datos = new ArrayList<>();

        for(int i=0; i<resultData.getTopartists().getArtist().size();i++){

            datos.add(new Picture(resultData.getTopartists().getArtist().get(i).getName(),resultData.getTopartists().getArtist().get(i).getUrl()));
        }

        return datos;
    }

    public int getDataSqlite() {
        return mSqliteController.getDataExistSqlite();
    }

    public boolean saveDataToSqlite(List data){
        return mSqliteController.saveToSqlite(data);
    }
}
