package by.lynd.hotels.JSON;


import java.util.Collection;
import java.util.Collections;
import java.util.List;
import by.lynd.hotels.Model.HotelList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetroClient {
    private static final String BASE_URL = "https://mocki.io/v1/";

    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

    public static ServiceApi getService() {
        return getRetrofitInstance().create(ServiceApi.class);
    }

    public static void getStoreHotels(Callback<HotelList> callback) {
        ServiceApi serviceApi = RetroClient.getService();
        Call<HotelList> call = serviceApi.loadHotels();
        call.enqueue(callback);
    }

}
