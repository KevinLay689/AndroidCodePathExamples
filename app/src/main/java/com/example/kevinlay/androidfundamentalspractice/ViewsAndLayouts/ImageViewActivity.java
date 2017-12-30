package com.example.kevinlay.androidfundamentalspractice.ViewsAndLayouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.kevinlay.androidfundamentalspractice.R;
import com.squareup.picasso.Picasso;

/**
 * ImageView Activity
 *
 * Major Takeaways
 * -scaleType attribute controls how the image is positioned
 * -Preserve aspect ratio with adjustViewBounds, must allow height or width to be wrap_content
 * -Can use mipmaps as drawable
 * -Must have manifest internet to run picasso
 * -Processing bitmaps is very labor intensive
 * -Base 64 encoding is a easy way to turn a bitmap into string
 * -Example of Bitmap manipulation to run faster
      public static Bitmap getProfileImage(int sampleSize, String image) {
         BitmapFactory.Options options = new BitmapFactory.Options();
         options.inSampleSize = sampleSize;
         options.inPreferredConfig = Bitmap.Config.RGB_565;
         byte[] decodedString = Base64.decode(image, Base64.DEFAULT);
         InputStream is = new ByteArrayInputStream(decodedString);
         Bitmap decodedByte = BitmapFactory.decodeStream(is, null, options);
         Bitmap.createScaledBitmap(decodedByte, 100, 100, false);

         return decodedByte;
        }
 */

public class ImageViewActivity extends AppCompatActivity {

    ImageView ivUserImage, ivBitmapImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        ivUserImage = findViewById(R.id.ivUserImage);
        ivBitmapImage = findViewById(R.id.ivBitmapImage);

        //Set imageview width or height at runtime
        ivUserImage.getLayoutParams().height = 500;
        ivUserImage.getLayoutParams().width = 500;

        //Set bitmaps to imageviews at runtime
        //Use picasso
        Picasso.with(getApplicationContext())
                .load("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2d/Google-favicon-2015.png/150px-Google-favicon-2015.png")
                .resize(50, 50)
                .centerCrop()
                .into(ivUserImage);

        Picasso.with(this)
                .load("http://i.imgur.com/DvpvklR.png")
                .into(ivBitmapImage);

    }

}
