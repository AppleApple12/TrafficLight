package tw.edu.pu.s10703214.trafficlight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        TextView green,yellow,red;
        String greensec,yellowsec,redsec;
        int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //設定全螢幕顯示
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        //設定螢幕為橫式
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.activity_main);
        green=(TextView)findViewById(R.id.edt1);
        yellow=(TextView)findViewById(R.id.edt2);
        red=(TextView)findViewById(R.id.edt3);

        greensec = green.getText().toString();
        yellowsec =yellow.getText().toString();
        redsec = red.getText().toString();

       // int g1=Integer.parseInt(greensec);
        //int y1=Integer.parseInt(yellowsec);
        //int r1=Integer.parseInt(redsec);

    }
    public void StartGame(View v){
        Intent it = new Intent();
        it.setClass(this, GameActivity.class);
        if(greensec.equals("0") || yellowsec.equals("0") || redsec.equals("0")){
            count++;
        }
        if(count>0){
            Toast.makeText(this, "燈號的秒數不能為0",Toast.LENGTH_SHORT)
                    .show();
        }
        if(green.getText().toString().matches("") || yellow.getText().toString().matches("") || red.getText().toString().matches("")){
            Toast.makeText(this, "燈號的秒數不能為空白",Toast.LENGTH_SHORT)
                    .show();
        }else {
            startActivity(it);
            finish();
        }
    }

    public void EndApp(View v){
        finish();
    }
}
