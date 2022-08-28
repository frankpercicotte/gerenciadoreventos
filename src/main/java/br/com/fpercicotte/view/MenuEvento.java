package br.com.fpercicotte.view;

import br.com.fpercicotte.Model.Categoria;
import br.com.fpercicotte.Model.Evento;
import br.com.fpercicotte.service.ManipularEvento;
import br.com.fpercicotte.util.ManipularData;
import br.com.fpercicotte.util.Menu;

import java.time.LocalDateTime;
import java.util.Scanner;

public class MenuEvento {

    Scanner teclado = new Scanner(System.in);
    String[] opcoesEvento = {
            "Escolha uma opção:",
            "[1] - Cadastrar Eventos",
            "[2] - Listar Eventos Abertos",
            "[3] - Listar Eventos Inscritos",
            "[4] - Listar Eventos Realizados",
            "[5] - Inscrever-se em Evento",
            "[6] - Cancelar Inscrição em Evento",
            "[7] - Deletar Evento",
            "[V] - Voltar Menu Principal\n"
    };

    public void menuEvento(){
        boolean flag = true;
        while (flag){

            Menu.montarMenu("Menu Evento", opcoesEvento);
            String opcao = teclado.nextLine();

            switch (opcao.toUpperCase()) {
                case "1":
                    this.menuCadastrarEvento();
                    break;
                case "2":
                    this.menuEventosAbertos();
                    break;
                case "3":
                    this.menuEventosInscrito();
                    break;
                case "4":
                    this.menuEventosRealizados();
                    break;
                case "5":
                case "6":
                    System.out.println("Ainda não implentado");
                    break;
                case "7":
                    this.menuDeletarEvento();
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
        System.out.print("Data (dd/mm/yyyy): ");
        String data = teclado.nextLine();

        System.out.print("Hora (hh:mm [h: 0-23 / mm: 0:59]): ");
        String hora = teclado.nextLine();

        System.out.print("Nome: ");
        String nome = teclado.nextLine();

        System.out.print("Endereço: ");
        String endereco = teclado.nextLine();

        StringBuilder categorias = new StringBuilder();
        for(Categoria c : Categoria.values()) {
            categorias.append(c.toString()).append(" ");
        }
        System.out.print("Categoria: [" + categorias + "] ");
        String categoria = teclado.nextLine();

        System.out.print("Descricao: ");
        String descricao = teclado.nextLine();

        LocalDateTime dataHorario = ManipularData.stringParaData(data, hora);
        if (dataHorario == null){
            System.out.println("Erro na formatação da data");
            System.out.println("Digitado: " + data + " " + hora );
            System.out.println("Exemplo de formato correto: 22/08/2022 18:30:00" );
            return;
        }

        novoEvento = new Evento(dataHorario,nome,endereco,categoria,descricao);

        System.out.println("---------------------------------");
        System.out.println(manipular.salvarEvento(novoEvento).toString());
        System.out.println("---------------------------------");
    }

    public void menuEventosAbertos(){
        ManipularEvento manipular = new ManipularEvento();
        System.out.println("---------------------------------");
        System.out.println("Listar Eventos");

        manipular.listarEventosAbertos();
        System.out.println("---------------------------------");
     }

    public void menuEventosRealizados(){
        ManipularEvento manipular = new ManipularEvento();
        System.out.println("---------------------------------");
        System.out.println("Listar Eventos já realizados");

        manipular.listarEventosRealizados();
        System.out.println("---------------------------------");
    }

    public void menuEventosInscrito(){
        ManipularEvento manipular = new ManipularEvento();
        System.out.println("---------------------------------");
        System.out.println("Listar Eventos Inscrito");

        manipular.listarInscritos();
        System.out.println("---------------------------------");
    }
    public void menuDeletarEvento(){
        ManipularEvento manipular = new ManipularEvento();
        manipular.listarEventosAbertos();
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
