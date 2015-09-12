package com.example.tata.horoskop.utility;

import android.os.Build;

/**
 * Created by pedja on 12.2.15. 08.40.
 * This class is part of the Preezm
 * Copyright © 2015 ${OWNER}
 */
public final class Android
{
    private Android()
    {

    }

    /**
     * Check if system is minimum Android 5.0 Lollipop (SDK 21)
     * @return true if system os is 21 or higher, false otherwise*/
    public static boolean hasLollipop()
    {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

    /**
     * Check if system is minimum Android 4.4 Lollipop (SDK 19)
     * @return true if system os is 19 or higher, false otherwise*/
    public static boolean hasKitKat()
    {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    }

    /**
     * Check if system is minimum Android 4.1 Lollipop (SDK 16)
     * @return true if system os is 16 or higher, false otherwise*/
    public static boolean hasJellyBean()
    {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
    }
}
