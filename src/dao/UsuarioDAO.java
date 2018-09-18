public class UsuarioDAO{

    public static void inserir(Usuario usuario) throws SQLException, classNotFoundExceptio {
        Connection conexao = null;
        PreparedStatemet comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO usuario (id , nome, email, senha, tipoUsario) VALUES (?,?,?,?,?)";
            comando = conexao.prepareStatemant(sql);
            comando.setLong(1, usuario.getId());
            comando.setString(2, usuario.getNome());
            comando.setString(3, usuario.getEmail());
            comando.setString(4, usuario.getSenha());
            comando.setString(5, usuariogetTipoUsuario());

            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e) {
            throw e;
        }
    }
    }

    public static void alterar(Usuario usuario) throws SQLException, classNotFoundException{
            Connection conexao = null;
            PreparedStatement comando = null;
            try {
                conexao = BD.getConexao();
                String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ?, tipoUsuario = ? WHERE id = ?"
                comando = conexao.prepareStatemant(sql);
                comando.setString(1, usuario.getNome());
                comando.setString(2, usuario.getEmail());
                comando.setString(3, usuario.getSenha());
                comando.setString(4, usuario.getTipoUsuario());
                comando.setLong (5, usuario.getId());
                comando.execute();
                BD.fecharConexao(conexao, comando);
            }catch (SQLException e){
                throw e;
            }
    }