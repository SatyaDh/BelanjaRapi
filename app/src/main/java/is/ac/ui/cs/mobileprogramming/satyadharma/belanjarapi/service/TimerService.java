package is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.service;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.R;
import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.activity.MainActivity;

public class TimerService extends Service {
    private final static String TAG = "TimerService";
    public static final String CHANNEL_ID = "is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.notifId";
    public static final String COUNTDOWN_BR = "is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.countdown_br";
    Intent bi = new Intent(COUNTDOWN_BR);

    private NotificationManager notificationManager;
    private Notification noti;


    CountDownTimer cdt = null;

    @Override
    public void onCreate() {
        super.onCreate();
        notificationManager =
                (NotificationManager) getSystemService(Service.NOTIFICATION_SERVICE);
        createNotificationChannel(notificationManager);
        Intent notificationIntent = new Intent(getApplicationContext(), MainActivity.class);
        PendingIntent pending = PendingIntent.getActivity(this,0,notificationIntent,0);
        noti = new NotificationCompat.Builder(getApplicationContext(),CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText("Done!")
                .setContentInfo("Your Shopping should be done by now!")
                .setContentIntent(pending)
                .setAutoCancel(true)
                .build();

        cdt = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                Log.i(TAG, "Countdown seconds remaining: " + millisUntilFinished / 1000);
                bi.putExtra("countdown", millisUntilFinished);
                sendBroadcast(bi);
            }

            @Override
            public void onFinish() {

                Log.i(TAG, "Timer finished");
                notificationManager.notify(0, noti);
                onDestroy();
            }
        };

        cdt.start();


    }

    @Override
    public void onDestroy() {

        cdt.cancel();
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void createNotificationChannel(NotificationManager notificationManager) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.notification);
            String description = getString(R.string.notification_desc);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            notificationManager.createNotificationChannel(channel);
        }
    }

}
