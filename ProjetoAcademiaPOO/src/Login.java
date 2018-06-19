
public class Login implements Logavel{


	private Permissoes permissao;
	
	private String usuario;
	private String senha;
	
	public Login(){
		
	}
	
	public Login(Permissoes permissao, String usuario, String senha) {
		this.permissao = permissao;
		this.usuario = usuario;
		this.senha = senha;
	}
	
	@Override
	public Permissoes getPermissoes() {
		return permissao;
	}

	@Override
	public Login logar(String usuario, String senha) {
		return usuario.equals(this.usuario) && senha.equals(this.senha) ? this : null;
	}

}
