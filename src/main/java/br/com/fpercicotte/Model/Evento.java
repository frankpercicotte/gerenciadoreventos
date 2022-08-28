package br.com.fpercicotte.Model;

import br.com.fpercicotte.util.ManipularData;

import java.time.LocalDateTime;

public class Evento {
    private int id;
    private LocalDateTime data;
    private String nome;
    private String endereco;
    private String categoria;
    private String descricao;
    private String[] inscritos;

    public Evento(LocalDateTime data, String nome, String endereco, String categoria, String descricao) {
        this.data = data;
        this.nome = nome;
        this.endereco = endereco;
        this.categoria = categoria;
        this.descricao = descricao;
    }

    public int getId() { return this.id; }

    public void setId(int id) {this.id = id; }
    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String[] getInscritos() {
        return inscritos;
    }

    public void setInscritos(String[] inscritos) {
        this.inscritos = inscritos;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id: " + id +
                ", data: " + ManipularData.dataParaString(data) +
                ", nome: " + nome  +
                ", endereco: " + endereco  +
                ", categoria: " + categoria  +
                ", descricao: " + descricao +
                "] }";
    }
}
