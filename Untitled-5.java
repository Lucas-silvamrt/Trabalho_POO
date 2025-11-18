import java.sql.*;
import java.util.*;

public class EstanteDAO {

    public void inserir(Estante e) {
        String sql = "INSERT INTO estante (nome) VALUES (?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, e.getNome());
            stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Estante> listar() {
        List<Estante> lista = new ArrayList<>();
        String sql = "SELECT * FROM estante";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Estante e = new Estante();
                e.setId(rs.getInt("id"));
                e.setNome(rs.getString("nome"));
                lista.add(e);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
