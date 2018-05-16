import java.util.ArrayList;

public class Atividade{
    private String nome;
    private float preco;
    private ArrayList<Turma> turmas;

    public Atividade(String nome, float preco) {
        this.setNome(nome);
        this.setPreco(preco);
        this.turmas = new ArrayList<>();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        if (!nome.equals(""))
            this.nome = nome;
    }

    public float getPreco() {
        return this.preco;
    }

    public void setPreco(float preco) {
        if (preco > 0)
            this.preco = preco;
    }

    public ArrayList<Turma> getTurmas() {
        return this.turmas;
    }

    public void adicionarTurma(Turma turma) {
        this.turmas.add(turma);
    }

    public void removerTurma(Turma turma) {
        this.turmas.remove(turma);
    }

    public int quantidadeTurmas() {
        return this.turmas.size();
    }

    public int vagasLivres() {
        int vagas = 0;
        for (Turma t : this.turmas) {
            vagas += t.vagas();
        }
        return vagas;
    }

    public String horariosComVaga() {
        StringBuilder horarios = new StringBuilder();
        for (Turma t : this.turmas) {
            if (t.vagas() > 0)
                horarios.append(t.getHorario()+" ");
        }
        return horarios.toString();
    }

    public String todosOsHorarios() {
        StringBuilder horarios = new StringBuilder();
        for (Turma t : this.turmas) {
            horarios.append(t.getHorario()+" ");
        }
        return horarios.toString();
    }

    public int quantosInscritos() {
        int inscritos = 0;
        for (Turma t : this.turmas) {
            inscritos += t.quantasPessoas();
        }
        return inscritos;
    }

    public String toString() {
        return "Nome: " + this.nome + "\nPreco: " + this.preco;
    }

    public boolean equals(Atividade atividade) {
        return atividade.nome.equalsIgnoreCase(nome);
    }
}
