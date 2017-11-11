package com.example.harsharora.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
//import android.widget.Button;
//import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int activePlayer = 0;// 0=yello 1=red

    int[] gameState ={2,2,2,2,2,2,2,2,2};//2 means unplaed
    int [][] winningPos={{0,1,2},{3,4,5},{6,7,8},{2,4,6},{0,4,8},{0,3,6},{1,4,7},{2,5,8}};


    public void dropIn(View view)
    {
        ImageView counter = (ImageView) view;

        int T = Integer.parseInt(counter.getTag().toString());
        if (gameState[T] == 2) {
            gameState[T]=activePlayer;


            counter.setTranslationY(-1000f);
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yello);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }

            counter.animate().translationYBy(1000f).setDuration(300);
            for (int[] winningP :winningPos)
            {
                if (gameState[winningP[0]]== gameState[winningP[1]]
                        && gameState[winningP[1]]==gameState[winningP[2]]
                        && gameState[winningP[0]]!=2)

                {
                    String winner = "Red";
                    if (gameState[winningP[0]]==0){
                        winner="Yellow";

                 }
                    TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
                    winnerMessage.setText(winner + " has Won!");
                }



            }
        }
    }
    public void playAgain(View view)
    {
        TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
        winnerMessage.setText(" /..");
         activePlayer = 0;// 0=yello 1=red

        for (int i=0;i<gameState.length;i++)
        {
           gameState[i]=2;
            RelativeLayout relLayout = (RelativeLayout)findViewById(R.id.relLayout);
            for(i=0;i<relLayout.getChildCount();i++){
                ((ImageView) relLayout.getChildAt(i)).setImageResource(0);

            }
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}


