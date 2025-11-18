public class Estante {
    private int id;
    private String nome;

    public Estante() {}

    public Estante(String nome) {
        this.nome = nome;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    @Override
    public String toString() {
        return "Estante [id=" + id + ", nome=" + nome + "]";
    }
}
