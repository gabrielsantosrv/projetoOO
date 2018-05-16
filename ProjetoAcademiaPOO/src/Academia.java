import java.util.ArrayList;

public class Academia {
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Instrutor> instrutores = new ArrayList<>();
    private static ArrayList<Atividade> atividades = new ArrayList<>();

    public void inserirCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void inserirInstrutor(Instrutor instrutor) {
        instrutores.add(instrutor);
    }

    public void inserirAtividade(Atividade atividade) {
        atividades.add(atividade);
    }

    public void inserirTurma(Atividade atividade, Turma turma) {
        atividade.adicionarTurma(turma);
    }

    public ArrayList<Atividade> getAtividades() {
        return atividades;
    }

    public static Atividade atividadeComMaisInscritos() {
        int inscritos = 0;
        Atividade comMaisInscritos = new Atividade("", 0);
        for (Atividade a : atividades) {
            if (a.quantosInscritos() > inscritos) {
                inscritos = a.quantosInscritos();
                comMaisInscritos = a;
            }
        }
        return comMaisInscritos;
    }

    public static Atividade atividadeComMenosInscritos() {
        //TODO
        return new Atividade("", 0);
    }

    public static Atividade atividadeComMaiorPreco() {
        //TODO
        return new Atividade("", 0);
    }

    public static Atividade atividadeComMenorPreco() {
        //TODO
        return new Atividade("", 0);
    }

    public static void exibirAtividades() {
        System.out.println("EXIBIÇÃO DE ATIVIDADES");
        for (Atividade a : atividades) {
            System.out.println(a.toString());
        }
    }

    public static void exibirClientes() {
        System.out.println("EXIBIÇÃO DE CLIENTES");
        for (Cliente c : clientes) {
            System.out.println(c.toString());
        }
    }

    public static void exibirInstrutores() {
        System.out.println("EXIBIÇÃO DE INSTRUTORES");
        for (Instrutor i : instrutores) {
            System.out.println(i.toString());
        }
    }

    public static void exibirTurmasPorAtividade() {
        System.out.println("EXIBIÇÃO DE TURMAS POR ATIVIDADE");
        for (Atividade a : atividades) {
            System.out.println(a.toString());
            System.out.println("Turmas:");
            for (Turma t : a.getTurmas()) {
                System.out.println(t.toString());
            }
        }
    }
}
