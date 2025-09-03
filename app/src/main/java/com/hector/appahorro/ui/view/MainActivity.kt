package com.hector.appahorro



//para boton flotante
import android.os.Bundle
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import android.view.MenuItem

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMenu = findViewById<Button>(R.id.btnAñadir)

        btnMenu.setOnClickListener {
            val popup = PopupMenu(this, btnMenu)
            popup.menuInflater.inflate(R.menu.menu_opciones, popup.menu)

            popup.setOnMenuItemClickListener { item:MenuItem ->
                when (item.itemId){
                    R.id.ingresar_ingreso ->{
                        Toast.makeText(this, "elegiste ingresar ingreso xd", Toast.LENGTH_SHORT).show()
                        true

                    }
                    R.id.ingresar_gasto ->{
                        Toast.makeText(this, "elegiste ingresar gasto xdd", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.ingresar_ahorro ->{
                        Toast.makeText(this, "elegiste ingresar ahorro xdd", Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }

         popup.show()
        }


    }
}
