package com.limagmail.de.reginatto.lucas.questao_4gridviewmediaplayer;

import android.app.Activity;
import android.app.AlertDialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    ImageView iv;
    ImageView iv2;
    MediaPlayer mediaPlayer;
    AlertDialog alerta;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.iv = findViewById(R.id.brasil);
        this.iv2 = findViewById(R.id.uruguai);

        iv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.hinobacionalbrasileiro);
                mediaPlayer.start();
            }
        });

        iv2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("País Escolhido");
                builder.setMessage("Uruguai");
                alerta = builder.create();
                alerta.show();
            }
        });
    }
}
