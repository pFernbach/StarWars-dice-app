package merwyn.starwarsdice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
        genRand = new Random();
        Intent in = getIntent(); // permet de recuperer les infos de l'ecran precedent
        dices = in.getIntArrayExtra("dices");
        showNumberDice();
        throwDices();
    }
// throw dice depending on number of dice selected, and display it
    private void throwDices() {

    }

    // jete un dés 6, bad = 0 : des de fortune bad = 1 des d'infortune
    private void throwD6(int bad){
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
                results[(3*bad)] ++;
                //todo affichage
                break;
            case 4 :
                results[1+(3*bad)] ++;
                //todo affichage
                break;
            case 5 :
                results[(3*bad)] +=2;
                //todo affichage
                break;
            case 6 :
                results[(3*bad)] ++;
                results[1+(3*bad)] ++;
                //todo affichage
                break;
        }
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
