package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int activePlayer=0;
    //0 for Red
    //1 for Yellow
    //2 for empty

    int []gameState={2,2,2,2,2,2,2,2,2};
    //GameState tells the whole scenario of the game ,at which position red or yellow are placed
    //initially all are empty

    int[][] winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};






    public void dropIn(View view){
        //view contains the view of the specific cell
        ImageView counter=(ImageView)view;

       int cellTag=Integer.parseInt(counter.getTag().toString());

       gameState[cellTag]=activePlayer;



        counter.setTranslationY(-1500);

        if(activePlayer==0){
            //Red turn
            counter.setImageResource(R.drawable.red);
            activePlayer=1;
        }
        else{
            //Yellow Turn
            counter.setImageResource(R.drawable.yellow);
            activePlayer=0;

        }
        counter.animate().translationYBy(1500).rotation(3600).setDuration(300);



        //now checking the winner

        for(int[] winningPosition:winningPositions){
            if(gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]]!=2){
                //Toast.makeText(this, "Someone has won", Toast.LENGTH_SHORT).show();
                String winner="";
                if(activePlayer==1){
                    winner="Red";
                }
                else{
                    winner="Yellow";
                }
                Toast.makeText(this, winner +" has won", Toast.LENGTH_SHORT).show();
            }
        }
` `




    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
