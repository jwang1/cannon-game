package com.iexpress.android.cannongame.element;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

import com.iexpress.android.cannongame.CannonView;


public class Cannon {
    private int baseRadius;
    private int barrelLength;
    private Point barrelEnd = new Point();
    private double barrelAngle;
    private Cannonball cannonball;
    private Paint paint = new Paint();
    private CannonView view;

    public Cannon(CannonView view, int baseRadius, int barrelLength, int barrelWidth) {
        this.view = view;
        this.baseRadius = baseRadius;
        this.barrelLength = barrelLength;
        if (barrelLength < baseRadius) {
            this.barrelLength = barrelLength + baseRadius;
        }
        paint.setStrokeWidth(barrelWidth);
        paint.setColor(Color.MAGENTA);
        // cannon barrel facing straight right
        align(Math.PI / 2);
    }

    public void align(double v) {
        this.barrelAngle = v;
        barrelEnd.x = (int) (barrelLength * Math.sin(barrelAngle));
        barrelEnd.y = (int) (-barrelLength * Math.cos(barrelAngle))
                        + view.getScreenHeight() / 2;
    }

    public void fireCannonball() {
        // x component of cannon ball velocity
        int velocityX = (int) (CannonView.CANNONBALL_SPEED_PERCENT * view.getScreenWidth()
                               * Math.sin(barrelAngle));

        int velocityY = (int) (CannonView.CANNONBALL_SPEED_PERCENT * view.getScreenWidth()
                                * -Math.cos(barrelAngle));

        int radius = (int) (view.getScreenHeight() * CannonView.CANNONBALL_RADIUS_PERCENT);

        cannonball = new Cannonball(view, Color.BLACK, CannonView.CANNON_SOUND_ID, -radius,
                                view.getScreenHeight() / 2 - radius, radius, velocityX,
                                velocityY);

        if (cannonball != null) {
            cannonball.playSound();
        }
    }

    public void draw(Canvas canvas) {
        canvas.drawLine(0, view.getScreenHeight() / 2, barrelEnd.x,
                        barrelEnd.y, paint);

        canvas.drawCircle(0, (int) view.getScreenHeight() / 2,
                        (int) baseRadius, paint);
    }

    public Cannonball getCannonball() {
        return cannonball;
    }

    public void removeCannonball() {
        cannonball = null;
    }

}
