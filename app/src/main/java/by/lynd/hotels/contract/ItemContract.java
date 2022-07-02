package by.lynd.hotels.contract;

import android.content.Intent;

import by.lynd.hotels.model.Hotel;

public interface ItemContract {

    interface Presenter {
        void handleIntent(Intent intent);

        void setUpButtonListener();
    }

    interface View {
        void setUpItemView(Hotel hotel);

        void setUpCallButtonListener(String number);

        void setUpEmailButtonListener(String... emails);

        void setUpLocationButtonListener(String location);
    }
}
