package model;

public class Posicao extends Esporte{
    private Integer idPosicao;
    private String nomePosicao;

    public Posicao(Integer idEsporte, String nomeEsporte, Integer idPosicao, String nomePosicao) {
        super(idEsporte, nomeEsporte);
        this.idPosicao = idPosicao;
        this.nomePosicao = nomePosicao;
    }

    public Integer getIdPosicao() {
        return idPosicao;
    }

    public void setIdPosicao(Integer idPosicao) {
        this.idPosicao = idPosicao;
    }

    public String getNomePosicao() {
        return nomePosicao;
    }

    public void setNomePosicao(String nomePosicao) {
        this.nomePosicao = nomePosicao;
    }
}
