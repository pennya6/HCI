package com.example.basiccode;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawOn extends View {
    public DrawOn(Activity activity){
        super(activity.getBaseContext());
    }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(5);

        canvas.drawLine(100,350,100,400,paint);
        canvas.drawLine(100,350,200,350,paint);

        canvas.drawLine(520,350,620,350,paint);
        canvas.drawLine(620,350,620,400,paint);

        canvas.drawLine(100,600,100,650,paint);
        canvas.drawLine(100,650,200,650,paint);

        canvas.drawLine(520,650,620,650,paint);
        canvas.drawLine(620,650,620,600,paint);
    }
}
