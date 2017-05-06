package com.anwesome.ui.revealcoloredimagelist;

import android.animation.ValueAnimator;

/**
 * Created by anweshmishra on 06/05/17.
 */
public class AnimationHandler implements ValueAnimator.AnimatorUpdateListener{
    private RevealColoredImageView revealColoredImageView;
    private ValueAnimator startAnim = ValueAnimator.ofFloat(0,1),endAnim = ValueAnimator.ofFloat(1,0);
    {{
        startAnim.setDuration(500);
        endAnim.setDuration(500);
        startAnim.addUpdateListener(this);
        endAnim.addUpdateListener(this);
    }}
    public AnimationHandler(RevealColoredImageView revealColoredImageView) {
        this.revealColoredImageView = revealColoredImageView;
    }
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        revealColoredImageView.update((float)valueAnimator.getAnimatedValue());
    }
    public void start() {
        startAnim.start();
    }
    public void end() {
        endAnim.start();
    }
}
