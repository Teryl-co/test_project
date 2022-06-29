package by.lynd.hotels.presenters;

import java.util.List;

import by.lynd.hotels.Model.Contract;
import by.lynd.hotels.Model.Hotel;
import by.lynd.hotels.Model.HotelList;
import by.lynd.hotels.Model.HotelModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter implements Contract.Presenter{
    private Contract.View activity;
    private Contract.Model model;

    private List<Hotel> hotels;

    public Presenter(Contract.View activity) {
        this.activity = activity;
        this.model = new HotelModel();
        init();
    }

    @Override
    public void onItemWasClicked(int position) {
        Hotel hotel = hotels.get(position);
        activity.sendIntent(hotel);
    }

    @Override
    public void onDestroy() {

    }

    private void init() {
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
                t.printStackTrace();
            }
        });
    }
}
