public class Cliente extends Pessoa {

    public Cliente(String nome, String endereco, String telefone, String dataNascimento, boolean ativo) {
        super(nome, endereco, telefone, dataNascimento, ativo);
    }

    public float totalAPagar() {
        float pagamento = 0;
        for (Turma t : this.getTurmas()) {
            pagamento += t.getPrecoAtividade();
        }
        return pagamento;
    }
}
