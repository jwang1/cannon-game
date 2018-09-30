package com.iexpress.android.cannongame.element;

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

}
