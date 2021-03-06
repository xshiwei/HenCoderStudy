package com.hencoder.hencoderpracticedraw6.practice;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.meiji.hencoderstudy.practicedraw6.R;


public class Practice02Rotation extends RelativeLayout {
    Button animateBt;
    ImageView imageView;
    int state = 0;

    public Practice02Rotation(Context context) {
        super(context);
    }

    public Practice02Rotation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02Rotation(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = findViewById(R.id.animateBt);
        imageView = findViewById(R.id.imageView);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                // 在这里处理点击事件，通过 View.animate().rotation/X/Y() 来让 View 旋转
                switch (state) {
                    case 0:
                        imageView.animate().rotation(180);
                        break;
                    case 1:
                        ObjectAnimator rotation = ObjectAnimator.ofFloat(imageView, "rotation", 0);
                        rotation.start();
                        break;
                    case 2:
                        imageView.animate().rotationX(180);
                        break;
                    case 3:
                        ObjectAnimator rotationX = ObjectAnimator.ofFloat(imageView, "rotationX", 0);
                        rotationX.start();
                        break;
                    case 4:
                        imageView.animate().rotationY(180);
                        break;
                    case 5:
                        ObjectAnimator rotationY = ObjectAnimator.ofFloat(imageView, "rotationY", 0);
                        rotationY.start();
                        break;

                }
                state++;
                if (state == 6) {
                    state = 0;
                }
            }
        });
    }
}