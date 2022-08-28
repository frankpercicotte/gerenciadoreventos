package br.com.fpercicotte.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {

    public static void montarMenu(String titulo, String[] opcoesMenu ){
        System.out.println("---------------------------------");
        System.out.println("******   " + titulo + "    ******");
        System.out.println("---------------------------------");
        for (String opcao : opcoesMenu) {
            System.out.println(opcao);
        }
        System.out.print("Opção: ");
    }

    public static LocalDateTime stringParaData(String data, String hora){
        String padrao = "dd/MM/uuuu HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(padrao);
        LocalDateTime converterData = null;
        try {
            converterData = LocalDateTime.parse(data + " " + hora, formatter);
            LocalDateTime agora = converterData;
            String agoraFormatado = agora.format(formatter);
        } catch( Exception e){
            System.out.println("[Erro]: " + e.getMessage());
        }
        return converterData;
    }

    public static String dataParaString(LocalDateTime data){
        String padrao = "dd/MM/uuuu HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(padrao);
        String converterData = null;
        try {
            converterData = data.format(formatter);
        } catch( Exception e){
            System.out.println("[Erro]: " + e.getMessage());
        }
        return converterData;
    }



}
