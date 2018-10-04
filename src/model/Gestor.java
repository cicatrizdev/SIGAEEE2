package model;

public class Gestor extends Usuario {
    private Integer idGestor;


    public Gestor(Integer idUsuario, String nome, String email, String senha, Integer idGestor){
        super(idUsuario, nome, email, senha);
        this.idGestor = idGestor;
    }

    public Integer getIdGestor() {
        return idGestor;
    }

    public void setId(Integer idGestor) {
        this.idGestor = idGestor;
    }
}
