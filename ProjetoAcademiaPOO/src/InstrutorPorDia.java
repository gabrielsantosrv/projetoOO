import java.util.ArrayList;

public class InstrutorPorDia extends Instrutor{
    private int diasTrabalhados;
    private float pagamentoPorDia;

    public InstrutorPorDia(String rg, String nome, String endereco, String telefone, String dataNascimento, boolean ativo, ArrayList<String> areas, int diasTrabalhados, float pagamentoPorDia){
        super(rg, nome, endereco, telefone, dataNascimento, ativo, areas);
        this.diasTrabalhados = diasTrabalhados;
        this.pagamentoPorDia = pagamentoPorDia;
    }

    public int getDiasTrabalhados() {
        return diasTrabalhados;
    }

    public void setDiasTrabalhados(int diasTrabalhados) {
        this.diasTrabalhados = diasTrabalhados;
    }

    public float getPagamentoPorDia(){ return pagamentoPorDia; }

    public void setPagamentoPorDia(float pagamentoPorDia){ this.pagamentoPorDia = pagamentoPorDia; }

    @Override
    public float getSalario(){
        return this.diasTrabalhados * pagamentoPorDia;
    }

}