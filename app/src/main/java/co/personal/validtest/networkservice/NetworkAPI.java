package co.personal.validtest.networkservice;

import co.personal.validtest.model.ResponseValid;
import co.personal.validtest.model.Topartists;
import co.personal.validtest.utilities.Constants;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface NetworkAPI {

    @Headers("Content-Type: application/json")
    @GET("?method=geo.gettopartists&country=spain&" + Constants.LOGIN_APIKEY + "&format=json")
    Call<ResponseValid> getService1();
}
