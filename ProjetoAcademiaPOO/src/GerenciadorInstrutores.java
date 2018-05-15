import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorInstrutores extends GerenciadorClientesAtividades {

    public GerenciadorInstrutores(String nome, String endereco, String telefone, String dataNascimento, boolean ativo, String username, String senha) {
        super(nome, endereco, telefone, dataNascimento, ativo, username, senha);
    }

    public GerenciadorInstrutores(String username, String senha) {
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

    public void incluirUsuario(){

    }

    public void excluirUsuario(){

    }

    public void alterarUsuario(){

    }
}
