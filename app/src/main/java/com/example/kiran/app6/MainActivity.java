package com.example.kiran.app6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory {

    LinearLayout linearLayoutHorizontal;
    ImageSwitcher imgSwitch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayoutHorizontal = (LinearLayout) findViewById(R.id.linearLayoutHorizontal);

        imgSwitch = (ImageSwitcher) findViewById(R.id.imgSwitch);

        imgSwitch.setFactory(MainActivity.this);

        imgSwitch.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,
                android.R.anim.slide_in_left));
        imgSwitch.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this,
                android.R.anim.slide_out_right));

        for(int i=0; i < Animal.images.length; i++){

            final int k = i;
            ImageView imageView = new ImageView(MainActivity.this);
            imageView.setImageResource(Animal.images[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            setImageView(imageView);
            imageView.setPadding(100, 100, 100, 100);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imgSwitch.setImageResource(Animal.images[k]);
                    Toast.makeText(MainActivity.this, "This is " + Animal.images[k], Toast.LENGTH_SHORT).show();
                }
            });
            linearLayoutHorizontal.addView(imageView);
        }


    }

    public void setImageView(ImageView imageView)
    {
        imageView.setLayoutParams(new LinearLayout.LayoutParams(1000, 1000));
    }


    @Override
    public View makeView() {
        ImageView imageView = new ImageView(MainActivity.this);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return imageView;
    }
}
