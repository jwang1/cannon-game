package com.iexpress.android.cannongame.element;

import com.iexpress.android.cannongame.CannonView;

public class Blocker extends GameElement {
    private int missPenalty;

    public Blocker(CannonView view, int color, int x, int y, int width, int length,
                   float velocityY, int missPenalty) {
        super(view, color, CannonView.TARGET_SOUND_ID, x, y, width, length, velocityY);

        this.missPenalty = missPenalty;
    }

    public int getMissPenalty() {
        return missPenalty;
    }

}
