package com.example.tata.horoskop.view;

/**
 * Created by bataemperor on 12.9.15..
 */

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

public class InfoViewPager extends ViewPager
{
    private boolean overriderDrawingOrder;

    public InfoViewPager(Context context)
    {
        super(context);
    }

    public InfoViewPager(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    protected int getChildDrawingOrder(int childCount, int i)
    {
        if(overriderDrawingOrder)
        {
            int currentItem = getCurrentItem();

            switch (i)
            {
                case 0:
                    if(currentItem == 0)
                    {
                        return 1;
                    }
                    else if(currentItem == 1)
                    {
                        return 0;
                    }
                    else
                    {
                        return 0;
                    }
                case 1:
                    if(currentItem == 0)
                    {
                        return 2;
                    }
                    else if(currentItem == 1)
                    {
                        return 2;
                    }
                    else
                    {
                        return 1;
                    }
                case 2:
                    return currentItem;
            }
        }
        return super.getChildDrawingOrder(childCount, i);
    }

    public void setOverriderDrawingOrder(boolean overriderDrawingOrder)
    {
        this.overriderDrawingOrder = overriderDrawingOrder;
    }

    @Override
    public void setPageTransformer(boolean reverseDrawingOrder, PageTransformer transformer)
    {
        super.setPageTransformer(overriderDrawingOrder && reverseDrawingOrder, transformer);
    }
}
