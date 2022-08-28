package br.com.fpercicotte.service;

import br.com.fpercicotte.Model.Evento;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class ManipularEvento {

    final static List<Evento> arrayEventos = new ArrayList<>();
    int index;
    public Evento salvarEvento(Evento evento){
        index = arrayEventos.size();
        evento.setId(index+1);
        this.arrayEventos.add(evento);
        return arrayEventos.get(index--);
    }

    public boolean deletarEvento(int id){
        Evento evento = null;
        for (Evento evt: arrayEventos) {
            if(evt.getId() == id){
                evento = evt;
            }
        }
        if (evento != null){
            arrayEventos.remove(evento);
            return true;
        }
        return false;
    }

    public int getIndex(){
        return this.index;
    }

    public void listarEventosAbertos(){
        for (Evento evt : arrayEventos) {
            if (LocalDateTime.now().isBefore(evt.getData()))
            System.out.println(evt.toString());
        }
    }
    public void listarEventosRealizados(){
        for (Evento evt : arrayEventos) {
            if (LocalDateTime.now().isAfter(evt.getData()))
                System.out.println(evt.toString());
        }
    }

    public void listarInscritos(){
        System.out.println("Em implementação.");
    }

}
