package model;

import java.util.Date;

public class Atleta extends Usuario{

    private Integer id;
    private Float peso;
    private Float altura;
    private String dataNascimento;

    public Atleta(Integer idUsuario, String nome, String email, String senha, Integer id, Float peso, Float altura, String dataNascimento) {
        super(idUsuario, nome, email, senha);
        this.id = id;
        this.peso = peso;
        this.altura = altura;
        this.dataNascimento = dataNascimento;
    }

    public Atleta(String nome, String email, String senha, Float peso, Float altura, String dataNascimento) {
        super(nome, email, senha);
        this.peso = peso;
        this.altura = altura;
        this.dataNascimento = dataNascimento;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
