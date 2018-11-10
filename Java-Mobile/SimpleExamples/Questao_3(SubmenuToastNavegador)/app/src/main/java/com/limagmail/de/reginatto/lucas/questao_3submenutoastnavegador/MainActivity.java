package com.limagmail.de.reginatto.lucas.questao_3submenutoastnavegador;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.SubMenu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.mensagem).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Mensagem de Teste!!Mensagem", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.sair).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.exit(0);
            }
        });

        findViewById(R.id.opcoes).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CharSequence options[] = new CharSequence[] {"Tela 2", "Site Google"};

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Opções");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which == 0){
                            Intent it = new Intent(MainActivity.this,NovaTela.class);
                            startActivity(it);
                        }
                        if(which == 1){
                            String url = "https://google.com.br";
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse(url));
                            startActivity(i);
                        }
                    }
                });
                builder.show();
            }
        });
    }
}
