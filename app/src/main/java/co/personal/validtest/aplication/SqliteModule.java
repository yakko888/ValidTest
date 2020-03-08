package co.personal.validtest.aplication;

import android.content.Context;

import javax.inject.Singleton;

import co.personal.validtest.sqlite.SqliteHelper;
import dagger.Module;
import dagger.Provides;

@Module
public class SqliteModule {

    @Provides
    @Singleton
    public SqliteHelper provideSqliteRepository(Context mContext){
        return new SqliteHelper(mContext);
    }
}
