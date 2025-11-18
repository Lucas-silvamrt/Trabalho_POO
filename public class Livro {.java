public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private Estante estante;

    public Livro() {}

    public Livro(String titulo, String autor, Estante estante) {
        this.titulo = titulo;
        this.autor = autor;
        this.estante = estante;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public Estante getEstante() { return estante; }
    public void setEstante(Estante estante) { this.estante = estante; }

    @Override
    public String toString() {
        return "Livro [id=" + id + ", titulo=" + titulo + ", autor=" + autor +
               ", estante=" + (estante != null ? estante.getNome() : "Nenhuma") + "]";
    }
}
