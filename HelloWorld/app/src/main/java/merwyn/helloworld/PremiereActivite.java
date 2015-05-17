package merwyn.helloworld;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;


public class PremiereActivite extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_premiere_activite);

        TextView text = new TextView(this);
      //  text.setText("Hello world");
       // text.setText(R.string.hello_world);
        String hello = getResources().getString(R.string.hello_world);
        hello = hello.replace("world","patate");
        text.setText(hello);
        setContentView(text);


    }

}
