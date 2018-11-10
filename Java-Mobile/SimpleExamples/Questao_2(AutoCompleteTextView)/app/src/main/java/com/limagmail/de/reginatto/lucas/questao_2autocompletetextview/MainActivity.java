package com.limagmail.de.reginatto.lucas.questao_2autocompletetextview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_dropdown_item_1line, COLEGAS);
        AutoCompleteTextView textView = findViewById(R.id.colega);
        textView.setAdapter(adapter);
    }
    private static final String[] COLEGAS = new String[] {
            "Adalberto", "Alan", "Eduardo", "Rafaela", "Roberta", "Márcio", "Mário", "Juliana", "Valdir", "Lucas", "Luis"
    };
}
