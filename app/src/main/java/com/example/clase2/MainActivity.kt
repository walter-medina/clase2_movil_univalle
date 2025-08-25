package com.example.clase2

import android.graphics.Color
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.example.clase2.databinding.ActivityMainBinding
import com.google.android.material.chip.Chip
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        //setContentView(R.layout.activity_main)
        toast()
        //snackBar()
         //textView()
//        editText()
//        autoCompleteTextView()
//        button()
//        chip()
//        radioButton()
//        checkBox()
//        toggleButton()
//        switch()
        //floatActionButton()
    }

    private fun toast(){
        Toast.makeText(this,"Hola mundo !!", Toast.LENGTH_LONG).show()
    }

    private fun snackBar(){
        val viewContainer:LinearLayout = binding.llContenedor
        Snackbar.make(viewContainer, "Hola estudiantes",Snackbar.LENGTH_LONG).show()
    }

    private fun textView(){
        //usando binding:
        binding.tvTitulo.text = "Bienvenidos"
        //binding.tvTitulo.setTextColor(Color.RED)
        binding.tvTitulo.resources.getColor(R.color.black, null)
        binding.tvTitulo.textSize = 35f
    }

    private fun editText(){
       binding.etNombre.addTextChangedListener {
           var nombre = binding.etNombre.text
           if (nombre.isNotEmpty()){
               binding.tvTitulo.setTextColor(Color.GREEN)
//               val color = ContextCompat.getColor(this, R.color.orange)
//               binding.tvTitulo.setTextColor(color)
               val nuevoIcono = ContextCompat.getDrawable(this, R.drawable.ic_java)
               binding.etNombre.setCompoundDrawablesWithIntrinsicBounds(nuevoIcono, null, null, null)

           }else{
               binding.tvTitulo.setTextColor(Color.RED)
           }
       }
    }

    private fun autoCompleteTextView(){
        val listaPaises : Array<String> = resources.getStringArray(R.array.listaPaises)
        // se debe crear un adapter, es un puente entre la lista de paises y el autoCompleteTextView
        val adapter: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, listaPaises)
        binding.atPais.setAdapter(adapter)
    }

    private fun button(){
        //TODO: hacerle el evento con toast
        binding.btnIniciarSesion.setOnClickListener {
            val nombre = binding.etNombre.text
            Toast.makeText(this, " ${nombre}", Toast.LENGTH_LONG).show()
        }
    }

    private fun chip(){
        var listaLenguajes = binding.cgLenguajes

        for(i in 0..<listaLenguajes.childCount){
            var chip = listaLenguajes.getChildAt(i) as Chip
            chip.setOnCloseIconClickListener { chip ->
                listaLenguajes.removeView(chip)
            }
        }

    }
    private fun radioButton(){
      binding.rgContenedor.setOnCheckedChangeListener { _, checkedId ->
          when(checkedId){
              R.id.rbAndroid -> Toast.makeText(this, "Bienvenido a Android", Toast.LENGTH_SHORT).show()
              R.id.rbiOs -> Toast.makeText(this, "Bienvenido a iOS", Toast.LENGTH_SHORT).show()
          }
      }
    }

    private fun checkBox(){
        binding.cbOpcion1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                Toast.makeText(this, "Marcaste la opcion 1", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Desmarcado", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun toggleButton(){
        binding.tbOpcion.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked)  Toast.makeText(this, "Toogle Activado", Toast.LENGTH_LONG).show()
            else  Toast.makeText(this, "Toogle Desactivado", Toast.LENGTH_SHORT).show()
        }
    }

    private fun switch(){
        binding.swActivar.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked)  Toast.makeText(this, "switch  Activado", Toast.LENGTH_SHORT).show()
            else  Toast.makeText(this, "switch Desactivado", Toast.LENGTH_SHORT).show()
        }
    }

    private fun floatActionButton() {
        binding.fbagregar.setOnClickListener{
            Toast.makeText(this, "Se adicionó", Toast.LENGTH_SHORT).show()
        }
    }

}