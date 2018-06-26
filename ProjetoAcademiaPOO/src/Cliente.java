public class Cliente extends Pessoa{
	
	private Personal personal;

    public Cliente(String rg, String nome, String endereco, String telefone, String dataNascimento, boolean ativo, Personal personal) {
        super(rg, nome, endereco, telefone, dataNascimento, ativo);
        this.personal = personal;
    }

    public Cliente() {
        super();
    }

    public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	public float totalAPagar() {
        float pagamento = 0;
        for (Turma t : this.getTurmas()) {
            pagamento += t.getAtividade().getPreco();
        }
        return personal != null ? pagamento + personal.getMensalidade() : pagamento;
    }

    public String toString() {
        String ret = super.toString();
        ret += "\n Personal" + this.personal != null ? this.personal.getNome() : "sem personal ";
        return ret;
    }
}
