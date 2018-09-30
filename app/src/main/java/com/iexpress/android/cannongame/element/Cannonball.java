package com.iexpress.android.cannongame.element;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.iexpress.android.cannongame.CannonView;

class Cannonball extends GameElement {
    private float velocityX;
    private boolean onScreen;

    public Cannonball(CannonView view, int color, int cannonSoundId, int x, int y, int radius,
                      int velocityX, int velocityY) {
        super(view, color, cannonSoundId, x, y, 2 * radius, 2 * radius, velocityY);
        this.velocityX = velocityX;
        onScreen = true;

    }

    public void playSound() {
    }

    public int getRadius() {
        return (shape.right - shape.left) / 2;
    }

    public boolean collidesWith(GameElement element) {
        return (Rect.intersects(shape, element.shape) && velocityX > 0);
    }

    public boolean isOnScreen() {
        return onScreen;
    }

    public void reverseVelocityX() {
        velocityX *= -1;
    }

    @Override
    public void update(double interval) {
        super.update(interval);

        // horizontal position
        shape.offset((int) (velocityX * interval), 0);

        // cannon ball off screen
        if (shape.top < 0 || shape.left < 0 || shape.bottom > view.getScreenHeight()
                || shape.right > view.getScreenWidth()) {

            // cannon ball will be removed
            onScreen = false;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawCircle(shape.left + getRadius(),
                shape.top + getRadius(), getRadius(), paint);
    }

}
