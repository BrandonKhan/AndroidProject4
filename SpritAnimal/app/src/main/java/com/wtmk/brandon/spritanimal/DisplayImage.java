package com.wtmk.brandon.spritanimal;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import static android.R.attr.duration;


public class DisplayImage extends AppCompatActivity {


    private ImageView displayImageView;

    private Drawable dolphin;
    private Drawable elephant;
    private Drawable monkey;
    private Drawable redpanda;
    private Drawable tiger;

@Override
protected  void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.you_are);

    Intent intent = getIntent();

    String youAre = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

    dolphin = ResourcesCompat.getDrawable(getResources(), R.drawable.dolphin, null);
    elephant = ResourcesCompat.getDrawable(getResources(), R.drawable.elephant, null);
    monkey = ResourcesCompat.getDrawable(getResources(), R.drawable.monkey, null);
    redpanda = ResourcesCompat.getDrawable(getResources(), R.drawable.redpanda, null);
    tiger = ResourcesCompat.getDrawable(getResources(), R.drawable.tiger, null);

    displayImageView = (ImageView) findViewById(R.id.youAreimageView);




    switch (youAre){

        case "tiger":
            displayImageView.setImageDrawable(tiger);
            break;
        case "dolphin":
            displayImageView.setImageDrawable(dolphin);
            break;
        case "elephant":
            displayImageView.setImageDrawable(elephant);
            break;
        case "monkey":
            displayImageView.setImageDrawable(monkey);
            break;
        case "redpanda":
            displayImageView.setImageDrawable(redpanda);
            break;




    }
        Toast.makeText(DisplayImage.this, "Looks like you are a " + youAre+"!" ,Toast.LENGTH_LONG).show();
    }

}
