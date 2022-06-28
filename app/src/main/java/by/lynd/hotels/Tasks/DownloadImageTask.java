package by.lynd.hotels.Tasks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;



public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    private ImageView imageView;
    private static int quantity;

    public DownloadImageTask(ImageView imageView) {
        this.imageView = imageView;
    }

    protected Bitmap doInBackground(String... urls) {
        String serverUrl = urls[0];
        Bitmap image = null;

        try {
            InputStream in = new URL(serverUrl).openStream();
            image = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return image;
    }

    protected void onPostExecute(Bitmap result) {
        imageView.setImageBitmap(result);
        quantity++;
    }

    public static int getQuantity() {
        return quantity;
    }
}
