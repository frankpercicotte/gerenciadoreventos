package br.com.fpercicotte.service;

import br.com.fpercicotte.Model.Usuario;

import java.util.ArrayList;
import java.util.List;


public class ManipularUsuario {

    final static List<Usuario> arrayUsuarios = new ArrayList<>();
    private int index;

    public Usuario salvarUsuario(Usuario usuario){
        index = arrayUsuarios.size();
        usuario.setId(index);
        this.arrayUsuarios.add(usuario);
        return arrayUsuarios.get(index);
    }

    public boolean deletarUsuario(Usuario usuario){
        if (arrayUsuarios.contains(usuario)){
            arrayUsuarios.remove(usuario);
            return true;
        }
        return false;
    }

    public int getIndex(){
        return this.index;
    }

    public void listarUsurarios(){
        for (Usuario usr: arrayUsuarios) {
            System.out.println(usr.toString());
        }
    }
}
