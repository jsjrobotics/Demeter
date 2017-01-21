package com.jsjrobotics.demeter.ImageUtils;

import android.graphics.Bitmap;

import java.util.function.BiFunction;

public interface BitmapInflater {
    Bitmap buildBitmap(int width, int height);
}
