import java.util.ArrayList;

public abstract class Instrutor extends Pessoa{
    private ArrayList<String> areas;

    public abstract float getSalario();

    public Instrutor(String rg, String nome, String endereco, String telefone, String dataNascimento, boolean ativo, ArrayList<String> areas) {
        super(rg, nome, endereco, telefone, dataNascimento, ativo);
        this.setAreas(areas);
    }

    public Instrutor() {
        super();
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
        String strAreas = "";
        int count = 0;
        for (String a : areas) {
            strAreas += a;
            if (count != areas.size() - 1)
                strAreas += ", ";
            count++;
        }
        ret += "\n Áreas: " + strAreas;
        return ret;
    }
}
