package by.lynd.hotels.Model;

import java.util.List;

import by.lynd.hotels.JSON.RetroClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HotelModel implements Contract.Model{
    private Callback<HotelList> listOfHotels;
    private List<Hotel> hotels;

    @Override
    public List<Hotel> loadHotels() {
        initCallBack();
        RetroClient.getStoreHotels(listOfHotels);
        return hotels;
    }

    private void initCallBack() {
        listOfHotels = new Callback<HotelList>() {
            @Override
            public void onResponse(Call<HotelList> call, Response<HotelList> response) {
                if (response.isSuccessful()) {
                    hotels = response.body().getHotels();
                }
            }

            @Override
            public void onFailure(Call<HotelList> call, Throwable t) {
                t.printStackTrace();
            }
        };
    }
}
