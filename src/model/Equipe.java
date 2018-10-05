package model;

public class Equipe extends Esporte {
    private Integer idEquipe;
    private String nomeEquipe;

    public Equipe(Integer idEsporte, String nomeEsporte, Integer idEquipe, String nomeEquipe) {
        super(idEsporte, nomeEsporte);
        this.idEquipe = idEquipe;
        this.nomeEquipe = nomeEquipe;
    }

    public Integer getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(Integer idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getNomeEquipe() {
        return nomeEquipe;
    }

    public void setNomeEquipe(String nomeEquipe) {
        this.nomeEquipe = nomeEquipe;
    }
}
