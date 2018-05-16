import java.util.ArrayList;
import java.util.Scanner;

public class Administrador extends Usuario {

    public Administrador(String nome, String endereco, String telefone, String dataNascimento, boolean ativo, String username, String senha) {
        super(nome, endereco, telefone, dataNascimento, ativo, username, senha);
    }

    public Administrador(String username, String senha) {
        super(username, senha);
    }

    public void incluirInstrutor(Academia academia){
        System.out.println("INCLUSÃO DE INSTRUTOR");
        String nome, endereco, telefone, dataNascimento;
        float salario;
        ArrayList<String> areas = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Nome:");
        nome = input.next();
        System.out.println("Endereço:");
        endereco = input.next();
        System.out.println("Telefone:");
        telefone = input.next();
        System.out.println("Data de nascimento:");
        dataNascimento = input.next();
        System.out.println("Salario:");
        salario = input.nextFloat();
        System.out.println("Em quantas áreas atua?");
        int quantidade = input.nextInt();
        System.out.println("Digite as áreas:");
        for (int i = 0; i < quantidade; i++) {
            areas.add(input.next());
        }
        Instrutor instrutor = new Instrutor(nome, endereco, telefone, dataNascimento, true, salario, areas);
        academia.inserirInstrutor(instrutor);
        System.out.println("Instrutor incluído.");
    }

    public void excluirInstrutor(){

    }

    public void alterarInstrutor(){

    }

    public void incluirUsuario(ArrayList<Usuario> usuarios){
        System.out.println("INCLUSÃO DE USUÁRIOS");
        String username, senha;
        System.out.println("Username:");
        Scanner input = new Scanner(System.in);
        username = input.next();
        System.out.println("Senha:");
        senha = input.next();
        System.out.println("Deseja acrescentar detalhes do usuário? (S/N)");
        String resposta = input.next();
        if (resposta.equals("S")) {
            String nome, endereco, telefone, dataNascimento;
            Scanner input2 = new Scanner(System.in);
            System.out.println("Nome:");
            nome = input2.next();
            System.out.println("Endereço:");
            endereco = input2.next();
            System.out.println("Telefone:");
            telefone = input2.next();
            System.out.println("Data de nascimento:");
            dataNascimento = input2.next();
            Usuario usuario = new Usuario(nome, endereco, telefone, dataNascimento, true, username, senha);
            usuarios.add(usuario);
            System.out.println("Usuário incluído.");
        } else if (resposta.equals("N")) {
            Usuario usuario = new Usuario(username, senha);
            usuarios.add(usuario);
            System.out.println("Usuário incluído.");
        }
    }

    public void excluirUsuario(){

    }

    public void alterarUsuario(){

    }

    public void imprimirUsuarios(ArrayList<Usuario> usuarios) {
        for (Usuario u : usuarios) {
            System.out.println(u.toString());
        }
    }
}
