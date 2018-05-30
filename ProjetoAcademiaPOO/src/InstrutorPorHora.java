import java.util.ArrayList;

public class InstrutorPorHora extends Instrutor{
    private float horasTrabalhadas;
    private float pagamentoPorHora;

    public InstrutorPorHora(String rg, String nome, String endereco, String telefone, String dataNascimento, boolean ativo, ArrayList<String> areas, float horasTrabalhadas, float pagamentoPorHora){
        super(rg, nome, endereco, telefone, dataNascimento, ativo, areas);
        this.horasTrabalhadas = horasTrabalhadas;
        this.pagamentoPorHora = pagamentoPorHora;
    }

    public float getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(float horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public float getPagamentoPorHora(){ return pagamentoPorHora; }

    public void setPagamentoPorHora(float pagamentoPorHora) { this.pagamentoPorHora = pagamentoPorHora; }

    @Override
    public float getSalario(){
        return this.horasTrabalhadas * this.pagamentoPorHora;
    }

}