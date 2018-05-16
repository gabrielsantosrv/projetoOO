public class Cliente extends Pessoa {

    public Cliente(String rg, String nome, String endereco, String telefone, String dataNascimento, boolean ativo) {
        super(rg, nome, endereco, telefone, dataNascimento, ativo);
    }

    public float totalAPagar() {
        float pagamento = 0;
        for (Turma t : this.getTurmas()) {
            pagamento += t.getPrecoAtividade();
        }
        return pagamento;
    }

    public String toString() {
        String ret = super.toString();
        ret += "\nTotal a pagar: " + this.totalAPagar();
        return ret;
    }
}
