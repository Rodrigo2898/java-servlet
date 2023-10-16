package br.com.rodrigofeitosa.model;

public class JavaBeans {
    private Integer idcon;
    private String nome;
    private String idade;
    private String profissao;

    public JavaBeans() {
        super();
    }

    public JavaBeans(Integer idcon, String nome, String idade, String profissao) {
        super();
        this.idcon = idcon;
        this.nome = nome;
        this.idade = idade;
        this.profissao = profissao;
    }

    public Integer getIdcon() {
        return this.idcon;
    }

    public void setIdcon(Integer idcon) {
        this.idcon = idcon;
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
