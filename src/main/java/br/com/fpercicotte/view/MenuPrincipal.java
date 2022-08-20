package br.com.fpercicotte.view;

import br.com.fpercicotte.Model.Categoria;
import br.com.fpercicotte.Model.Evento;
import br.com.fpercicotte.Model.Usuario;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class MenuPrincipal {

    String[] opcaosPrincipal = {
            "Escolha uma opção:",
            "[1] - Cadastrar Usuário",
            "[2] - Cadastrar Evento",
            "[3] - Listar Evento Abertos",
            "[4] - Listar Evento Inscritos",
            "[5] - Listar Evento Próximos",
            "[9] - Sair\n"
    };

    Scanner teclado = new Scanner(System.in);

     public void menuPrincipal(){

         boolean flag = true;

         while (flag){
             this.montaMenu();
             System.out.print("Opção: ");
             String opcao = teclado.nextLine();

             switch (opcao) {
                 case "1":
                     this.menuCadastrarUsuario();
                     break;
                 case "2":
                     this.menuCadastrarEvento();
                     break;
                 case "3":
                     // System.out.println("Função ainda não implementada.");
                 case "4":
                     // System.out.println("Função ainda não implementada.");
                 case "5":
                     System.out.println("Função ainda não implementada.");
                     break;
                 case "9":
                     flag = false;
                     break;
                 default:
                     System.out.println("Opção Inválida!");
             }
         }
         teclado.close();

    }
    private void montaMenu(){
        for (String opcao : opcaosPrincipal) {
            System.out.println(opcao);
        }
    }

    public void voltarMenuPrincipal(){
        System.out.println("[ENTER] para voltar.");
        teclado.nextLine();
    }
    public void menuCadastrarUsuario(){
        Usuario novoUs;
        System.out.println("---------------------------------");
        System.out.println("Cadastro de Usuário");
        System.out.println("---------------------------------");

        System.out.print("Nome: ");
        String nome = teclado.nextLine();
        System.out.print("Email: ");
        String email = teclado.nextLine();
        System.out.print("cpf: ");
        String cpf = teclado.nextLine();
        novoUs = new Usuario(nome,email,cpf);

        System.out.println("---------------------------------");
        System.out.println(novoUs.toString());
        System.out.println("---------------------------------");

        this.voltarMenuPrincipal();
    }

    public void menuCadastrarEvento(){
        Evento novoEvento;
        System.out.println("---------------------------------");
        System.out.println("Cadastro de Evento");
        System.out.println("---------------------------------");
        System.out.print("Data (dd-mm-yy): ");
        String data = teclado.nextLine();

        System.out.print("Horário (hh:mm [h: 0-23 / mm: 0:59]): ");
        String horario = teclado.nextLine();

        System.out.print("Nome: ");
        String nome = teclado.nextLine();;

        System.out.print("Endereço: ");
        String endereco = teclado.nextLine();

        String categorias = "";
        for(Categoria c : Categoria.values()) {
            categorias += c.toString() + " ";
        }
        System.out.print("Categoria: [" + categorias + "] ");
        String categoria = teclado.nextLine();

        System.out.print("Descricao: ");
        String descricao = teclado.nextLine();

        LocalDateTime dataHorario = LocalDateTime.now();
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yy 'as' HH:mm");

        novoEvento = new Evento(dataHorario.format(formatoData).toString(),nome,endereco,categoria,descricao);

        System.out.println("---------------------------------");
        System.out.println(novoEvento.toString());
        System.out.println("---------------------------------");

        this.voltarMenuPrincipal();
    }
}
