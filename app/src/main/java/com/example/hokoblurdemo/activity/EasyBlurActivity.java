package com.example.hokoblurdemo.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.hokoblurdemo.R;
import com.hoko.blurlibrary.Blur;
import com.hoko.blurlibrary.task.AsyncBlurTask;

public class EasyBlurActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_blur);

         Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.cat);

        final ImageView imageView = ((ImageView) findViewById(R.id.image));
        final ImageView imageView1 = ((ImageView) findViewById(R.id.image1));
        final ImageView imageView2 = ((ImageView) findViewById(R.id.image2));
        final ImageView imageView3 = ((ImageView) findViewById(R.id.image3));

        imageView.setImageBitmap(Blur.with(this).forceCopy(true).scheme(Blur.SCHEME_RENDER_SCRIPT).sampleFactor(3.0f).radius(20).blurGenerator().blur(bitmap));

        imageView1.setImageBitmap(bitmap);
//        Blur.with(this).forceCopy(true).scheme(Blur.SCHEME_NATIVE).sampleFactor(2.0f).radius(2).blurGenerator().asyncBlur(bitmap, new AsyncBlurTask.Callback() {
//            @Override
//            public void onBlurSuccess(Bitmap bitmap) {
//                imageView1.setImageBitmap(bitmap);
//            }
//
//            @Override
//            public void onBlurFailed() {
//            }
//        });
        Blur.with(this).scheme(Blur.SCHEME_OPENGL).translateX(150).translateY(150).blurGenerator().asyncBlur(bitmap, new AsyncBlurTask.Callback() {
            @Override
            public void onBlurSuccess(Bitmap bitmap) {
                imageView2.setImageBitmap(bitmap);
            }

            @Override
            public void onBlurFailed() {
            }
        });

        imageView1.post(new Runnable() {
            @Override
            public void run() {
                Blur.with(EasyBlurActivity.this).scheme(Blur.SCHEME_NATIVE).translateX(100).translateY(100).blurGenerator().asyncBlur(imageView1, new AsyncBlurTask.Callback() {
                    @Override
                    public void onBlurSuccess(Bitmap bitmap) {
                        imageView3.setImageBitmap(bitmap);
                    }

                    @Override
                    public void onBlurFailed() {

                    }
                });

            }
        });


    }
}
