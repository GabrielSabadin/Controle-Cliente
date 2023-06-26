package com.example.controleclientes.activity.activity.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.controleclientes.R;
import com.example.controleclientes.activity.activity.Util.ConfiguraBd;
import com.example.controleclientes.visualizarClientes;
import com.google.android.play.core.integrity.v;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {


    private FirebaseAuth auth;
    private Button visualizar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        auth = ConfiguraBd.Firebaseautenticacao();
        visualizar = findViewById(R.id.buttomVisualizar);
    }

    public void deslogar(View v){
        try {
            auth.signOut();
            finish();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void listagem(View v){
        Intent i = new Intent(this, visualizarClientes.class);
        startActivity(i);
    }
}