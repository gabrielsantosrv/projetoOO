import java.util.ArrayList;

public abstract class Pessoa {
    private String nome;
    private String endereco;
    private String telefone;
    private String dataNascimento;
    private String rg;
    private boolean ativo;
    private ArrayList<Turma> turmas;

    public Pessoa(String rg, String nome, String endereco, String telefone, String dataNascimento, boolean ativo) {
        this.setRG(rg);
        this.setNome(nome);
        this.setEndereco(endereco);
        this.setTelefone(telefone);
        this.setDataNascimento(dataNascimento);
        this.setAtivo(ativo);
        this.turmas = new ArrayList<>();
    }

    public Pessoa() {
        this.rg = "";
        this.nome = "";
        this.endereco = "";
        this.telefone = "";
        this.dataNascimento = "";
        this.ativo = true;
        this.turmas = new ArrayList<>();
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
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
        ret += "\n RG: ";
        ret += this.rg;
        ret += "\n Data de nascimento: ";
        ret += this.dataNascimento;
        ret += "\n Endereco: ";
        ret += this.endereco;
        ret += "\n Telefone: ";
        ret += this.telefone;
        return ret;
    }

    public boolean equals(Cliente c) {
        return this.getRg().equalsIgnoreCase(c.getRg());
    }
}
