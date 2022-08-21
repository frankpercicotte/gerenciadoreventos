package br.com.fpercicotte.view;

import br.com.fpercicotte.Model.Usuario;
import br.com.fpercicotte.service.ManipularUsuario;
import br.com.fpercicotte.util.Util;

import java.util.Scanner;

public class MenuUsuario {

    Scanner teclado = new Scanner(System.in);
    String[] opcoesUsuario = {
            "Escolha uma opção:",
            "[1] - Cadastrar Usuários",
            "[2] - Listar Usuários",
            "[3] - Deletar Usuário",
            "[V] - Voltar Menu Principal\n"
    };

    public void menuUsuario(){
        boolean flag = true;
        while (flag){

            Util.montarMenu("Menu Usuário",opcoesUsuario);
            String opcao = teclado.nextLine();

            switch (opcao.toUpperCase()) {
                case "1":
                    this.menuCadastrarUsuario();
                    break;
                case "2":
                    this.listarUsuarios();
                    break;
                case "3":
                    System.out.println("Função ainda não implementada.");
                    break;
                case "V":
                    flag = false;
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        }
    }
    public void menuCadastrarUsuario(){
       Usuario novoUsuario;
        ManipularUsuario manipular = new ManipularUsuario();
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

        manipular.listarUsurarios();
        System.out.println("---------------------------------");
    }

}
