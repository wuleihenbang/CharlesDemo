package com.wl.demo.view.recyclerview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class GridViewDivider extends RecyclerView.ItemDecoration {


    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {

        Paint paint = new Paint();
        paint.setColor(parent.getContext().getResources().getColor(android.R.color.white));

        int childCount = parent.getChildCount();

        for(int i = 0; i < childCount; i++){
            View childView = parent.getChildAt(i);

            float x = childView.getX();
            float y = childView.getY();
            int width = childView.getWidth();
            int height = childView.getHeight();

            c.drawLine(x, y, x + width, y, paint);
            c.drawLine(x, y, x,y + height, paint);
            c.drawLine(x + width, y, x + width, y + height, paint);
            c.drawLine(x, y + height, x + width, y + height, paint);
        }


        super.onDraw(c, parent, state);
    }
}
