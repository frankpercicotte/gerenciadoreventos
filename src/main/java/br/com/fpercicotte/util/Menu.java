package br.com.fpercicotte.util;

public class Menu {

    public static void montarMenu(String titulo, String[] opcoesMenu ){
        System.out.println("---------------------------------");
        System.out.println("******   " + titulo + "    ******");
        System.out.println("---------------------------------");
        for (String opcao : opcoesMenu) {
            System.out.println(opcao);
        }
        System.out.print("Opção: ");
    }

}
