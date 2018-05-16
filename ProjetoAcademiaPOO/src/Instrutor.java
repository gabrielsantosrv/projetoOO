import java.util.ArrayList;

public class Instrutor extends Pessoa{
    private float salario;
    private ArrayList<String> areas;

    public Instrutor(String rg, String nome, String endereco, String telefone, String dataNascimento, boolean ativo, float salario, ArrayList<String> areas) {
        super(rg, nome, endereco, telefone, dataNascimento, ativo);
        this.salario = salario;
        this.areas = areas;
    }

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

    public String toString() {
        String ret = super.toString();
        ret += "\nSalário: " + this.salario;
        String strAreas = "";
        int count = 0;
        for (String a : areas) {
            strAreas += a;
            if (count != areas.size() - 1)
                strAreas += ", ";
            count++;
        }
        ret += "\nÁreas: " + strAreas;
        return ret;
    }
}
