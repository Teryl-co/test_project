package by.lynd.hotels.presenter;

import java.util.List;

import by.lynd.hotels.contract.MainContract;
import by.lynd.hotels.model.Hotel;
import by.lynd.hotels.model.HotelList;
import by.lynd.hotels.rest.RetroClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View activity;
    private MainContract.Model model;

    private boolean isLoading = false;

    private List<Hotel> hotels;

    public MainPresenter(MainContract.View activity) {
        this.activity = activity;
        this.model = new RetroClient();
    }

    @Override
    public void getData() {
        model.loadHotels(new Callback<HotelList>() {
            @Override
            public void onResponse(Call<HotelList> call, Response<HotelList> response) {
                if (response.isSuccessful() && response.body() != null) {
                    hotels = response.body().getHotels();
                    activity.showHotels(hotels);
                }
            }

            @Override
            public void onFailure(Call<HotelList> call, Throwable t) {

            }
        });
    }
}
