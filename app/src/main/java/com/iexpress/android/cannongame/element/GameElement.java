package com.iexpress.android.cannongame.element;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.iexpress.android.cannongame.CannonView;

/**
 * Base class for items moving up and down or across the screen
 */
public class GameElement {
    protected CannonView view;
    protected Paint paint = new Paint();
    protected Rect shape;
    private float velocityY; // vertical velocity of GameElement
    private int soundId;

    public GameElement(CannonView view, int color, int soundId, int x, int y, int width, int length,
                       float velocityY) {
        this.view = view;
        paint.setColor(color);
        // set bounds
        shape = new Rect(x, y, x + width, y + length);
        this.soundId = soundId;
        this.velocityY = velocityY;
    }

    public void update(double interval) {
        // update vertical position
        shape.offset(0, (int) (velocityY * interval));

        // reverse direction because of colliding with the wall
        if (shape.top < 0 && velocityY < 0
                || shape.bottom > view.getScreenHeight() && velocityY > 0) {
            velocityY *= -1;
        }
    }

    public void draw(Canvas canvas) {
        canvas.drawRect(shape, paint);
    }

    public void playSound() {
        view.playSound(soundId);
    }

}
