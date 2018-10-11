package model;

import dao.AtletaDAO;

import java.sql.SQLException;
import java.util.List;

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

    public void inserir() throws SQLException, ClassNotFoundException {
        AtletaDAO.inserir(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        AtletaDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        AtletaDAO.excluir(this);
    }

    public static Atleta lerAtleta(int idAtleta) throws SQLException, ClassNotFoundException {
        return AtletaDAO.lerAtleta(idAtleta);
    }

    public static List<Atleta> lerTodosAtletas() throws ClassNotFoundException, SQLException {
        return AtletaDAO.lerTodosAtletas();
    }
}