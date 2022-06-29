package by.lynd.hotels.Model;

import java.util.List;

public interface Contract {

    interface View {
        void showHotels(List<Hotel> hotels);
        void sendIntent(Hotel hotel);
    }

    interface Presenter {
        void onItemWasClicked(int position);
        void onDestroy();
    }

    interface Model {
        List<Hotel> loadHotels();
    }
}
