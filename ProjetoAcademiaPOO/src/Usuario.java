public class Usuario extends Pessoa{

    private String username;
    private String senha;

    // just testing something

    public Usuario(String nome, String endereco, String telefone, String dataNascimento, boolean ativo, String username, String senha) {
        super(nome, endereco, telefone, dataNascimento, ativo);
        this.username = username;
        this.senha = senha;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void incluirCliente(){

    }

    public void excluirCliente(){

    }

    public void alterarCliente(){

    }

    public void incluirAtividade(){

    }

    public void excluirAtividade(){

    }

    public void alterarAtividade(){

    }

    public void incluirTurma(){

    }

    public void excluirTurma(){

    }

    public void alterarTurma(){

    }

    public void relacionarTurmaAtividade(){

    }

    public void relacionarTurmaCliente(){

    }
}


// just testing