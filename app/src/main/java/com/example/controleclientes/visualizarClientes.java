package com.example.controleclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class visualizarClientes extends AppCompatActivity {




    private ListView listaClientes;
    private String[] itens= {"Gabriel", "Usuario", "Sabadin"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_clientes);

        listaClientes = findViewById(R.id.listaClientes);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,android.R.id.text1,itens);

        listaClientes.setAdapter(adaptador);
    }
}