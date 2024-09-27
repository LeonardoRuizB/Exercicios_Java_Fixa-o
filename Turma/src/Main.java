import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Alunos> alunos = new ArrayList<>();

        boolean continuar = true;
        do {
            String cabecalho =
                    """
                    (1) - Cadastrar aluno e nota
                    (2) - Alterar nome Aluno
                    (3) - Alterar nota Aluno
                    (4) - Excluir aluno
                    (5) - Consultar Alunos e notas
                    (6) - Calcular média
                    (7) - Sair
                    """;

            System.out.println(cabecalho);
            System.out.print("Digite a opção desejada: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            String nome;
            switch (opcao) {
                case 1:
                    System.out.print("\nDigite o Nome do Aluno(a): ");
                    nome = sc.nextLine();

                    System.out.print("Digite a Nota do Aluno(a): ");
                    Double nota = sc.nextDouble();

                    cadastrarAlunoNota(alunos, nome, nota);
                    break;
                case 2:
                    System.out.print("\nDigite o Nome do Aluno(a) que deseja alterar o nome: ");
                    nome = sc.nextLine();

                    System.out.print("\nDigite o novo Nome do Aluno(a): ");
                    String novoNome = sc.nextLine();

                    alterarNomeAluno(alunos, nome, novoNome);
                    break;
                case 3:
                    System.out.print("\nDigite o Nome do Aluno(a) que deseja alterar a nota: ");
                    nome = sc.nextLine();

                    System.out.print("Digite a nova nota do aluno: ");
                    Double novaNova = sc.nextDouble();
                    sc.nextLine();

                    alterarNotaAluno(alunos, novaNova, nome);
                    break;
                case 4:
                    System.out.print("\nDigite o nome do Aluno(a) que você deseja excluir: ");
                    nome = sc.nextLine();

                    excluirAluno(alunos, nome);
                    break;
                case 5:
                    consultarNotasAlunos(alunos);
                    System.out.println();
                    break;
                case 6:
                    calcularMedia(alunos);
                    break;
                default:
                    continuar = false;
                    break;
            }
        } while (continuar);

        sc.close();
    }

    public static void cadastrarAlunoNota(List<Alunos> aluno, String nome, Double nota) {
        aluno.add(new Alunos(nome, nota));
        System.out.println("Aluno cadastrado com sucesso!\n");
    }

    public static void alterarNomeAluno(List<Alunos> aluno, String nome, String novoNome) {
        if (aluno.isEmpty()) {
            System.out.println("Nenhum Aluno(a) cadastrado!");
        } else {
            for (Alunos alunos : aluno) {
                if (alunos.getNome().toLowerCase().contains(nome.toLowerCase())) {
                    alunos.setNome(novoNome);
                }
            }
            System.out.println("Nome alterado com sucesso!\n");
        }
    }

    public static void alterarNotaAluno(List<Alunos> aluno, Double novaNota, String nome) {
        for (Alunos alunos : aluno) {
            if (alunos.getNome().toLowerCase().contains(nome.toLowerCase())) {
                alunos.setNota(novaNota);
            }
        }
        System.out.println("Nota alterada com sucesso!\n");
    }

    public static void excluirAluno(List<Alunos> alunos, String nome) {
        for (Alunos aluno : alunos) {
            if (aluno.getNome().toLowerCase().contains(nome.toLowerCase())) {
                alunos.remove(aluno);
            }
        }
        System.out.println("Aluno(a) excluido com sucesso!\n");
    }

    public static void consultarNotasAlunos(List<Alunos> alunos) {
        System.out.println("Alunos Cadastrados:");
        for (Alunos aluno : alunos) {
            System.out.println(aluno.getNome() + ", " + aluno.getNota());
        }
    }

    public static void calcularMedia(List<Alunos> alunos) {
        double soma = 0;
        for (Alunos aluno : alunos) {
            soma += aluno.getNota();
        }

        double media = soma / alunos.size();

        System.out.println("A média de notas é: " + media + "\n");
    }
}