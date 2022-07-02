package by.lynd.hotels.contract;

import by.lynd.hotels.model.Hotel;
import by.lynd.hotels.model.HotelList;
import retrofit2.Callback;

import java.util.List;


public interface MainContract {
    interface Model {
        void loadHotels(Callback<HotelList> listOfHotels);
    }

    interface View {
        void appendHotel(List<Hotel> hotels);

        boolean isTheListIsEmpty();

        void showHotels(List<Hotel> hotels);

        void shotToast(String text);
    }

    interface Presenter {
        void getData();

        void start();
    }
}
