package model;

public class Atleta extends Usuario {

    private Integer idAtleta;
    private Float peso;
    private Float altura;
    private String dataNascimento;
    private Integer idUsuario;

    public Atleta(Integer idUsuario, String nome, String email, String senha, Integer idAtleta, Float peso, Float altura, String dataNascimento) {
        super(idUsuario, nome, email, senha);
        this.idAtleta = idAtleta;
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

    @Override
    public Integer getIdUsuario() {
        return idUsuario;
    }

    @Override
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}