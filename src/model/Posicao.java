package model;

public class Posicao {
    private Integer id;
    private String nome;

    public Posicao(Integer id, String nome) { }

    public Posicao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
