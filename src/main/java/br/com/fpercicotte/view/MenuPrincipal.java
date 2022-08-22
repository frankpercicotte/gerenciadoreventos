package br.com.fpercicotte.view;

import br.com.fpercicotte.Model.Categoria;
import br.com.fpercicotte.Model.Evento;
import br.com.fpercicotte.Model.Usuario;
import br.com.fpercicotte.util.Util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class MenuPrincipal {

    String[] opcoesMenu = {
            "Escolha uma opção:",
            "[1] - Menu Usuários",
            "[2] - Menu Eventos",
            "[S] - Sair\n"
    };

    Scanner teclado = new Scanner(System.in);
    MenuUsuario menuUsuario = new MenuUsuario();
    MenuEvento menuEvento = new MenuEvento();

     public void menuPrincipal(){

         boolean flag = true;

         while (flag){
             Util.montarMenu("Menu Principal", opcoesMenu);
             System.out.print("Opção: ");
             String opcao = teclado.nextLine();

             switch (opcao.toUpperCase()) {
                 case "1":
                     menuUsuario.menuUsuario();
                     break;
                 case "2":
                     menuEvento.menuEvento();
                     break;
                 case "S":
                     flag = false;
                     break;
                 default:
                     System.out.println("Opção Inválida!");
             }
         }
         teclado.close();

    }

    public void voltarMenuPrincipal(){
        System.out.println("[ENTER] para voltar.");
        teclado.nextLine();
    }


}
