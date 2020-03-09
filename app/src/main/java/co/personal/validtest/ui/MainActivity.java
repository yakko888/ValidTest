package co.personal.validtest.ui;
import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import co.personal.validtest.R;
import co.personal.validtest.adapter.ArtistAdapter;
import co.personal.validtest.aplication.MasterApp;
import co.personal.validtest.databinding.ActivityMainBinding;
import co.personal.validtest.insfraestructure.interfaces.SecurityRepository;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements MainView {

    ActivityMainBinding mBinding;
    MainPresenter mPresenter;
    public List mData;
    ProgressDialog pd;

    @Inject
    public Retrofit mRetrofit;

    @Inject
    public SecurityRepository mSecurityRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        MasterApp.getAppComponent().inject(this);

        initDatabinding();

    }

    private void initDatabinding() {
        mPresenter = new MainPresenter(this,this, mRetrofit,mSecurityRepository);
        mBinding.setPresenter(mPresenter);
        mPresenter.getService1();
    }

    @Override
    public void getDataReciclerView(List artistList) {
        mData = new ArrayList(artistList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        ArtistAdapter adapter = new ArtistAdapter(this, mData);
        recyclerView.setAdapter(adapter);

        //guardado en sqlite
        if(mPresenter.getDataSqlite()<=0){
            mPresenter.saveDataToSqlite(mData);
            Toast.makeText(this,"Datos guardados en el sqlite",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgressBar() {
        mBinding.prgDialog.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mBinding.prgDialog.setVisibility(View.INVISIBLE);
    }
}

