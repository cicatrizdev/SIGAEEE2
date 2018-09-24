package model;

public class Posicao {
    private Long id_posicao;
    private String nome;

    public Posicao(long id_posicao, String nome) {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId_posicao() {
        return id_posicao;
    }

    public void setId_posicao(Long id_posicao) {
        this.id_posicao = id_posicao;
    }
}
