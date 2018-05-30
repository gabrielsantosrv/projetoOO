import java.util.ArrayList;

public class Instrutor extends Pessoa{
    private float salario;
    private ArrayList<String> areas;

    public Instrutor(String rg, String nome, String endereco, String telefone, String dataNascimento, boolean ativo, float salario, ArrayList<String> areas) {
        super(rg, nome, endereco, telefone, dataNascimento, ativo);
        this.setSalario(salario);
        this.setAreas(areas);
    }

    public Instrutor(String rg, String nome, String endereco, String telefone, String dataNascimento, boolean ativo, ArrayList<String> areas){
        super(rg, nome, endereco, telefone, dataNascimento, ativo);
        this.setAreas(areas);
    }

    public Instrutor() {
        super();
    }

    public float getSalario() {
        return this.salario;
    }

    public void setSalario(float salario) {
        if (salario > 0)
            this.salario = salario;
    }

    public ArrayList<String> getAreas() {
		return areas;
	}

	public void setAreas(ArrayList<String> areas) {
        if (!areas.isEmpty())
            this.areas = areas;
    }

    public String toString() {
        String ret = super.toString();
        ret += "\nSalÃ¡rio: " + this.salario;
        String strAreas = "";
        int count = 0;
        for (String a : areas) {
            strAreas += a;
            if (count != areas.size() - 1)
                strAreas += ", ";
            count++;
        }
        ret += "\nÃ�reas: " + strAreas;
        return ret;
    }
}
