package com.limagmail.de.reginatto.lucas.questao_1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[]opcoes = {"Inter","Corinthians", "Palmeiras","São Paulo","Flamengo","Cruzeiro","Cruzeiro","Grêmio","Vasco"};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.opcoes);
        ArrayAdapter<String> adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_spinner_item,opcoes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner mySpinner= findViewById(R.id.opcoes);
        String text = mySpinner.getSelectedItem().toString();
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
