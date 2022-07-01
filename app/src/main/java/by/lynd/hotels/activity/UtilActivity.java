package by.lynd.hotels.activity;

import android.content.Intent;
import android.net.Uri;

public class UtilActivity{

    public static Intent sendEmail(String... emails) {
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("message/rfc822");
        sendIntent.putExtra(Intent.EXTRA_EMAIL, emails);
        return sendIntent;
    }

    public static Intent call(String number) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:" + number));
        return callIntent;
    }

    public static Intent findLocation(String location) {
        Uri geoUri = Uri.parse("geo:" + location + "?z=19");
        Intent sendLocation = new Intent(Intent.ACTION_VIEW, geoUri);
        sendLocation.setPackage("com.google.android.apps.maps");
        return sendLocation;
    }
}