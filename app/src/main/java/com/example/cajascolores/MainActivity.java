package com.example.cajascolores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    private boolean caja_roja_tocada;
    private boolean caja_azul_tocada;
    private boolean caja_blanca_tocada;
    private boolean caja_amarilla_tocada;
    private boolean caja_verde_tocada;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.caja_amarilla_tocada = false;
        this.caja_verde_tocada = false;
        this.caja_blanca_tocada = false;
        this.caja_roja_tocada = false;
        this.caja_azul_tocada = false;



    }



    private boolean haTocadoTodas ()
    {
        boolean todas_tocadas = false;

            todas_tocadas = (caja_amarilla_tocada && caja_blanca_tocada && caja_roja_tocada && caja_azul_tocada && caja_verde_tocada);

        return todas_tocadas;
    }

    public void cajaTocada(View view){
        //se ha tocado una caja
        String mensaje = null;

        //3 FORMAS DE HACER LA CAJA INVISIBLE
        //view.setBackgroundColor(getResources().getColor(R.color.white)); //"la hacemos desaparecer
        //view.setVisibility(View.GONE);
        view.setVisibility(View.INVISIBLE);
        // Log.d("ETIQUETA_LOG", "CAJA TOCADA "+((ViewGroup)view).getChildAt(0).toString());
        ;
        //tengo que sumar el contador, según la caja que haya tocado
        if (view.getId()==R.id.caja_verde)
        {
            //ha tocado la caja verde
            mensaje = "Ha tocado la caja verde";
            this.caja_verde_tocada = true;

        } else if (view.getId()==R.id.caja_amarilla)
        {
            mensaje = "Ha tocado la caja amarilla";
            this.caja_amarilla_tocada = true;
        } else if (view.getId()==R.id.caja_azul)
        {
            mensaje = "Ha tocado la caja azul";
            this.caja_azul_tocada = true;
        } else if (view.getId()==R.id.caja_roja){
            mensaje = "Ha tocado la caja roja";
            this.caja_roja_tocada = true;
        } else if (view.getId()==R.id.caja_blanca)
        {
            this.caja_blanca_tocada = true;
            mensaje = "Ha tocado la caja blanca";
        }

        if (haTocadoTodas())
        {
            Log.d("ETIQUETA_LOG", "Sí HA TOCADO TODAS, salgo");
            Toast toast = Toast.makeText(this, "HA TOCADO TODAS; SALGO :)", Toast.LENGTH_SHORT);
            //lo muestro
            toast.show();
            this.finish();
        } else {

            Log.d("ETIQUETA_LOG", "NO HA TOCADO TODAS, sigo");
        }

        //deifno el mensaje
        Toast toast = Toast.makeText(this, mensaje, Toast.LENGTH_SHORT);
        //lo muestro
        toast.show();

        //EL TEXTVIEW QUE QUIERO ACTUALIZAR
    }


}

