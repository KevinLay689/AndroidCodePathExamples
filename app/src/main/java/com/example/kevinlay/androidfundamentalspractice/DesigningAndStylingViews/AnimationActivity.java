package com.example.kevinlay.androidfundamentalspractice.DesigningAndStylingViews;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kevinlay.androidfundamentalspractice.R;

/**
 * Animation Activity
 *
 * Major Takeaways
 * -Can set a listener adapter to animations before they start to manage events like ending animation or starting animation
 * -Can choreograph animations together with animatorSets
 * -Should use property animations, but keep in mind the view will change its properties unless reversed
 * -Can use XML to inflate a property animation too
 * -Better control animations by using the onAnimationUpdate Listener, can use animation.getAnimatedValue to for more control
 * -Use setFillAfter="false" for chaining animations, it alters the animation properties, not view
 *
 *
 * Steps to creating animations, see animateAlpha()
 *      1. Create an Object Animator and set the values ofFloat(view, AnimationType, startValue, endValue)
 *          1a. Example: ObjectAnimation anim = ObjectAnimator.ofFloat(view, VIEW.ALPHA, 1.0f, 2.0f);
 *          1b. Can omit the 1st Value param
 *      2. Set the Object Animator duration with setDuration(Int)
 *      3. Can set a variety of properties like setRepeatCount, setInterpolator etc
 *      4. Call ObjectAnimator.start() to begin the animation
 *
 * Steps to inflating an animation from XML, see animateFadeOutXml()
 *      1. Create the XML file, begins with <Object Animator> or <set>, see fade_out.xml for example
 *      2. Create an animator object
 *          2a. Example Animator animator = AnimatorInflater.loadAnimator(context, R.anim.fade_out)
 *      3. Set the target of the animator to a view
 *          3a. Example animator.setTarget(view)
 *      4. Start animator with animator.start()
 *
 * Steps to creating an AnimatorSet, see animateSetRotateAndScale()
 *      1. Create Animations
 *      2. Create Animator Set object
 *          2a. Example AnimatorSet set = new AnimatorSet()
 *      3. Add the animations to the Animator set with set.playTogether(anim1, anim2);
 *      4. Start animatorSet with animatorSet.start()
 *
 * Steps to creating an Animator with listeners, see animateSetRotateAndScale()
 *      1. Create Animations
 *      2. Create listener with animator.addListener(new AnimationListenerAdapter)
 *      3. Inside the anonymous listener, override classes such as onAnimationEnd, onAnimationStart, etc
 *      4. Start animation with animator.start() when completed
 *
 */
public class AnimationActivity extends AppCompatActivity {
    
    private Button bAnimateAlpha, bAnimateTranslate, bAnimateSetRotateAndScale, bAnimateFadeOutXml, bAnimateRotate;
    private TextView tvAnimateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        bAnimateAlpha = (Button) findViewById(R.id.bAnimateAlpha);
        bAnimateTranslate = (Button) findViewById(R.id.bAnimateTranslate);
        bAnimateSetRotateAndScale = (Button) findViewById(R.id.bAnimateScaleX);
        bAnimateFadeOutXml = (Button) findViewById(R.id.bAnimateFadeOutXml);
        bAnimateRotate = (Button) findViewById(R.id.bAnimateRotate);

        tvAnimateTextView = (TextView) findViewById(R.id.tvAnimateText);

        bAnimateAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateAlpha();
            }
        });
        bAnimateTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateTranslate();
            }
        });
        bAnimateSetRotateAndScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateSetRotateAndScale();
            }
        });
        bAnimateFadeOutXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFadeOutXml();
            }
        });
        bAnimateRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateRotate();
            }
        });
    }

    private void animateSetRotateAndScale() {
        // Define first set of animations
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(tvAnimateTextView, View.SCALE_X, 2.0f);
        anim1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                animation.removeListener(this);
                animation.setDuration(0);
                ((ValueAnimator) animation).reverse();
            }
        });
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(tvAnimateTextView, View.SCALE_Y, 2.0f);
        anim2.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                animation.removeListener(this);
                animation.setDuration(0);
                ((ValueAnimator) animation).reverse();
            }
        });
        AnimatorSet set1 = new AnimatorSet();
        set1.playTogether(anim1, anim2);
        // Define second set of animations
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(tvAnimateTextView, View.ROTATION_X, 360);
        anim3.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                animation.removeListener(this);
                animation.setDuration(0);
                ((ValueAnimator) animation).reverse();
            }
        });
        ObjectAnimator anim4 = ObjectAnimator.ofFloat(tvAnimateTextView, View.ROTATION_Y, 360);
        anim4.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                animation.removeListener(this);
                animation.setDuration(0);
                ((ValueAnimator) animation).reverse();
            }
        });
        AnimatorSet set2 = new AnimatorSet();
        set2.playTogether(anim3, anim4);
        // Play the animation sets one after another
        AnimatorSet set3 = new AnimatorSet();
        set3.playSequentially(set1, set2);
        set3.start();
    }

    private void animateFadeOutXml() {

        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.fade_out);
        animator.setTarget(tvAnimateTextView);
        animator.start();

    }

    private void animateRotate() {

    }

    private void animateTranslate() {
        ObjectAnimator moveAnim = ObjectAnimator.ofFloat(tvAnimateTextView, View.TRANSLATION_Y, 1000);
        moveAnim.setDuration(2000);
        moveAnim.setInterpolator(new BounceInterpolator());

        // Set listeners to do things when the animation ends or starts
        moveAnim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                ObjectAnimator resetAnim = ObjectAnimator.ofFloat(tvAnimateTextView, View.TRANSLATION_Y, 0);
                resetAnim.setDuration(2000);
                resetAnim.setInterpolator(new BounceInterpolator());
                resetAnim.start();
                Toast.makeText(getApplicationContext(), "End!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }

            @Override
            public void onAnimationPause(Animator animation) {
                super.onAnimationPause(animation);
            }

            @Override
            public void onAnimationResume(Animator animation) {
                super.onAnimationResume(animation);
            }
        });
        moveAnim.start();
    }

    private void animateAlpha() {
        ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(tvAnimateTextView, View.ALPHA, 0, 1 );
        fadeAnim.setDuration(2000);
        //fadeAnim.setRepeatCount(ValueAnimator.INFINITE); //Repeat animation forever
        fadeAnim.start();
    }
}
