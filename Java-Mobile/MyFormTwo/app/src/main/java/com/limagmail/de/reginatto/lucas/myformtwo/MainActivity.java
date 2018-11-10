package com.limagmail.de.reginatto.lucas.myformtwo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formbrownser);
        final Button button = (Button) findViewById(R.id.botaoOK);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText campoEndereco = (EditText) findViewById(R.id.campoEndereço);
        String endereco = campoEndereco.getText().toString();
        Uri uri = Uri.parse(endereco);
        Intent it = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(it)   ;
    }
}
