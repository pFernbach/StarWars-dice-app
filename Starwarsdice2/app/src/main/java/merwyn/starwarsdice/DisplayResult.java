package merwyn.starwarsdice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;


public class DisplayResult extends Activity {

    private int[] dices;
    private int[] results;
    private Toast toast;
    private Random genRand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);
        toast =Toast.makeText(this,"",Toast.LENGTH_LONG);
        results = new int[6];
        for(int i = 0 ; i < 6 ; i++) results[i] = 0;
        genRand = new Random();
        Intent in = getIntent(); // permet de recuperer les infos de l'ecran precedent
        dices = in.getIntArrayExtra("dices");
        Log.i("DisplayResult","constructor");
        showNumberDice();
        throwDices();
        View.OnClickListener onClickLister = new View. OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayResult.this.finish();
                return;
            }
        };
        Button reset = (Button) findViewById(R.id.btreset);
        reset.setOnClickListener(onClickLister);
        return;
    }
// throw dice depending on number of dice selected, and display it
    private void throwDices() {
        int i;
        for(i=0;i<dices[0];i++) throwD6G();
        for(i=0;i<dices[1];i++) throwD8G();
        for(i=0;i<dices[2];i++) throwD12G();
        for(i=0;i<dices[3];i++) throwD6B();
        for(i=0;i<dices[4];i++) throwD8B();
        for(i=0;i<dices[5];i++) throwD12B();
    }

    private void throwD6G(){
        long res = (long)(6 * genRand.nextDouble());
        int randomNumber =  (int)(res + 1);
        switch (randomNumber){
            case 1 :
                //todo affichage
                break;
            case 2 :
                //todo affichage
                break;
            case 3 :
                results[1] ++;
                //todo affichage
                break;
            case 4 :
                results[1] ++;
                results[0] ++;
                //todo affichage
                break;
            case 5 :
                results[0] +=2;
                //todo affichage
                break;
            case 6 :
                results[0] ++;
                //todo affichage
                break;
        }
        Log.i("DisplayResult", "D6G :  " + randomNumber+"\n avantage = "+results[0]+"    ; succes = "+results[1]+"\n");

    }

    private void throwD6B(){
        long res = (long)(6 * genRand.nextDouble());
        int randomNumber =  (int)(res + 1);
        switch (randomNumber){
            case 1 :
                //todo affichage
                break;
            case 2 :
                //todo affichage
                break;
            case 3 :
                results[4] ++;
                //todo affichage
                break;
            case 4 :
                results[4] ++;
                //todo affichage
                break;
            case 5 :
                results[3] ++;
                //todo affichage
                break;
            case 6 :
                results[3] ++;
                //todo affichage
                break;
        }
        Log.i("DisplayResult", "D6B :  " + randomNumber+"\n menace = "+results[3]+"    ; fail = "+results[4]+"\n");

    }

    private void throwD8G(){
        long res = (long)(8 * genRand.nextDouble());
        int randomNumber =  (int)(res + 1);
        switch (randomNumber){
            case 1 :
                //todo affichage
                break;
            case 2 :
                results[1] ++;
                //todo affichage
                break;
            case 3 :
                results[1] ++;
                //todo affichage
                break;
            case 4 :
                results[1] +=2;
                //todo affichage
                break;
            case 5 :
                results[0] ++;
                //todo affichage
                break;
            case 6 :
                results[0] ++;
                //todo affichage
                break;
            case 7 :
                results[0] ++;
                results[1] ++;
                //todo affichage
                break;
            case 8 :
                results[0] +=2;
                //todo affichage
                break;
        }
        Log.i("DisplayResult", "D8G :  " + randomNumber+"\n avantage = "+results[0]+"    ; succes = "+results[1]+"\n");
    }

    private void throwD8B(){
        long res = (long)(8 * genRand.nextDouble());
        int randomNumber =  (int)(res + 1);
        switch (randomNumber){
            case 1 :
                //todo affichage
                break;
            case 2 :
                //todo affichage
                results[4] ++;
                break;
            case 3 :
                results[4] +=2;
                //todo affichage
                break;
            case 4 :
                results[3] ++;
                //todo affichage
                break;
            case 5 :
                results[3] ++;
                //todo affichage
                break;
            case 6 :
                results[3] ++;
                //todo affichage
                break;
            case 7 :
                results[3] +=2;
                //todo affichage
                break;
            case 8 :
                results[4] ++;
                results[3] ++;
                //todo affichage
                break;
        }
        Log.i("DisplayResult", "D8B :  " + randomNumber+"\n menace = "+results[3]+"    ; fail = "+results[4]+"\n");

    }

    private void throwD12G(){
        long res = (long)(12 * genRand.nextDouble());
        int randomNumber =  (int)(res + 1);
        switch (randomNumber){
            case 1 :
                //todo affichage
                break;
            case 2 :
                results[1] ++;
                break;
            case 3 :
                results[1] ++;
                //todo affichage
                break;
            case 4 :
                results[1] +=2;
                //todo affichage
                break;
            case 5 :
                results[1] +=2;
                //todo affichage
                break;
            case 6 :
                results[0] ++;
                //todo affichage
                break;
            case 7 :
                results[0] ++;
                results[1] ++;
                //todo affichage
                break;
            case 8 :
                results[0] ++;
                results[1] ++;
                //todo affichage
                break;
            case 9 :
                results[0] ++;
                results[1] ++;
                //todo affichage
                break;
            case 10 :
                results[0] +=2;
                //todo affichage
                break;
            case 11 :
                results[0] +=2;
                //todo affichage
                break;
            case 12 :
                results[2] ++;
                //todo affichage
                break;
        }
        Log.i("DisplayResult", "D12G :  " + randomNumber+"\n avantage = "+results[0]+"  ; succes = "+results[1]+ "  ; triomphe = "+results[2]+"\n");

    }

    private void throwD12B(){
        long res = (long)(12 * genRand.nextDouble());
        int randomNumber =  (int)(res + 1);
        switch (randomNumber){
            case 1 :
                //todo affichage
                break;
            case 2 :
                results[4] ++;
                break;
            case 3 :
                results[4] ++;
                //todo affichage
                break;
            case 4 :
                results[4] +=2;
                //todo affichage
                break;
            case 5 :
                results[4] +=2;
                //todo affichage
                break;
            case 6 :
                results[3] ++;
                //todo affichage
                break;
            case 7 :
                results[3] ++;
                //todo affichage
                break;
            case 8 :
                results[3] ++;
                results[4] ++;
                //todo affichage
                break;
            case 9 :
                results[3] ++;
                results[4] ++;
                //todo affichage
                break;
            case 10 :
                results[3] +=2;
                //todo affichage
                break;
            case 11 :
                results[3] +=2;
                //todo affichage
                break;
            case 12 :
                results[5] ++;
                //todo affichage
                break;
        }
        Log.i("DisplayResult", "D12B :  " + randomNumber+"\n menace = "+results[3]+"  ; fail = "+results[4]+ "  ; desastre = "+results[5]+"\n");

    }


    private void showNumberDice() {
        StringBuilder message = new StringBuilder();
        message.append("Dès selectionnée (result) : \n");
        message.append(dices[0]);
        message.append("  fortune \n");
        message.append(dices[1]);
        message.append("  aptitude \n");
        message.append(dices[2]);
        message.append("  maitrise \n");
        message.append(dices[3]);
        message.append("  infortune \n");
        message.append(dices[4]);
        message.append("  difficulté \n");
        message.append(dices[5]);
        message.append("  défi");
        toast.setText(message.toString());
        toast.show();

    }


}
