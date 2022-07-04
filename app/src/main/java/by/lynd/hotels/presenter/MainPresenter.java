package by.lynd.hotels.presenter;

import by.lynd.hotels.contract.MainContract;
import by.lynd.hotels.model.Hotel;
import by.lynd.hotels.model.HotelList;
import by.lynd.hotels.rest.RetroClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter {
  private static final String NO_AVAILABLE_HOTELS = "No available hotels";
  private static final String NO_AVAILABLE_SERVER = "Server is down";

  private MainContract.Model model;
  private MainContract.View activity;
  private List<Hotel> hotels;

  public MainPresenter(MainContract.View activity) {
    this.activity = activity;
    this.model = new RetroClient();
  }

  @Override
  public void getData() {
    model.loadHotels(
        new Callback<HotelList>() {
          @Override
          public void onResponse(Call<HotelList> call, Response<HotelList> response) {
            if (response.isSuccessful() && response.body() != null) {
              hotels = response.body().getHotels();
              activity.showHotels(hotels);
            } else if (response.body() == null) {
              activity.shotToast(NO_AVAILABLE_HOTELS);
            } else {
              activity.shotToast(NO_AVAILABLE_SERVER);
            }
          }

          @Override
          public void onFailure(Call<HotelList> call, Throwable t) {
            activity.shotToast(NO_AVAILABLE_SERVER);
          }
        });
  }

  @Override
  public void start() {
    if (activity.isTheListIsEmpty()) {
      getData();
    }
  }
}
