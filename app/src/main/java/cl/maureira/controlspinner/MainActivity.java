package cl.maureira.controlspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private EditText et1, et2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.txtValor1);
        et2 = (EditText)findViewById(R.id.txtValor2);
        tv1 = (TextView)findViewById(R.id.tvResultado);

        spinner1 = (Spinner)findViewById(R.id.spinner);

        String [] opciones = {"Sumar", "Restar", "Multiplicar", "Dividir"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, opciones);
        spinner1.setAdapter(adapter);

    }

    public void button(View view){
        String strEt1 = et1.getText().toString();
        String strEt2 = et2.getText().toString();

        int intEt1 = Integer.parseInt(strEt1);
        int intEt2 = Integer.parseInt(strEt2);

        String opcion = spinner1.getSelectedItem().toString();

        switch (opcion){
            case "Sumar": tv1.setText(String.valueOf(intEt1 + intEt2));  break;
            case "Restar": tv1.setText(String.valueOf(intEt1 - intEt2));  break;
            case "Multiplicar": tv1.setText(String.valueOf(intEt1 * intEt2));  break;
            case "Dividir": if(intEt2 == 0)
                                Toast.makeText(this, "Dividendo no puede ser igual a cero", Toast.LENGTH_SHORT).show();
                            else
                                tv1.setText(String.valueOf(intEt1 / intEt2));  break;
            default:
                Toast.makeText(this, "Opcion no seleccionada", Toast.LENGTH_SHORT).show();
        }

    }


}