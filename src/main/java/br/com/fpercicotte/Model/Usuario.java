package br.com.fpercicotte.Model;

import br.com.fpercicotte.util.ValidaCPF;

import java.util.List;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String cpf;

    private List<Evento> eventoList;


    public Usuario(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }
    public int getId() {
        return id;
    }

    public void setId(int index) {
        this.id = index;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Evento> getEventoList() { return eventoList;}

    public void setEventoList(List<Evento> eventoList) {
        this.eventoList = eventoList;
    }

    @Override
    public String toString() {
        return "Usuario {" +
                "id: " + id +
                ", nome: " + nome +
                ", email: " + email +
                ", cpf" +
                ": " + ValidaCPF.imprimeCPF(cpf) +
                '}';
    }
}
