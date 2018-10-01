package model;

import java.util.Date;

public class Evento {
    private Integer id_evento;
    private String nome;
    private String descricao;
    private Date data;
    private String logradouro;
    //private String numeroLogradouro;
    //private String cidade;
    //private String estado;
    //private String cep;

    public Evento(Integer id_evento, String nome, String descricao, java.sql.Date data, String logradouro) {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLogradouro() {
        return logradouro;
    }  //fazer esta caralha toda

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /* public String getNumeroLogradouro() {
        return numeroLogradouro;
    }

    public void setNumeroLogradouro(String numeroLogradouro) {
        this.numeroLogradouro = numeroLogradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    */
    public Integer getId_evento() {
        return id_evento;
    }

    public void setId_evento(Integer id_evento) {
        this.id_evento = id_evento;
    }
}
