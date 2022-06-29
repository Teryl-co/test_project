package by.lynd.hotels.Model;

import java.util.List;

public interface Contract {

    interface View {
        void showHotels();
    }

    interface Presenter {
        void onItemWasClicked();
        void onDestroy();
    }

    interface Model {
        List<Hotel> loadHotels();
    }
}
