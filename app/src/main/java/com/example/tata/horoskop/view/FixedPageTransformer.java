package com.example.tata.horoskop.view;

import android.support.v4.view.ViewPager;
import android.view.View;

public abstract class FixedPageTransformer implements ViewPager.PageTransformer
{
    ViewPager mPager;

    public FixedPageTransformer(ViewPager pager)
    {
        this.mPager = pager;
    }

    @Override
    public final void transformPage(View view, float position)
    {
        /*(240 - (240 + 240)*/
        fixedTransformPage(view, (float) (view.getLeft() - (mPager.getScrollX() + mPager.getPaddingLeft())) / getClientWidth());
    }

    private float getClientWidth()
    {
        return mPager.getMeasuredWidth() - mPager.getPaddingLeft() - mPager.getPaddingRight();
    }

    public abstract void fixedTransformPage(View view, float fixed);
}