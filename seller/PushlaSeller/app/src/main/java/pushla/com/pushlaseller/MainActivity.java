package pushla.com.pushlaseller;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
    private Button btnKirim;
    private TextView nomorTujuan, isiText;
    private Context ctx;
    private GCMHandler gcmHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnKirim = (Button) findViewById(R.id.idSendButton);
        isiText = (TextView) findViewById(R.id.idIsiSms);
        nomorTujuan = (TextView) findViewById(R.id.idNomorTujuan);
        ctx = this;
        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String isi = isiText.getText().toString();
                String tujuan = nomorTujuan.getText().toString();
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(tujuan, null, isi, null, null);
                Toast.makeText(ctx, "SMS sent.",
                        Toast.LENGTH_LONG).show();
            }
        });

        gcmHandler = new GCMHandler(this);
        gcmHandler.setupGCM();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
