package model;

public class Atleta extends Usuario {

    private Integer idAtleta;
    private Float peso;
    private Float altura;
    private String dataNascimento;

    public Atleta(Integer idUsuario, String nomeUsuario, String email, String senha, Float peso, Float altura, String dataNascimento) {
        super(idUsuario, nomeUsuario, email, senha);
        this.peso = peso;
        this.altura = altura;
        this.dataNascimento = dataNascimento;
    }

    public Integer getIdAtleta() {
        return idAtleta;
    }

    public void setIdAtleta(Integer idAtleta) {
        this.idAtleta = idAtleta;
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