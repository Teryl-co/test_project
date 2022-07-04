package by.lynd.hotels.rest;

import by.lynd.hotels.contract.MainContract;
import by.lynd.hotels.model.HotelList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient implements MainContract.Model {
  private static final String BASE_URL = "https://mocki.io/v1/";

  private static Retrofit getRetrofitInstance() {
    return new Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build();
  }

  private static ServiceApi getService() {
    return getRetrofitInstance().create(ServiceApi.class);
  }

  @Override
  public void loadHotels(Callback<HotelList> callback) {
    ServiceApi serviceApi = RetroClient.getService();
    Call<HotelList> call = serviceApi.loadHotels();
    call.enqueue(callback);
  }
}
