package merwyn.numberscrol;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {

    NumberPicker np;
    TextView tv1, tv2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        np = (NumberPicker) findViewById(R.id.numberPicker1);
        tv1 = (TextView) findViewById(R.id.textView2);
        tv2 = (TextView) findViewById(R.id.textView3);

        np.setMinValue(0);
        np.setMaxValue(10);
        np.setWrapSelectorWheel(false); //permet de reboucler (10 avant 0)

        np.setOnValueChangedListener(new OnValueChangeListener() {

            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                // TODO Auto-generated method stub

                String Old = "Old Value : ";
                String New = "New Value : ";

                tv1.setText(Old.concat(String.valueOf(oldVal)));
                tv2.setText(New.concat(String.valueOf(newVal)));
            }
        });
    }

}