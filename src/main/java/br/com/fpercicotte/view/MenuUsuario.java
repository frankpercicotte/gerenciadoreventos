package br.com.fpercicotte.view;

import br.com.fpercicotte.Model.Usuario;
import br.com.fpercicotte.service.ManipularUsuario;

import java.util.Scanner;

public class MenuUsuario {

    Scanner teclado = new Scanner(System.in);
    ManipularUsuario manipular = new ManipularUsuario();
    public void menuCadastrarUsuario(){
       Usuario novoUsuario;
        ManipularUsuario manipularUsuario = new ManipularUsuario();
        System.out.println("---------------------------------");
        System.out.println("Cadastro de Usuário");
        System.out.println("---------------------------------");

        System.out.print("Nome: ");
        String nome = teclado.nextLine();
        System.out.print("Email: ");
        String email = teclado.nextLine();
        System.out.print("cpf: ");
        String cpf = teclado.nextLine();
        novoUsuario = new Usuario(nome,email,cpf);


        System.out.println("---------------------------------");
        System.out.println(manipular.salvarUsuario(novoUsuario).toString());
        System.out.println("---------------------------------");
    }

    public void listarUsuarios(){
        ManipularUsuario manipular = new ManipularUsuario();
        System.out.println("---------------------------------");
        System.out.println("Listar Usuários");
        System.out.println("---------------------------------");
        manipular.listarUsurarios();
        System.out.println("---------------------------------");
    }

}
