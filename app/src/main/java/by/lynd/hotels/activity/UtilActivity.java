package by.lynd.hotels.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;

public class UtilActivity extends AppCompatActivity {

    public void sendEmail(String... emails) {
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("message/rfc822");
        sendIntent.putExtra(Intent.EXTRA_EMAIL, emails);
        startActivity(Intent.createChooser(sendIntent, "Send mail..."));
    }

    public void call(String number) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:" + number));
        startActivity(callIntent);
    }

    public void findLocation(String location) {
        Uri geoUri = Uri.parse("geo:" + location + "?z=19");
        Intent sendLocation = new Intent(Intent.ACTION_VIEW, geoUri);
        sendLocation.setPackage("com.google.android.apps.maps");
        startActivity(sendLocation);
    }
}