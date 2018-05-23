//Um cliente VIP está matriculado normalmente à turmas e atividades porém pode comparecer a um numero de outras aulas por semana.

public class ClienteVIP extends Cliente{
    private int aulasPorSemana;
    private float precoPorAula;

    public ClienteVIP(String rg, String nome, String endereco, String telefone, String dataNascimento, boolean ativo, Personal personal, int aulasPorSemana){
        super(rg, nome, endereco, telefone, dataNascimento, ativo, personal);
        this.aulasPorSemana = aulasPorSemana;
        this.precoPorAula = precoPorAula;
    }

    public int getAulasPorSemana() { return aulasPorSemana; }

    public void setAulasPorSemana(int aulasPorSemana) { this.aulasPorSemana = aulasPorSemana; }

    public float getPrecoPorAula() { return precoPorAula; }

    public void setPrecoPorAula(float precoPorAula){ this.precoPorAula = precoPorAula; }
    
    @Override
    public float totalAPagar(){
        return super.totalAPagar() + (aulasPorSemana*precoPorAula);
    }
}