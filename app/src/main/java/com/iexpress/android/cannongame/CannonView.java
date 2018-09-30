package com.iexpress.android.cannongame;

import android.content.Context;
import android.view.SurfaceView;

public class CannonView extends SurfaceView {
    // FIXME
    public static int CANNONBALL_SPEED_PERCENT = 100;
    public static final int CANNONBALL_RADIUS_PERCENT = 100;
    public static final int CANNON_SOUND_ID = 1;

    public CannonView(Context context) {
        super(context);
    }

    public int getScreenHeight() {
        // FIXME
        return 100;
    }

    public int getScreenWidth() {
        // FIXME
        return 100;
    }

    public void playSound(int soundId) {
        // TODO
    }
}
