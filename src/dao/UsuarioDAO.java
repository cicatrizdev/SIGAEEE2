public class UsuarioDAO{

    public static void inserir(Usuario usuario) throws SQLExeption, classNotFoundExceptio(
            Connection conexao = null;
            PreparedStatemet comando = null;
            try {
                conexao = BD.getConexao();
                String sql = "INSERT INTO usuario (id , nome, email, senha, tipoUsario) VALUES (?,?,?,?,?)";
                comando = conexao.prepareStatemant(sql);
                comando.setInt (parameterIndex 1, )
    }
            )
}