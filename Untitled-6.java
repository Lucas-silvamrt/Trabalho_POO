import java.sql.*;
import java.util.*;

public class LivroDAO {

    public void inserir(Livro l) {
        String sql = "INSERT INTO livro (titulo, autor, id_estante) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, l.getTitulo());
            stmt.setString(2, l.getAutor());
            stmt.setInt(3, l.getEstante() != null ? l.getEstante().getId() : null);

            stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Livro> listar() {
        List<Livro> lista = new ArrayList<>();

        String sql =
            "SELECT l.id, l.titulo, l.autor, e.id AS estante_id, e.nome AS estante_nome " +
            "FROM livro l LEFT JOIN estante e ON l.id_estante = e.id";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Estante e = new Estante();
                e.setId(rs.getInt("estante_id"));
                e.setNome(rs.getString("estante_nome"));

                Livro l = new Livro();
                l.setId(rs.getInt("id"));
                l.setTitulo(rs.getString("titulo"));
                l.setAutor(rs.getString("autor"));
                l.setEstante(e.getId() == 0 ? null : e);

                lista.add(l);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return lista;
    }
}
