package model;

public class Gestor extends Usuario {
    private Integer id;

    public Gestor(Integer idUsuario, String nome, String email, String senha, Integer id){
        super(idUsuario, nome, email, senha);
        this.id = id;
    }

    public Gestor(String nome, String email, String senha){
        super(nome, email, senha);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
