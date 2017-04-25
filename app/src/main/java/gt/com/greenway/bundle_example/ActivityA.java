package gt.com.greenway.bundle_example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityA extends AppCompatActivity {

    private EditText etNombre;
    private EditText etEdad;
    private EditText etTexto;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        setupView();
    }

    private void setupView() {
        etNombre = (EditText) findViewById(R.id.etNombre);
        etEdad = (EditText) findViewById(R.id.etEdad);
        etTexto = (EditText) findViewById(R.id.etTexto);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //esto deberia ir en el evento onitemclicklistener
                //en un listview

                //Declaracion y asignacion de variables
                String nombre = etNombre.getText().toString();
                int edad = Integer.parseInt(etEdad.getText().toString());
                String texto = etTexto.getText().toString();

                //Creamos un objeto de tipo persona
                Persona persona = new Persona(nombre, edad);

                //Creamos un bundle
                Bundle bundle = new Bundle();
                //.putSerializable es para poner un objeto, PERSONA es la etiqueta
                //equivalente a un id para recibirlo en el otro activity
                bundle.putSerializable("PERSONA", persona);
                //.putString para enviar un String, TEXTO es la etiqueta
                //equivalente a un id para recibirlo en el otro activity
                bundle.putString("TEXTO", texto);
                //tambien podrías enviar un int por ejemplo

                //Aqui le ponemos el bundle al intent
                Intent intent = new Intent(getApplicationContext(), ActivityB.class).putExtras(bundle);
                //llamamos al Activity
                startActivity(intent);

            }
        });
    }
}
