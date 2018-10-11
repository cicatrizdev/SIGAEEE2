package principal;

import dao.EquipeDAO;
import model.Atleta;
import dao.AtletaDAO;
import model.Equipe;

import java.sql.SQLException;

public class EquipeMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Equipe equipe = new Equipe(12,"Fotebol", 5,"xexela crew");

        EquipeDAO.inserir(equipe);
    }
}
