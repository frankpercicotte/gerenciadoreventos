package br.com.fpercicotte.service;

import br.com.fpercicotte.Model.Usuario;

import java.util.ArrayList;
import java.util.List;


public class ManipularUsuario {

    final static List<Usuario> arrayUsuarios = new ArrayList<>();
    private int index;

    public Usuario salvarUsuario(Usuario usuario){
        index = arrayUsuarios.size();
        usuario.setId(index+1);
        this.arrayUsuarios.add(usuario);
        return arrayUsuarios.get(index--);
    }

    public boolean deletarUsuario(int id){
        Usuario usuario = null;
        for (Usuario usr: arrayUsuarios) {
           if(usr.getId() == id){
               usuario = usr;
           }
        }
        if (usuario != null){
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
