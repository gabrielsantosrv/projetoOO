import java.util.Scanner;

public class GerenciadorClientesAtividades extends Pessoa{

    private String username;
    private String senha;

    public GerenciadorClientesAtividades(String nome, String endereco, String telefone, String dataNascimento, boolean ativo, String username, String senha) {
        super(nome, endereco, telefone, dataNascimento, ativo);
        this.username = username;
        this.senha = senha;
    }

    public GerenciadorClientesAtividades(String username, String senha) {
        super("", "", "", "", true);
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

    public void incluirCliente(Academia academia){
        String nome, endereco, telefone, dataNascimento;
        Scanner input = new Scanner(System.in);
        System.out.println("Nome:");
        nome = input.next();
        System.out.println("Endereço:");
        endereco = input.next();
        System.out.println("Telefone:");
        telefone = input.next();
        System.out.println("Data de nascimento:");
        dataNascimento = input.next();
        Cliente cliente = new Cliente(nome, endereco, telefone, dataNascimento, true);
        academia.inserirCliente(cliente);
        System.out.println("Cliente incluído.");
    }

    public void excluirCliente(Academia academia){
    }

    public void alterarCliente(Academia academia){
    }

    public void incluirAtividade(Academia academia){
    }

    public void excluirAtividade(Academia academia){
    }

    public void alterarAtividade(Academia academia){
    }

    public void incluirTurma(Academia academia){

    }

    public void excluirTurma(Academia academia){

    }

    public void alterarTurma(Academia academia){

    }

    public void relacionarTurmaAtividade(){

    }

    public void relacionarTurmaCliente(){

    }
}