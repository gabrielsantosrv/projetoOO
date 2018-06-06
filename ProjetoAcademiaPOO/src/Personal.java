import java.util.ArrayList;
//um cliente pode contratar um personal além da mensalidade e das aulas ministradas, um cliente pode apenas tem um personal por vez
//mas um personal pode dar aula para n clientes
public class Personal extends Instrutor {
	
	private float mensalidade;
	private ArrayList<Cliente> clientes;

	public Personal(String rg, String nome, String endereco, String telefone, String dataNascimento, boolean ativo, ArrayList<String> areas, float mensalidade) {
		super(rg, nome, endereco, telefone, dataNascimento, ativo, areas);
		this.mensalidade = mensalidade;
		clientes = new ArrayList<>();
	}

	public Personal() {
		super();
	}

	public float getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(float mensalidade) {
		this.mensalidade = mensalidade;
	}
	
	public void adicionarCliente(Cliente c){
		clientes.add(c);
	}
	
	//cada cliente que o personal tem paga a quantida da mensalidade pra ele
	@Override
	public float getSalario(){
		return mensalidade*clientes.size();
	}

}
