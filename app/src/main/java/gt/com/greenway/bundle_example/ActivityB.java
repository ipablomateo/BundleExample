package gt.com.greenway.bundle_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvEdad;
    private TextView tvTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvEdad = (TextView) findViewById(R.id.tvEdad);
        tvTexto = (TextView) findViewById(R.id.tvTexto);

        //Aqui recibimos el bundle que enviamos en el intento en la actividad anterior
        //con getIntent().getExtras()
        Bundle bundle = getIntent().getExtras();

        //validamos que el bundle no venga vacio o que no sea null
        if(bundle!=null){
            //Creamos un nuevo objeto persona y cargamos el objeto que venia en el bundle
            //con la etiqueta PERSONA
            Persona persona = (Persona) bundle.get("PERSONA");

            tvNombre.setText(persona.getNombre());
            tvEdad.setText(String.valueOf(persona.getEdad()));

            //cargamos el string que viene en el bundle con la etiqueta texto
            tvTexto.setText(bundle.getString("TEXTO"));
        }

    }
}
