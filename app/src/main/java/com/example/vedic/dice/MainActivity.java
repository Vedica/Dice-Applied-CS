package com.example.vedic.dice;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView chance;
    TextView won;
    Button roll;
    Button reset;
    Button hold;
    ImageView img;

    static int userScore = 0;
    static int compScore = 0;
    static int userTemp = 0;
    static int compTemp = 0;
    static int number = 0;

    String l="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        won = (TextView) findViewById(R.id.won);
        chance = (TextView) findViewById(R.id.chance);
        tv5 = (TextView) findViewById(R.id.tv5);
        hold = (Button) findViewById(R.id.hold);
        roll = (Button) findViewById(R.id.roll);
        reset = (Button) findViewById(R.id.reset);
        img = (ImageView) findViewById(R.id.img);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userTemp=0;
                userScore=0;
                compScore=0;
                compTemp=0;
                chance.setText("Your Chance!!");
                won.setText("");
                tv2.setText(Integer.toString(userScore));
                tv4.setText(Integer.toString(compScore));
                roll.setEnabled(true);
                hold.setEnabled(true);
            }
        });

        hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userScore = userScore + userTemp;
                tv2.setText(Integer.toString(userScore));
                userTemp = 0;
                chance.setText("Computer's Chance!!");
//                Handler hand=new Handler();
                if (userScore >= 100) {
                    won.setText("You Won!!");
                    chance.setText("");
                    roll.setEnabled(false);
                    hold.setEnabled(false);
                }
                else {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            compturn();
                        }
                    }, 200);
                }
            }

        });

        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chance.setText("Your Chance!!");
                int num = (int) (Math.random() * ((6 - 0) + 1));
                switch(num){
                    case 1:
                        img.setImageResource(R.drawable.dice1);
                        userTemp=0;
                        chance.setText("Computer's Chance!!");
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                compturn();
                            }
                        },1000);

                        break;
                    case 2:
                        img.setImageResource(R.drawable.dice2);
                        userTemp += 2;
                        break;
                    case 3:
                        img.setImageResource(R.drawable.dice3);
                        userTemp += 3;
                        break;
                    case 4:
                        img.setImageResource(R.drawable.dice4);
                        userTemp += 4;
                        break;
                    case 5:
                        img.setImageResource(R.drawable.dice5);
                        userTemp += 5;
                        break;
                    case 6:
                        img.setImageResource(R.drawable.dice6);
                        userTemp += 6;
                        break;

                }
            }
        });

    }

    void compturn() {
        chance.setText("In compturn");
//        Handler hand = new Handler();
        Log.d(l,"\\n\nCOMPT\n");
        number=99;
//        while (number != 1 && compTemp < 20) {

//            Handler hand=new Handler();
//            hand.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    Log.i("hi i am in run",""+number);
//                    comproll();
//                }
//            },300);
//        Log.i("test22",""+number);
//    }
            final Handler h=new Handler();
            Runnable Run=new Runnable() {
                @Override
                public void run() {
                    Log.i("hi i am in run"," : "+number);
                    comproll();
                    if (number!=1 && compTemp<20)
                        Log.i("hi i am in if"," : "+number);
                        h.postDelayed(this, 500);
                }
            };

       // number=0;
        compScore=compScore+compTemp;
        tv4.setText(Integer.toString(compScore));
        compTemp=0;
        chance.setText("Your Chance!!");
        if(compScore>=100){
            won.setText("Computer Won!!");
            chance.setText("");
            roll.setEnabled(false);
            hold.setEnabled(false);
        }


    }

    void comproll(){
        Log.d(l,"\\n\nCOMPROLL\n");
        Log.i("hi i am in compRoll"," : "+number);
//         number = (int) (Math.random() * ((6 - 0) + 1));
        number=new Random().nextInt(5);
        number++;
        Log.i("in comp roll function",""+number);
                switch(number){
                    case 1:
                        img.setImageResource(R.drawable.dice1);
                        compTemp=0;
                        break;
                    case 2:
                        img.setImageResource(R.drawable.dice2);
                        compTemp += 2;
                        break;
                    case 3:
                        img.setImageResource(R.drawable.dice3);
                        compTemp += 3;
                        break;
                    case 4:
                        img.setImageResource(R.drawable.dice4);
                        compTemp += 4;
                        break;
                    case 5:
                        img.setImageResource(R.drawable.dice5);
                        compTemp += 5;
                        break;
                    case 6:
                        img.setImageResource(R.drawable.dice6);
                        compTemp += 6;
                        break;
                        default:
                            comproll();
                }


    }


}
