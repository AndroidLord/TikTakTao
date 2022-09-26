package com.example.tiktaktao;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView2,textView3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);


    }

    int gamestate[] = {2,2,2,2,2,2,2,2,2};

    int winPosition[][] = {{0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}};

    int player = 0;
    int status = 0;


    public void playing(ImageView img, int tappedImage){
        gamestate[tappedImage] = player;

        img.setTranslationY(-1000);


        if(gamestate[tappedImage] == 0)
        {
            player = 1;
            img.setImageResource(R.drawable.x);
            MediaPlayer.create(this,R.raw.fsound).start();
            textView2.setText(" Water Turn's");

        }
        else
        {

            player = 0;
            img.setImageResource(R.drawable.o);
            MediaPlayer.create(this,R.raw.wsound).start();
            textView2.setText(" Fire Turn's");
        }

        if(gamestate[0]!=2)
            if(gamestate[1]!=2)
                if(gamestate[2]!=2)
                    if(gamestate[3]!=2)
                        if(gamestate[4]!=2)
                            if(gamestate[5]!=2)
                                if(gamestate[6]!=2)
                                    if(gamestate[7]!=2)
                                        if(gamestate[8]!=2)
                                            {
                                                textView3.setText("Game Over!");
                                                textView2.setText(" Match Drawn!\n\t\tTap To Reset");
                                                MediaPlayer.create(this,R.raw.applaud).start();
                                                status = 1;
                                            }


        img.animate().translationYBy(1000f).setDuration(100);



        for(int[] index: winPosition){

            if(gamestate[index[0]] == gamestate[index[1]] &&
                    gamestate[index[0]] == gamestate[index[2]] &&
                    gamestate[index[0]]!=2)
            {

                if(gamestate[index[0]]==0)
                {
                    textView2.setText("Eternal Fire Dwells\n\t\t    Tap To Reset");
                    status = 1;
                }
                else
                {
                    textView2.setText("Brilliant Light Shines\n\t\t     Tap To Reset");
                    status = 1;
                }
                textView3.setText("Game Over!");
                MediaPlayer.create(this,R.raw.applaud).start();
            }

        }




    }

    public void wonCondition(){

        status = 0;
        textView2.setText(R.string.Status);
        textView3.setText("");
        for(int i=0;i<gamestate.length;i++){
            gamestate[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

    }

    public void onTap(View view) {
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());


        if(gamestate[tappedImage] == 2 && status==0){
            playing(img,tappedImage);
        }
        else
        {
            wonCondition();
        }


    }
}