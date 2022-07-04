package by.lynd.hotels.presenter;

import android.content.Intent;

import by.lynd.hotels.contract.ItemContract;
import by.lynd.hotels.contract.MainContract;
import by.lynd.hotels.model.Hotel;

public class DetailPresenter implements ItemContract.Presenter {
  private Hotel hotel;

  private MainContract.Model model;
  private ItemContract.View activity;

  public DetailPresenter(ItemContract.View activity) {
    this.activity = activity;
  }

  @Override
  public void handleHotel(Intent intent) {
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
