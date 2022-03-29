package pe.upt.prac_cal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txtPrecio :  EditText = findViewById(R.id.txtP)
        var txtDescuento : EditText = findViewById(R.id.txtD)
        var txtMinimo : EditText = findViewById(R.id.txtM)
        var txtPresupuesto : EditText = findViewById(R.id.txtS)

        var btnVisualizar : Button = findViewById(R.id.btnVisualizar)


        btnVisualizar.setOnClickListener{

         try {
             var precio : Float = txtPrecio.text.toString().toFloat()
             var descuento : Float = txtDescuento.text.toString().toFloat()
             var minimo : Float = txtMinimo.text.toString().toFloat()
             var presupuesto : Float = txtPresupuesto.text.toString().toFloat()

             var acumulado :Float = precio
             var siguiente : Float = precio
             var contador : Int = 0

             while(acumulado <= presupuesto){
                 if(siguiente>=minimo) siguiente = siguiente -descuento
                 acumulado = acumulado + siguiente
                 contador++
             }

             var respuesta : String = "El número total de juegos que podrías comprar es de: " + contador.toString()
             Snackbar.make(
                 findViewById(R.id.txtTitulo),
                 respuesta,
                 Snackbar.LENGTH_INDEFINITE
             ).show()
         }catch (e : Exception){
             Toast.makeText(this,"Coloque valores válidos",Toast.LENGTH_LONG).show()
         }
        }
    }
}