package com.iexpress.android.cannongame.element;

import com.iexpress.android.cannongame.CannonView;

public class Target extends GameElement {
    private int hitReward;


    public Target(CannonView view, int color, int x, int y, int width, int length,
                  float velocityY, int hitReward) {
        super(view, color, CannonView.TARGET_SOUND_ID, x, y, width, length, velocityY);
        this.hitReward = hitReward;
    }

    public int getHitReward() {
        return hitReward;
    }
}
