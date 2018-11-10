package com.limagmail.de.reginatto.lucas.callactionapllication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_telefone);
        final Button button = (Button) findViewById(R.id.botaoOK);
    }
}
