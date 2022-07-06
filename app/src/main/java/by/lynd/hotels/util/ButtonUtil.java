package by.lynd.hotels.util;

import android.content.Intent;
import android.net.Uri;

public class ButtonUtil {
  private static final String TYPE = "message/rfc822";
  private static final String PACKAGE = "com.google.android.apps.maps";
  private static final int ZOOM = 19;

  public static Intent sendEmail(String... emails) {
    Intent sendIntent = new Intent(Intent.ACTION_SEND);
    sendIntent.setType(TYPE);
    sendIntent.putExtra(Intent.EXTRA_EMAIL, emails);
    return sendIntent;
  }

  public static Intent call(String number) {
    Intent callIntent = new Intent(Intent.ACTION_DIAL);
    callIntent.setData(Uri.parse("tel:" + number));
    return callIntent;
  }

  public static Intent findLocation(String location) {
    Uri geoUri = Uri.parse("geo:" + location + "?z=" + ZOOM);
    Intent sendLocation = new Intent(Intent.ACTION_VIEW, geoUri);
    sendLocation.setPackage(PACKAGE);
    return sendLocation;
  }
}
