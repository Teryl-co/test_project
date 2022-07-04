package by.lynd.hotels.contract;

import by.lynd.hotels.model.Hotel;
import by.lynd.hotels.model.HotelList;
import java.util.List;
import retrofit2.Callback;

public interface MainContract {
  interface Model {
    void loadHotels(Callback<HotelList> listOfHotels);
  }

  interface View {
    boolean isTheListIsEmpty();

    void showHotels(List<Hotel> hotels);

    void shotToast(String text);
  }

  interface Presenter {
    void getData();

    void start();
  }
}
