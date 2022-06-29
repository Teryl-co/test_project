package by.lynd.hotels.presentars;

import java.util.List;

import by.lynd.hotels.Model.Contract;
import by.lynd.hotels.Model.Hotel;
import by.lynd.hotels.Model.HotelModel;

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
        this.hotels = model.loadHotels();
        activity.showHotels(this.hotels);
    }
}
