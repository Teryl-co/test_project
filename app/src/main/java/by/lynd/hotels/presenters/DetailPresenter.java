package by.lynd.hotels.presenters;

import android.content.Intent;

import by.lynd.hotels.model.Contract;
import by.lynd.hotels.model.Hotel;
import by.lynd.hotels.model.HotelModel;

public class DetailPresenter implements Contract.ItemPresenter{
    private Hotel hotel;

    private Contract.ItemView activity;
    private Contract.Model model;

    public DetailPresenter(Contract.ItemView activity) {
        this.activity = activity;
        this.model = new HotelModel();
    }

    @Override
    public void handleIntent(Intent intent) {
        this.hotel = (Hotel) intent.getSerializableExtra(Hotel.class.getSimpleName());
        activity.setUpItemView(this.hotel);
    }

    @Override
    public void setUpButtonListener() {
        activity.setUpCallButtonListener(this.hotel.getNumber());
        activity.setUpEmailButtonListener(this.hotel.getEmail());
        activity.setUpLocationButtonListener(this.hotel.getLocale());
    }

}
