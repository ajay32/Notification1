package com.hackingbuzz.notification1;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn_notification);
        btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        addNotification();

    }


    public void addNotification() {

        // now you can also create ..what happen when you click on that notification
        // i want to open  that acitivty or page that described in notification

        Intent intent = new Intent(this, WasteTime.class);

        //pending activity is use to hold the time...ex alam clock it holds the time till morning  // getActivity means pending intent will open that activity
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT); // 1 is request code  // Flag means repalce the old intent with new intent that hold extra data // you can put 0 if you dont wanna set any flag (int value)


        // this will create the notification
        // casting is to tell its from Support library v7 not v4
        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.fb)
                .setContentTitle("Do you really want to Study?")
                .setContentText("Study can really cause you to waste your time.you can go out and have fun.")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)  // it will close the notfication after clicking on it.
                .setColor(Color.RED);  // it will give color to icon
        builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));





        // get hardware access that send msgs to your notification window
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1, builder.build()); // id is 1 and notificationCompat oobject to build notificaition


    }
}
