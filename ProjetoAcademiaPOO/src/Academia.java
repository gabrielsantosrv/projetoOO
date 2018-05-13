import java.util.ArrayList;

// just a test

public class Academia {
    private static ArrayList<Cliente> clientes;
    private static ArrayList<Instrutor> instrutores;
    private static ArrayList<Atividade> atividades;
        int inscritos = 0;
        Atividade comMaisInscritos = new Atividade("", 0, null);
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
        return new Atividade("", 0, null);
    }

    public static Atividade atividadeComMaiorPreco() {
        //TODO
        return new Atividade("", 0, null);
    }

    public static Atividade atividadeComMenorPreco() {
        //TODO
        return new Atividade("", 0, null);
    }

    public static void exibirAtividades() {
        //TODO
    }

    public static void exibirClientes() {
        //TODO
    }

    public static void exibirInstrutores() {
        //TODO
    }

    public static void exibirTurmasPorAtividade() {
        //TODO
    }
}
