import java.util.Scanner;

public class Usuario extends Pessoa{

    private String username;
    private String senha;

    public Usuario(String nome, String endereco, String telefone, String dataNascimento, boolean ativo, String username, String senha) {
        super(nome, endereco, telefone, dataNascimento, ativo);
        this.username = username;
        this.senha = senha;
    }

    public Usuario(String username, String senha) {
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
        System.out.println("INCLUSÃO DE CLIENTE");
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
        System.out.println("INCLUSÃO DE ATIVIDADE");
        String nome;
        float preco;
        Scanner input = new Scanner(System.in);
        System.out.println("Nome:");
        nome = input.next();
        System.out.println("Preco:");
        preco = input.nextFloat();
        Atividade atividade = new Atividade(nome, preco);
        academia.inserirAtividade(atividade);
        System.out.println("Atividade incluída.");
    }

    public void excluirAtividade(Academia academia){
    }

    public void alterarAtividade(Academia academia){
    }

    public void incluirTurma(Academia academia){
        System.out.println("INCLUSÃO DE TURMA");
        System.out.println("Atividade:");
        Scanner input = new Scanner(System.in);
        String atividade = input.next();
        boolean encontrouAtividade = false;
        for (Atividade a : academia.getAtividades()) {
            if (a.getNome().equalsIgnoreCase(atividade)) {
                encontrouAtividade = true;
                System.out.println("Horário:");
                String horario = input.next();
                System.out.println("Máximo de pessoas:");
                int maximo = input.nextInt();
                Turma turma = new Turma(horario, a.getPreco(), maximo);
                academia.inserirTurma(a, turma);
                System.out.println("Turma criada.");
                break;
            }
        }
        if (!encontrouAtividade) {
            System.out.println("Atividade não encontrada.");
        }
    }

    public void excluirTurma(Academia academia){

    }

    public void alterarTurma(Academia academia){

    }

    public void relacionarTurmaAtividade(){

    }

    public void relacionarTurmaCliente(){

    }

    public String toString() {
        String ret = "Username: " + this.username + "\nSenha: " + this.senha + "\n";
        ret += super.toString();
        return ret;
    }
}