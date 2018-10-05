package model;

public class Gestor extends Usuario {
    private Integer idGestor;


    public Gestor(Integer idUsuario, String nomeUsuario, String email, String senha, Integer idGestor){
        super(idUsuario, nomeUsuario, email, senha);
        this.idGestor = idGestor;
    }

    public Integer getIdGestor() {
        return idGestor;
    }

    public void setId(Integer idGestor) {
        this.idGestor = idGestor;
    }
}
