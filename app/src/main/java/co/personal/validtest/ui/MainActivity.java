package co.personal.validtest.ui;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
    public void getDataService1(List artistList) {
        List mData = new ArrayList(artistList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        ArtistAdapter adapter = new ArtistAdapter(this, mData);
        recyclerView.setAdapter(adapter);
    }
}

