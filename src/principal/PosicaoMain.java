package principal;

import dao.PosicaoDAO;
import model.Atleta;
import dao.AtletaDAO;
import model.Posicao;

import java.sql.SQLException;

public class PosicaoMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       Posicao posicao = new Posicao(2,"Fotebol", 3, "Zaguerao");

        PosicaoDAO.inserir(posicao);
    }
}

