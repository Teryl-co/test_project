package by.lynd.hotels.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import by.lynd.hotels.contract.MainContract;
import retrofit2.Callback;

public class HotelList implements MainContract.Model {

    @SerializedName("hotels")
    @Expose
    private List<Hotel> hotels = null;

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    @Override
    public void loadHotels(Callback<HotelList> listOfHotels) {

    }
}
