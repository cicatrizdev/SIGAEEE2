package model;

public class TipoEvento {
    private Long id_tipo_evento;
    private String nome;

    public TipoEvento(long id_tipo_evento, String nome) {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId_tipo_evento() {
        return id_tipo_evento;
    }

    public void setId_tipo_evento(Long id_tipo_evento) {
        this.id_tipo_evento = id_tipo_evento;
    }
}
