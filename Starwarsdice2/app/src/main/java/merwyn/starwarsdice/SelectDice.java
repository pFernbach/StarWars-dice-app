package merwyn.starwarsdice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.util.ArrayList;


public class SelectDice extends Activity {

    ArrayList<NumberPicker> nps; // list des selecteurs de nombre

    // The following are used for the shake detection
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;

    private Toast toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_dice);
        toast =Toast.makeText(this,"",Toast.LENGTH_LONG);


        nps = new ArrayList<NumberPicker>();
        nps.add((NumberPicker) findViewById(R.id.np6G));
        nps.add((NumberPicker) findViewById(R.id.np8G));
        nps.add((NumberPicker) findViewById(R.id.np12G));
        nps.add((NumberPicker) findViewById(R.id.np6B));
        nps.add((NumberPicker) findViewById(R.id.np8B));
        nps.add((NumberPicker) findViewById(R.id.np12B));

        for(NumberPicker np : nps){
            np.setMinValue(0);
            np.setMaxValue(9);
            np.setWrapSelectorWheel(false);

        }

        Button btgo = (Button) findViewById(R.id.btgo);
        Button btraz = (Button) findViewById(R.id.btraz);

        btraz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(NumberPicker np : nps){
                    np.setValue(0);
                }
            }
        });

        btgo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               throwDice();
            }
        });


        // ShakeDetector initialization
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector();
        mShakeDetector.setOnShakeListener(new ShakeDetector.OnShakeListener() {
            @Override
            public void onShake() {
                throwDice();
            }
        });

    }

    private void throwDice(){
//        showMessage();
        Intent i = new Intent(getApplicationContext(), DisplayResult.class);

        // met en forme et envoie les info du nombre de des a l'ecran de resultat
        int dices[];
        dices = new int [6];
        dices[0] = nps.get(0).getValue();
        dices[1] = nps.get(1).getValue();
        dices[2] = nps.get(2).getValue();
        dices[3] = nps.get(3).getValue();
        dices[4] = nps.get(4).getValue();
        dices[5] = nps.get(5).getValue();
        Log.i("SelectDices","mid throwdice");
        i.putExtra("dices", dices);
        startActivityForResult(i, 1);
        Log.i("SelectDices","end throwdice");

    }

    private void showMessage() {
        StringBuilder message = new StringBuilder();
        message.append("Dès selectionnée : \n");
        message.append(nps.get(0).getValue());
        message.append("  fortune \n");
        message.append(nps.get(1).getValue());
        message.append("  aptitude \n");
        message.append(nps.get(2).getValue());
        message.append("  maitrise \n");
        message.append(nps.get(3).getValue());
        message.append("  infortune \n");
        message.append(nps.get(4).getValue());
        message.append("  difficulté \n");
        message.append(nps.get(5).getValue());
        message.append("  défi");
        toast.setText(message.toString());
        toast.show();

    }


    @Override
    public void onResume() {
        super.onResume();
        // Add the following line to register the Session Manager Listener onResume
        mSensorManager.registerListener(mShakeDetector, mAccelerometer,	SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        // Add the following line to unregister the Sensor Manager onPause
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }


}
