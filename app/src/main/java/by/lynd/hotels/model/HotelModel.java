package by.lynd.hotels.model;

import by.lynd.hotels.model.rest.RetroClient;
import retrofit2.Callback;

public class HotelModel implements Contract.Model{

    @Override
    public void loadHotels(Callback<HotelList> listOfHotels) {
        RetroClient.getStoreHotels(listOfHotels);
    }
}
