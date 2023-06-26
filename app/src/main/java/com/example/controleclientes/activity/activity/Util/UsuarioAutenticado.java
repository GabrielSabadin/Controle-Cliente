package com.example.controleclientes.activity.activity.Util;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UsuarioAutenticado {

    public static FirebaseUser usuarioLogado(){
        FirebaseAuth usuario = ConfiguraBd.Firebaseautenticacao();
        return usuario.getCurrentUser();
    }
}
