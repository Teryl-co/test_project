package by.lynd.hotels.Model;

import by.lynd.hotels.JSON.RetroClient;
import retrofit2.Callback;

public class HotelModel implements Contract.Model{

    @Override
    public void loadHotels(Callback<HotelList> listOfHotels) {
        RetroClient.getStoreHotels(listOfHotels);
    }
}
