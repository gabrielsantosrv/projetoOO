import java.util.ArrayList;

public class Turma {
    private ArrayList<Cliente> clientes;
    private ArrayList<Instrutor> instrutores;
    private String horario;
    private float precoAtividade;
    private int maximoPessoas;
    private String id;

    public Turma(String horario, float precoAtividade, int maximoPessoas, String id) {
        this.clientes = new ArrayList<>();
        this.instrutores = new ArrayList<>();
        this.setMaximoPessoas(maximoPessoas);
        this.setHorario(horario);
        this.setPrecoAtividade(precoAtividade);
        this.setId(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (!id.equals(""))
            this.id = id;
    }

    public void setMaximoPessoas(int maximoPessoas) {
        if (maximoPessoas > 0)
            this.maximoPessoas = maximoPessoas;
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
        if (!horario.equals(""))
            this.horario = horario;
    }

    public float getPrecoAtividade() {
        return this.precoAtividade;
    }

    public void setPrecoAtividade(float precoAtividade) {
        if (precoAtividade > 0)
            this.precoAtividade = precoAtividade;
    }

    public int vagas() {
        return this.maximoPessoas - this.clientes.size();
    }

    public int quantasPessoas() {
        return this.clientes.size();
    }

    public int getMaximoPessoas() {
        return this.maximoPessoas;
    }

    public String toString() {
        return "Horário: " + this.horario + "\nVagas: " + this.vagas();
    }

    public void imprimirClientes() {
        String s = "";
        for (Cliente c : this.clientes) {
            s += c.getNome() + "\n";
        }
        System.out.println(s);
    }
}
