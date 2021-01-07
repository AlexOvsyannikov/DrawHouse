package com.example.drawhouse;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.Log;
import android.view.View;

public class MyDraw extends View {
    public MyDraw (Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        //фон
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);

        //трава
        paint.setColor(Color.rgb(0,128,0));
        canvas.drawRect(0,getHeight()-300, getWidth(), getHeight(), paint);



        //солнце
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(70,70,100, paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        for(int i = 200; i<=300; i+=50) {
            for (int j = 250; j <= 350; j += 50) {
                Log.d("TEST", "value: " + i);
                canvas.drawLine(0, 0, i, j, paint);
            }
        }

        //дом
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.rgb(139,69,19));
        canvas.drawRect(getWidth()/3, getHeight()-600, getWidth()/3+300, getHeight()-200, paint);

        //крыша
        paint.setStrokeWidth(4);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setAntiAlias(true);


        Point a = new Point(getWidth()/3+130, getHeight()-800);
        Point b = new Point(getWidth()/3+300, getHeight()-600);
        Point c = new Point(getWidth()/3, getHeight()-600);
        Path path = new Path();

        paint.setColor(Color.rgb(139,69,19));
        path.moveTo(b.x, b.y);
        path.lineTo(b.x, b.y);
        path.lineTo(c.x, c.y);
        path.lineTo(a.x, a.y);
        path.close();

        canvas.drawPath(path, paint);

        //разделение крыши и здания
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        canvas.drawLine(getWidth()/3,getHeight()-600,getWidth()/3+300,getHeight()-600, paint);

        //окно на крыше
        canvas.drawCircle(getWidth()/3+130,getHeight()-670, 35, paint);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(2);
        for(int i = getWidth()/3+95; i<=getWidth()/3+130; i+=15) {
            for (int j = getHeight()-705; j <= getHeight()-670; j += 15) {
                Log.d("TEST2", "value: " + i);
                canvas.drawLine(i+4, j+4, i+32, j+32, paint);
            }
        }

        //дверь
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(4);
        canvas.drawRect(getWidth()/3+150, getHeight()-450,getWidth()/3+250,getHeight()-200, paint);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(2);
        for(int i = getWidth()/3+155; i<=getWidth()/3+200; i+=20) {
            for (int j = getHeight()-450; j <= getHeight()-250; j += 20) {
                Log.d("TEST3", "value: " + i);
                canvas.drawLine(i, j, i+50, j+50, paint);
            }
        }
    }
}