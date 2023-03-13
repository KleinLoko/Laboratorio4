package com.example.laboratorio4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class WhatsappActivity extends AppCompatActivity {
    private Button btnEnviarPedido;
    private String mensaje;

    RadioButton rbtnChico ;
    RadioButton rbtnMediano ;
    RadioButton rbtnGrande ;
    RadioButton rbtnRojo ;
    RadioButton rbtnVerde;
    CheckBox cbCebolla ;
    CheckBox cbRabano;
    CheckBox cbLimon ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatsapp);
        String phone = "524631098212";

        mensaje = obtenermensaje();

        btnEnviarPedido =  (Button) findViewById(R.id.ConfirmarPedido);

        ActivityCompat.requestPermissions(WhatsappActivity.this, new String[]{Manifest.permission.SEND_SMS},1);

        btnEnviarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ActivityCompat.checkSelfPermission(WhatsappActivity.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(WhatsappActivity.this, new String[]{Manifest.permission.SEND_SMS},1);
                }

                mensaje = obtenermensaje();

                Intent sendIntent =  new Intent();
                sendIntent.setAction(Intent.ACTION_VIEW);
                String uri =  "whatsapp://send?phone="+phone+"&text="+mensaje;
                sendIntent.setData(Uri.parse(uri));
                startActivity(sendIntent);
            }
        });
    }

    private String obtenermensaje() {

        String mensaje = "Muchas gracias por elejirnos \n " +
                "Su pedido fue este: ";

         rbtnChico = (RadioButton) findViewById(R.id.rbtnChico);
         rbtnMediano = (RadioButton) findViewById(R.id.Mediano);
         rbtnGrande = (RadioButton) findViewById(R.id.Grande);
         rbtnRojo = (RadioButton)  findViewById(R.id.rbtnPozoleRojo);
         rbtnVerde = (RadioButton) findViewById(R.id.rbtnPozoleVerde);

         cbCebolla = (CheckBox) findViewById(R.id.cbCebolla);
         cbRabano = (CheckBox) findViewById(R.id.cbRabano);
         cbLimon = (CheckBox) findViewById(R.id.cbLimon);

        if(rbtnChico.isChecked()){
            mensaje = mensaje + "\n\nTamaño: Chico";

        }else if (rbtnMediano.isChecked()){
            mensaje = mensaje + "\n\nTamaño: Mediano";
        }else if(rbtnGrande.isChecked()){
            mensaje = mensaje + "\n\nTamaño: Grande";
        }

        if (rbtnRojo.isChecked()){
            mensaje = mensaje + "\n\nTipo: Rojo";
        }else if (rbtnVerde.isChecked()){
            mensaje = mensaje + "\n\nTipo: Verde";
        }

        mensaje = mensaje + "\n\nIngredientes Extra:";

        if(cbCebolla.isChecked()  ){
            mensaje = mensaje + "\nCebolla";
        }

        if(cbRabano.isChecked()){
            mensaje = mensaje + "\nRabano";
        }

        if(cbLimon.isChecked()){
            mensaje = mensaje + "\nLimon";
        }

        mensaje = mensaje + "\n\nSu pedido está en camino :D";
        return mensaje;
    }


}