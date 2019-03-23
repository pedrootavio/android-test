package com.example.pedro.teste.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.pedro.teste.R;

public class ViewFlipperActivity extends AppCompatActivity {

    private ViewFlipper vFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper);

        int images[] = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3};

        vFlipper = findViewById(R.id.v_flipper);

        for(int image : images) {
            flipperImages(image);
        }

    }

    private void flipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        vFlipper.addView(imageView);
        vFlipper.setFlipInterval(4000); // 4 sec
        vFlipper.setAutoStart(true);

        // animation
        vFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        vFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}
