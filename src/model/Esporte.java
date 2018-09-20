package model;

public class Esporte {
    private Long id_esporte;
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId_esporte() {
        return id_esporte;
    }

    public void setId_esporte(Long id_esporte) {
        this.id_esporte = id_esporte;
    }
}
