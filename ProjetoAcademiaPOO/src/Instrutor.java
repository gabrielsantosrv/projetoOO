import java.util.ArrayList;

public class Instrutor extends Pessoa{
    private float salario;
    private ArrayList<String> areas;

    public Instrutor(String nome, String endereco, String telefone, String dataNascimento, boolean ativo, float salario, ArrayList<String> areas) {
        super(nome, endereco, telefone, dataNascimento, ativo);
        this.salario = salario;
        this.areas = areas;
    }

    // testing git 13/05

    public float getSalario() {
        return this.salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void adicionarArea(String area) {
        this.areas.add(area);
    }

    public void removerArea(String area) {
        this.areas.remove(area);
    }
}
