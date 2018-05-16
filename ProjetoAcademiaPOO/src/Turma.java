import java.util.ArrayList;

public class Turma {
    private ArrayList<Cliente> clientes;
    private ArrayList<Instrutor> instrutores;
    private String horario;
    private float precoAtividade;
    private final int MAXIMO_PESSOAS;
    private final String chave;

    public Turma(String horario, float precoAtividade, int maximoPessoas, String chave) {
        this.clientes = new ArrayList<>();
        this.instrutores = new ArrayList<>();
        this.MAXIMO_PESSOAS = maximoPessoas;
        this.horario = horario;
        this.precoAtividade = precoAtividade;
        this.chave = chave;
    }

    public String getChave() {
        return chave;
    }

    public ArrayList<Cliente> getClientes() {
        return this.clientes;
    }

    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void removerCliente(Cliente cliente) {
        this.clientes.remove(cliente);
    }

    public ArrayList<Instrutor> getInstrutores() {
        return this.instrutores;
    }

    public void adicionarInstrutor(Instrutor instrutor) {
        this.instrutores.add(instrutor);
    }

    public void removerInstrutor(Instrutor instrutor) {
        this.instrutores.remove(instrutor);
    }

    public String getHorario() {
        return this.horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public float getPrecoAtividade() {
        return this.precoAtividade;
    }

    public void setPrecoAtividade(float precoAtividade) {
        this.precoAtividade = precoAtividade;
    }

    public int vagas() {
        return this.MAXIMO_PESSOAS - this.clientes.size();
    }

    public int quantasPessoas() {
        return this.clientes.size();
    }

    public int getMaximoPessoas() {
        return this.MAXIMO_PESSOAS;
    }

    public String toString() {
        return "Horário: " + this.horario + "\nVagas: " + this.vagas();
    }
}
