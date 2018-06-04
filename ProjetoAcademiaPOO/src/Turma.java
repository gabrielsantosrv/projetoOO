import java.util.ArrayList;

public class Turma {
    private ArrayList<Cliente> clientes;
    private ArrayList<Instrutor> instrutores;
    private String horario;
    private int maximoPessoas;
    private String id;
    private Atividade atividade;

    public Turma(String horario, int maximoPessoas, String id, Atividade atividade) {
        this.clientes = new ArrayList<>();
        this.instrutores = new ArrayList<>();
        this.setMaximoPessoas(maximoPessoas);
        this.setHorario(horario);
        this.setId(id);
        this.setAtividade(atividade);
    }

    public Turma() {
        this.clientes = new ArrayList<>();
        this.instrutores = new ArrayList<>();
        this.maximoPessoas = 0;
        this.horario = "";
        this.id = "";
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
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

    public int vagas() {
        return this.maximoPessoas - this.clientes.size();
    }

    public int quantosClientes() {
        return this.clientes.size();
    }

    public int quantosInstrutores() { return this.instrutores.size(); }

    public int getMaximoPessoas() {
        return this.maximoPessoas;
    }

    public String toString() {
        return "ID: " + this.id + "\nHorário: " + this.horario + "\nVagas: " + this.vagas();
    }

    public void imprimirClientes() {
        String s = "";
        for (Cliente c : this.clientes) {
            s += c.getNome() + "\n";
        }
        System.out.println(s);
    }

    public void imprimirInstrutores() {
        String s = "";
        for (Instrutor i : this.instrutores){
            s += i.getNome() + "\n";
        }
        System.out.printf(s);
    }
}
