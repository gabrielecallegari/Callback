package it.itsar.callback;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button esegui;
    private MiaClasse miaClasse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        esegui = findViewById(R.id.esegui);

        miaClasse = new MiaClasse();

        esegui.setOnClickListener(v ->{
            Log.d("LANCIATO", "run: ");
            miaClasse.aspetta(new MiaClasse.MiaInterfaccia() {
                @Override
                public void finito(String ritorno) {
                    Log.d("THREAD", ritorno);
                }

                @Override
                public void crash(String errore) {
                    Log.d("THREAD","Errore:"+errore);
                }
            });
        });
    }



}