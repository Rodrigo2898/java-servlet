package br.com.rodrigofeitosa.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity(name = "contatos")
@Table(name = "contatos")
public class Pessoa  {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCon;
    private String nome;

    private String idade;
    private String profissao;

    public Pessoa() {
    }

    public Pessoa(String nome, String idade, String profissao) {
        this.nome = nome;
        this.idade = idade;
        this.profissao = profissao;
    }

    public Integer getId() {
        return idCon;
    }

    public void setIdcon(Integer id) {
        this.idCon = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
}
