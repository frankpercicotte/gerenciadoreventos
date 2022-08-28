package br.com.fpercicotte.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 Código adaptado de terceiro.
 fonte:https://receitasdecodigo.com.br/java/validar-email-em-java
 data consulta: 27/08/2022

 */

public class ValidaEmail {
    public static boolean isEmail(String email) {
        String exp = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern p = Pattern.compile(exp, Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(email);
        return matcher.matches() == true ? true : false;
    }

}
