package model;

public class TipoEvento {
    private Integer idTipoEvento;
    private String nomeTipoEvento;

    public TipoEvento(Integer idTipoEvento, String nomeTipoEvento) {
        this.idTipoEvento = idTipoEvento;
        this.nomeTipoEvento = nomeTipoEvento;
    }

    public Integer getIdTipoEvento() {
        return idTipoEvento;
    }

    public void setIdTipoEvento(Integer idTipoEvento) {
        this.idTipoEvento = idTipoEvento;
    }

    public String getNomeTipoEvento() {
        return nomeTipoEvento;
    }

    public void setNomeTipoEvento(String nomeTipoEvento) {
        this.nomeTipoEvento = nomeTipoEvento;
    }
}
