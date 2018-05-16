import java.util.ArrayList;

public class Pessoa {
    private String nome;
    private String endereco;
    private String telefone;
    private String dataNascimento;
    private String rg;
    private boolean ativo;
    private ArrayList<Turma> turmas;

    public Pessoa(String rg, String nome, String endereco, String telefone, String dataNascimento, boolean ativo) {
        this.rg = rg;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.ativo = ativo;
        this.turmas = new ArrayList<>();
    }

    public void setRG(String rg) {
        boolean ok = true;

        if (rg.equals("")) {
            ok = false;
        }

        String validos = "0123456789";
        for (int i = 0; i < rg.length(); i++) {
            if (!validos.contains(rg.charAt(i)+"")) {
                ok = false;
                break;
            }
        }

        if (ok) {
            this.rg = rg;
        }
    }

    public String getRg() {
        return this.rg;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        if (!nome.equals(""))
            this.nome = nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        if (!endereco.equals(""))
            this.endereco = endereco;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        boolean ok = true;

        if (telefone.equals("")) {
            ok = false;
        }

        String validos = "0123456789";
        for (int i = 0; i < telefone.length(); i++) {
            if (!validos.contains(telefone.charAt(i)+"")) {
                ok = false;
                break;
            }
        }

        if (ok) {
            this.telefone = telefone;
        }
    }

    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        if (!dataNascimento.equals(""))
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

    public String toString() {
        String ret = "Nome: ";
        ret += this.nome;
        ret += "\nRG: ";
        ret += this.rg;
        ret += "\nData de nascimento: ";
        ret += this.dataNascimento;
        ret += "\nEndereco: ";
        ret += this.endereco;
        ret += "\nTelefone: ";
        ret += this.telefone;
        return ret;
    }
}
