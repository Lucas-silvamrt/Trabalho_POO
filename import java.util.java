import java.util.List;
import java.util.Scanner;

public class BibliotecaMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EstanteDAO estanteDAO = new EstanteDAO();
        LivroDAO livroDAO = new LivroDAO();

        while (true) {
            System.out.println("\n==== SISTEMA DE BIBLIOTECA ====");
            System.out.println("1 - Cadastrar Estante");
            System.out.println("2 - Cadastrar Livro");
            System.out.println("3 - Listar Estantes");
            System.out.println("4 - Listar Livros");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Nome da Estante: ");
                    String nomeEstante = sc.nextLine();
                    estanteDAO.inserir(new Estante(nomeEstante));
                    break;

                case 2:
                    System.out.print("Título do Livro: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor do Livro: ");
                    String autor = sc.nextLine();

                    System.out.println("Escolha a estante (id):");
                    List<Estante> estantes = estanteDAO.listar();
                    estantes.forEach(System.out::println);

                    System.out.print("ID da estante: ");
                    int idEstante = sc.nextInt();

                    Estante estante = estantes.stream()
                        .filter(e -> e.getId() == idEstante)
                        .findFirst()
                        .orElse(null);

                    livroDAO.inserir(new Livro(titulo, autor, estante));
                    break;

                case 3:
                    estanteDAO.listar().forEach(System.out::println);
                    break;

                case 4:
                    livroDAO.listar().forEach(System.out::println);
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
