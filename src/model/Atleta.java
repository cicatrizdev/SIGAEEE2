package model;

import java.util.Date;

public class Atleta extends Usuario{

    private Integer id_atleta;
    private Float peso;
    private Float altura;
    private Date dataNascimento;

    public Atleta(int id_atleta, float peso, float altura, java.sql.Date dataNascimento) {
        super();
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getId_atleta() {
        return id_atleta;
    }

    public void setId_atleta(Integer id_atleta) {
        this.id_atleta = id_atleta;
    }
}
