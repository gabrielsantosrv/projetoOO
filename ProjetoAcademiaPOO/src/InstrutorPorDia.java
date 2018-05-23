import java.util.ArrayList;

public class InstrutorPorDia extends Instrutor{
    private int diasTrabalhados;
    private int pagamentoPorDia;

    public InstrutorPorDia(String rg, String nome, String endereco, String telefone, String dataNascimento, boolean ativo, float salario, ArrayList<String> areas, int diasTrabalhados){
        super(rg, nome, endereco, telefone, dataNascimento, ativo, salario, areas);
        this.diasTrabalhados = diasTrabalhados;
    }

    public int getDiasTrabalhados() {
        return diasTrabalhados;
    }

    public void setDiasTrabalhados(int diasTrabalhados) {
        this.diasTrabalhados = diasTrabalhados;
    }

    public float getPagamentoPorDia(){
        return super.getSalario()/this.diasTrabalhados;
    }
}