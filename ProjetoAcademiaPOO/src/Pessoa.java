import java.util.ArrayList;

public class Pessoa {
    private String nome;
    private String endereco;
    private String telefone;
    private String dataNascimento;
    private boolean ativo;
    private ArrayList<Turma> turmas;

    public Pessoa(String nome, String endereco, String telefone, String dataNascimento, boolean ativo) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.ativo = ativo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public void ativar() {
        this.ativo = true;
    }

    public void desativar() {
        this.ativo = false;
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

    public ArrayList<Turma> getTurmas() {
        return this.turmas;
    }
}
