
public class Admin implements Logavel{


	private Permissoes permissao = Permissoes.ADMIN;
	
	private String usuario;
	private String senha;

	public Admin(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}

	public Admin(){

	}
	
	@Override
	public Permissoes getPermissoes() {
		return permissao;
	}

	@Override
	public Boolean logar(String usuario, String senha) {
		return usuario.equals(this.usuario) && senha.equals(this.senha);
	}

	@Override
	public String getUsername() {
		return this.usuario;
	}

}
