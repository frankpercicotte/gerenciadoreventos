package br.com.fpercicotte.view;

import br.com.fpercicotte.Model.Usuario;
import br.com.fpercicotte.service.ManipularUsuario;
import br.com.fpercicotte.util.Menu;
import br.com.fpercicotte.util.ValidaCPF;
import br.com.fpercicotte.util.ValidaEmail;

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

            Menu.montarMenu("Menu Usuário",opcoesUsuario);
            String opcao = teclado.nextLine();

            switch (opcao.toUpperCase()) {
                case "1":
                    this.menuCadastrarUsuario();
                    break;
                case "2":
                    this.listarUsuarios();
                    break;
                case "3":
                    deletarUsuario();
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
        //Tirar pontuação caso tenha sido digitado.
        cpf = cpf.replaceAll("\\p{Punct}", "");

        if (ValidaEmail.isEmail(email) & ValidaCPF.isCPF(cpf)) {
            novoUsuario = new Usuario(nome, email, cpf);
            System.out.println("---------------------------------");
            System.out.println(manipular.salvarUsuario(novoUsuario).toString());
            System.out.println("---------------------------------");
        } else{
            System.out.println("[Erro] Cadastrar usuário, email ou cpf está inválido!");
            System.out.println();
        }
    }

    public void listarUsuarios(){
        ManipularUsuario manipular = new ManipularUsuario();
        System.out.println("---------------------------------");
        System.out.println("Listar Usuários");

        manipular.listarUsurarios();
        System.out.println("---------------------------------");
    }

    public void deletarUsuario() {
        ManipularUsuario manipular = new ManipularUsuario();
        manipular.listarUsurarios();
        System.out.println("Selecione o ID do usúario que deseja deltar:");
        String id = teclado.nextLine();
        boolean res = manipular.deletarUsuario(Integer.parseInt(id));

        if (res) {
            System.out.println(" *** [OK] Usuário deletado! ***\n");
        } else {
            System.out.println(" *** [ERRO] - Usuário não localizado! ***\n");
        }
    }
}
