package merwyn.starwarsdice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class DisplayResult extends Activity {

    private int[] dices;
    private int[] results;
    private Toast toast;
    private Random genRand;
    private LinearLayout.LayoutParams params;

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
        params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(5,5,10,5);
        Log.i("DisplayResult","constructor");
        //showNumberDice();
        throwDices();
        displayRez();
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

    private void displayRez() {

        TextView t6 =  (TextView) findViewById(R.id.T6);
        TextView t8 =  (TextView) findViewById(R.id.T8);
        TextView t12 =  (TextView) findViewById(R.id.T12);

        int r6 = results[0]-results[3]; // > 0 -> avantage
        int r8 = results[1]-results[4]; // > 0 -> avantage
        int r12 = results[2]-results[5]; // > 0 -> avantage

        if(r12 > 0){
            t12.setText("Triomphe !!! ("+r12+")");
            t12.setTextColor(getResources().getColor(R.color.c12_good));
        }else if (r12 < 0){
            t12.setText("Désastre ... ("+(-r12)+")");
            t12.setTextColor(getResources().getColor(R.color.c12_bad));
        }

        if(r8 > 0){
            t8.setText("Succès !  ("+r8+")");
            t8.setTextColor(getResources().getColor(R.color.c8_good));
        }else{
            t8.setText("Echec.  ("+(-r8)+")");
            t8.setTextColor(getResources().getColor(R.color.c8_bad));
        }

        if(r6 > 0){
            t6.setText("Avec "+r6+" avantages.");
            t6.setTextColor(getResources().getColor(R.color.c6_good));
        }else if (r6<0){
            t6.setText("Avec "+(-r6)+" menaces.");
            t6.setTextColor(getResources().getColor(R.color.c6_bad));
        }


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
        ImageView iv = new ImageView(this);
        LinearLayout layout = (LinearLayout)findViewById(R.id.d6Glayout);
        long res = (long)(6 * genRand.nextDouble());
        int randomNumber =  (int)(res + 1);
        switch (randomNumber){
            case 1 :
                iv.setImageResource(R.drawable.r6g_1);
                break;
            case 2 :
                iv.setImageResource(R.drawable.r6g_2);
                break;
            case 3 :
                results[1] ++;
                iv.setImageResource(R.drawable.r6g_3);
                break;
            case 4 :
                results[1] ++;
                results[0] ++;
                iv.setImageResource(R.drawable.r6g_4);
                break;
            case 5 :
                results[0] +=2;
                iv.setImageResource(R.drawable.r6g_5);
                break;
            case 6 :
                results[0] ++;
                iv.setImageResource(R.drawable.r6g_6);
                break;
        }
        Log.i("DisplayResult", "D6G :  " + randomNumber+"\n avantage = "+results[0]+"    ; succes = "+results[1]+"\n");
        layout.addView(iv,params);
    }

    private void throwD6B(){
        ImageView iv = new ImageView(this);
        LinearLayout layout = (LinearLayout)findViewById(R.id.d6Blayout);
        long res = (long)(6 * genRand.nextDouble());
        int randomNumber =  (int)(res + 1);
        switch (randomNumber){
            case 1 :
                iv.setImageResource(R.drawable.r6b_1);
                break;
            case 2 :
                iv.setImageResource(R.drawable.r6b_2);
                break;
            case 3 :
                results[4] ++;
                iv.setImageResource(R.drawable.r6b_3);
                break;
            case 4 :
                results[4] ++;
                iv.setImageResource(R.drawable.r6b_4);
                break;
            case 5 :
                results[3] ++;
                iv.setImageResource(R.drawable.r6b_5);
                break;
            case 6 :
                results[3] ++;
                iv.setImageResource(R.drawable.r6b_6);
                break;
        }
        Log.i("DisplayResult", "D6B :  " + randomNumber+"\n menace = "+results[3]+"    ; fail = "+results[4]+"\n");
        layout.addView(iv, params);
    }

    private void throwD8G(){
        ImageView iv = new ImageView(this);
        LinearLayout layout = (LinearLayout)findViewById(R.id.d8Glayout);
        long res = (long)(8 * genRand.nextDouble());
        int randomNumber =  (int)(res + 1);
        switch (randomNumber){
            case 1 :
                iv.setImageResource(R.drawable.r8g_1);
                break;
            case 2 :
                results[1] ++;
                iv.setImageResource(R.drawable.r8g_2);
                break;
            case 3 :
                results[1] ++;
                iv.setImageResource(R.drawable.r8g_3);
                break;
            case 4 :
                results[1] +=2;
                iv.setImageResource(R.drawable.r8g_4);
                break;
            case 5 :
                results[0] ++;
                iv.setImageResource(R.drawable.r8g_5);
                break;
            case 6 :
                results[0] ++;
                iv.setImageResource(R.drawable.r8g_6);
                break;
            case 7 :
                results[0] ++;
                results[1] ++;
                iv.setImageResource(R.drawable.r8g_7);
                break;
            case 8 :
                results[0] +=2;
                iv.setImageResource(R.drawable.r8g_8);
                break;
        }
        Log.i("DisplayResult", "D8G :  " + randomNumber+"\n avantage = "+results[0]+"    ; succes = "+results[1]+"\n");
        layout.addView(iv, params);
    }

    private void throwD8B(){
        ImageView iv = new ImageView(this);
        LinearLayout layout = (LinearLayout)findViewById(R.id.d8Blayout);
        long res = (long)(8 * genRand.nextDouble());
        int randomNumber =  (int)(res + 1);
        switch (randomNumber){
            case 1 :
                iv.setImageResource(R.drawable.r8b_1);
                break;
            case 2 :
                iv.setImageResource(R.drawable.r8b_2);
                results[4] ++;
                break;
            case 3 :
                results[4] +=2;
                iv.setImageResource(R.drawable.r8b_3);
                break;
            case 4 :
                results[3] ++;
                iv.setImageResource(R.drawable.r8b_4);
                break;
            case 5 :
                results[3] ++;
                iv.setImageResource(R.drawable.r8b_5);
                break;
            case 6 :
                results[3] ++;
                iv.setImageResource(R.drawable.r8b_6);
                break;
            case 7 :
                results[3] +=2;
                iv.setImageResource(R.drawable.r8b_7);
                break;
            case 8 :
                results[4] ++;
                results[3] ++;
                iv.setImageResource(R.drawable.r8b_8);
                break;
        }
        Log.i("DisplayResult", "D8B :  " + randomNumber+"\n menace = "+results[3]+"    ; fail = "+results[4]+"\n");
        layout.addView(iv, params);
    }

    private void throwD12G(){
        ImageView iv = new ImageView(this);
        LinearLayout layout = (LinearLayout)findViewById(R.id.d12Glayout);
        long res = (long)(12 * genRand.nextDouble());
        int randomNumber =  (int)(res + 1);
        switch (randomNumber){
            case 1 :
                iv.setImageResource(R.drawable.r12g_1);
                break;
            case 2 :
                results[1] ++;
                iv.setImageResource(R.drawable.r12g_2);
                break;
            case 3 :
                results[1] ++;
                iv.setImageResource(R.drawable.r12g_3);
                break;
            case 4 :
                results[1] +=2;
                iv.setImageResource(R.drawable.r12g_4);
                break;
            case 5 :
                results[1] +=2;
                iv.setImageResource(R.drawable.r12g_5);
                break;
            case 6 :
                results[0] ++;
                iv.setImageResource(R.drawable.r12g_6);
                break;
            case 7 :
                results[0] ++;
                results[1] ++;
                iv.setImageResource(R.drawable.r12g_7);
                break;
            case 8 :
                results[0] ++;
                results[1] ++;
                iv.setImageResource(R.drawable.r12g_8);
                break;
            case 9 :
                results[0] ++;
                results[1] ++;
                iv.setImageResource(R.drawable.r12g_9);
                break;
            case 10 :
                results[0] +=2;
                iv.setImageResource(R.drawable.r12g_10);
                break;
            case 11 :
                results[0] +=2;
                iv.setImageResource(R.drawable.r12g_11);
                break;
            case 12 :
                results[2] ++;
                iv.setImageResource(R.drawable.r12g_12);
                break;
        }
        Log.i("DisplayResult", "D12G :  " + randomNumber+"\n avantage = "+results[0]+"  ; succes = "+results[1]+ "  ; triomphe = "+results[2]+"\n");
        layout.addView(iv, params);
    }

    private void throwD12B(){
        ImageView iv = new ImageView(this);
        LinearLayout layout = (LinearLayout)findViewById(R.id.d12Blayout);
        long res = (long)(12 * genRand.nextDouble());
        int randomNumber =  (int)(res + 1);
        switch (randomNumber){
            case 1 :
                iv.setImageResource(R.drawable.r12b_1);
                break;
            case 2 :
                results[4] ++;
                iv.setImageResource(R.drawable.r12b_2);
                break;
            case 3 :
                results[4] ++;
                iv.setImageResource(R.drawable.r12b_3);
                break;
            case 4 :
                results[4] +=2;
                iv.setImageResource(R.drawable.r12b_4);
                break;
            case 5 :
                results[4] +=2;
                iv.setImageResource(R.drawable.r12b_5);
                break;
            case 6 :
                results[3] ++;
                iv.setImageResource(R.drawable.r12b_6);
                break;
            case 7 :
                results[3] ++;
                iv.setImageResource(R.drawable.r12b_7);
                break;
            case 8 :
                results[3] ++;
                results[4] ++;
                iv.setImageResource(R.drawable.r12b_8);
                break;
            case 9 :
                results[3] ++;
                results[4] ++;
                iv.setImageResource(R.drawable.r12b_9);
                break;
            case 10 :
                results[3] +=2;
                iv.setImageResource(R.drawable.r12b_10);
                break;
            case 11 :
                results[3] +=2;
                iv.setImageResource(R.drawable.r12b_11);
                break;
            case 12 :
                results[5] ++;
                iv.setImageResource(R.drawable.r12b_12);
                break;
        }
        Log.i("DisplayResult", "D12B :  " + randomNumber+"\n menace = "+results[3]+"  ; fail = "+results[4]+ "  ; desastre = "+results[5]+"\n");
        layout.addView(iv, params);
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
