package com.qianmi.utils.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by caozupeng on 15-6-13.
 */
public class DownloadTask  extends AsyncTask<URL, Integer, Bitmap> {
    private ImageView imageView;
    protected String TAG = "Download task";
    public DownloadTask(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(URL... urls) {
        return getImageBitmap(urls[0]);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }

    private Bitmap getImageBitmap(URL url) {
        Bitmap bm = null;
        try {
            URLConnection conn = url.openConnection();
            conn.connect();
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            bm = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();
        } catch (IOException e) {
            Log.e(TAG, "Error getting bitmap", e);
        }
        return bm;
    }
}
