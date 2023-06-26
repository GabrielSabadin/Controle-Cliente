package com.example.controleclientes.activity.activity.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.controleclientes.R;
import com.example.controleclientes.activity.activity.Model.Usuario;
import com.example.controleclientes.activity.activity.Util.ConfiguraBd;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;


public class CadastroActivity extends AppCompatActivity {

    Usuario usuario;
    FirebaseAuth autenticacao;

    //Cria variaveis para os text e o botao

    EditText campoNome,campoEmail,campoSenha;
    Button botaoCadastrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        inicializar();
    }

    //Atribui o valor para as variaveis vindo dos edit texts.
    private void inicializar(){

        campoNome = findViewById(R.id.editTextNome);
        campoEmail = findViewById(R.id.editTextEmail);
        campoSenha = findViewById(R.id.editTextSenha);
        botaoCadastrar = findViewById(R.id.buttonCadastrar);
    }

    //Validacao

    public void validarCampos(View v){
        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();
        String senha = campoSenha.getText().toString();

        // se estiver vazio, pedira pra preencher para os 3 campos
        if(!nome.isEmpty()){
            if(!email.isEmpty()){
                if(!senha.isEmpty()){

                    usuario = new Usuario();

                    usuario.setNome(nome);
                    usuario.setEmail(email);
                    usuario.setSenha(senha);

                    //cadastro do usuario
                    cadastrarUsuario();

                }else{
                    Toast.makeText(this, "Escreva um senha", Toast.LENGTH_SHORT).show();
                }

            }else{
                Toast.makeText(this, "Escreva um email", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Escreva um nome", Toast.LENGTH_SHORT).show();
        }

    }

    private void cadastrarUsuario() {

        autenticacao = ConfiguraBd.Firebaseautenticacao();

        autenticacao.createUserWithEmailAndPassword(
                usuario.getEmail(),usuario.getSenha()
        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(CadastroActivity.this, "Usuario cadastrado", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(CadastroActivity.this, "Erro ao cadastrar", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}