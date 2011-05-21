package se.waltersson.android;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class VerifyParking extends Activity {

    private Button btnSendSMS;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verifyparking);
        btnSendSMS = (Button) findViewById(R.id.btnSend);

        btnSendSMS.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String phoneNo = "123";
                String message = "hejsan";
                if (phoneNo.length() > 0 && message.length() > 0)
                    sendSMS(phoneNo, message);
                else
                    Toast.makeText(getBaseContext(), "Please enter both phone number and message.", Toast.LENGTH_SHORT)
                            .show();
            }
        });
    }

    private void sendSMS(String phoneNumber, String message) {
        PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this, VerifyParking.class), 0);
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, pi, null);
    }
}
