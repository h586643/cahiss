package com.ebookfrenzy.cahiss.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

public class ImageConverter {

    public static byte[] convertImageToByte(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);

        return stream.toByteArray();
    }

    public static Bitmap convertByteArrayToImage(byte [] array) {
        return BitmapFactory.decodeByteArray(array,0,array.length);
    }
}
