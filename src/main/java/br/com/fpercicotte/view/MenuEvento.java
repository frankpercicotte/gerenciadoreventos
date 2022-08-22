package br.com.fpercicotte.view;

import br.com.fpercicotte.Model.Categoria;
import br.com.fpercicotte.Model.Evento;
import br.com.fpercicotte.service.ManipularEvento;
import br.com.fpercicotte.util.Util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MenuEvento {

    Scanner teclado = new Scanner(System.in);
    String[] opcoesEvento = {
            "Escolha uma opção:",
            "[1] - Cadastrar Eventos",
            "[2] - Listar Todos Eventos",
            "[3] - Deletar Evento",
            "[4] - Listar Eventos Abertos",
            "[5] - Listar Eventos Inscritos",
            "[6] - Listar Eventos Próximos",
            "[V] - Voltar Menu Principal\n"
    };

    public void menuEvento(){
        boolean flag = true;
        while (flag){

            Util.montarMenu("Menu Evento", opcoesEvento);
            String opcao = teclado.nextLine();

            switch (opcao.toUpperCase()) {
                case "1":
                    this.menuCadastrarEvento();
                    break;
                case "2":
                    this.listarEventos();
                    break;
                case "3":
                    this.deletarEvento();
                    break;
                case "4":
                case "5":
                case "6":
                    System.out.println("Ainda não implentado");
                    break;
                case "V":
                    flag = false;
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        }
    }

    public void menuCadastrarEvento(){
        Evento novoEvento;
        ManipularEvento manipular = new ManipularEvento();

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
        System.out.println(manipular.salvarEvento(novoEvento).toString());
        System.out.println("---------------------------------");
    }

    public void listarEventos(){
        ManipularEvento manipular = new ManipularEvento();
        System.out.println("---------------------------------");
        System.out.println("Listar Eventos");

        manipular.listarEventos();
        System.out.println("---------------------------------");
     }

    public void deletarEvento(){
        ManipularEvento manipular = new ManipularEvento();
        manipular.listarEventos();
        System.out.println("Selecione o ID do evento que deseja deltar:");
        String id = teclado.nextLine();

        boolean res = manipular.deletarEvento(Integer.parseInt(id));
        if (res) {
            System.out.println(" *** [OK] Evento deletado! ***\n");
        } else {
            System.out.println(" *** [ERRO] - Evento não localizado! ***\n");
        }


    }

}
