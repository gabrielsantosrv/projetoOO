//Um cliente VIP está matriculado normalmente à turmas e atividades porém pode comparecer a um numero de outras aulas por semana.

public class ClienteVIP{
    private int aulasPorSemana

    public ClienteVIP(String rg, String nome, String endereco, String telefone, String dataNascimento, boolean ativo, int aulasPorSemana){
        super(rg, nome, endereco, telefone, dataNascimento, ativo);
        this.aulasPorSemana = aulasPorSemana;
    }

    public int getAulasPorSemana() {
        return aulasPorSemana;
    }

    public void setAulasPorSemana(int aulasPorSemana) {
        this.aulasPorSemana = aulasPorSemana;
    }

    public float totalAPagar(){
        float pagamento = 0;
        int precoPorAula = 20;
        super.totalAPagar() + precoPorAula * aulasPorSemana;
    }
}