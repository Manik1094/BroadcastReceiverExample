package com.example.helloworld.broadcastreceiverexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    MediaPlayer mediaPlayer;

   public MyReceiver(){
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        String intentAction = intent.getAction();
        mediaPlayer = MediaPlayer.create(context,R.raw.sample );
        if (intentAction != null) {
            String toastMessage = "unknown intent action";
            switch (intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = "Power connected!";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = "Power disconnected!";
                    break;

                case Intent.ACTION_CALL:
                    toastMessage = "Incoming call";

                case Intent.ACTION_HEADSET_PLUG :
                    int state = intent.getIntExtra("state", -1);
                    switch (state) {
                        case 0:
                            mediaPlayer.stop();
                            break;
                        case 1:
                            mediaPlayer.seekTo(30000);
                            mediaPlayer.start();

                            break;
                    }







            }

            //Display the toast.
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }
}
