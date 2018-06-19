
public class Comum implements Logavel {
	
	private Permissoes permissao = Permissoes.COMUM;

	private String usuario;
	private String senha;
	
	public Comum(String usuario, String senha) {
		super();
		this.usuario = usuario;
		this.senha = senha;
	}

	@Override
	public Boolean logar(String usuario, String senha) {
		return usuario.equals(this.usuario) && senha.equals(this.senha);
	}

	@Override
	public Permissoes getPermissoes() {
		return permissao;
	}

}
