import java.util.ArrayList;
import java.util.Scanner;

public class Administrador extends Usuario {

    public Administrador(String rg, String nome, String endereco, String telefone, String dataNascimento, boolean ativo, String username, String senha) {
        super(rg, nome, endereco, telefone, dataNascimento, ativo, username, senha);
    }

    public Administrador(String username, String senha) {
        super(username, senha);
    }

    public void incluirInstrutor(BaseDados academia){
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
        System.out.println("RG:");
        String rg = input.next();
        Instrutor instrutor = new Instrutor(rg, nome, endereco, telefone, dataNascimento, true, salario, areas);
        academia.inserirInstrutor(instrutor);
        System.out.println("Instrutor incluído.");
    }

    public void excluirInstrutor(){

    }

    public void alterarInstrutor(BaseDados academia){
        System.out.println("ALTERAÇÃO DOS DADOS DO INSTRUTOR");
        System.out.println("RG do instrutor:");
        Scanner input = new Scanner(System.in);
        String rg = input.next();
        boolean achou = false;
        for (Instrutor ii : academia.getInstrutores()) {
            if (ii.getRg().equals(rg)) {
                achou = true;
                System.out.println("Mudar nome?");
                String nome = input.next();
                ii.setNome(nome);
                System.out.println("Mudar endereço?");
                String endereco = input.next();
                ii.setEndereco(endereco);
                System.out.println("Mudar telefone?");
                String telefone = input.next();
                ii.setTelefone(telefone);
                System.out.println("Mudar data de nascimento?");
                String dataNascimento = input.next();
                ii.setDataNascimento(dataNascimento);
                System.out.println("Mudar salário?");
                float salario = input.nextFloat();
                ii.setSalario(salario);
                System.out.println("Mudar quantidade de áreas?");
                int quantidade = input.nextInt();
                System.out.println("Digite as áreas:");
                ArrayList<String> areas = new ArrayList<>();
                for (int i = 0; i < quantidade; i++) {
                    areas.add(input.next());
                }
                ii.setAreas(areas);
                System.out.println("Mudar RG?");
                String novoRG = input.next();
                ii.setRG(novoRG);
            }
        }
        if (!achou) {
            System.out.println("RG não encontrado no sistema.");
        }
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
            System.out.println("RG:");
            String rg = input2.next();
            Usuario usuario = new Usuario(rg, nome, endereco, telefone, dataNascimento, true, username, senha);
            usuarios.add(usuario);
            System.out.println("Usuário incluído.");
        } else if (resposta.equals("N")) {
            Usuario usuario = new Usuario(username, senha);
            usuarios.add(usuario);
            System.out.println("Usuário incluído.");
        }
    }

    public void alterarUsuario(ArrayList<Usuario> usuarios){
        System.out.println("ALTERAÇÃO DE USUÁRIOS");
        String username, senha;
        System.out.println("Username:");
        Scanner input = new Scanner(System.in);
        username = input.next();
        boolean achou = false;
        for (Usuario u : usuarios) {
            if (u.getUsername().equals(username)) {
                achou = true;
                System.out.println("Novo username:");
                String novoUsername = input.next();
                u.setUsername(novoUsername);
                System.out.println("Nova senha:");
                senha = input.next();
                u.setSenha(senha);
                System.out.println("Deseja alterar detalhes do usuário? (S/N)");
                String resposta = input.next();
                if (resposta.equals("S")) {
                    String nome, endereco, telefone, dataNascimento;
                    System.out.println("Nome:");
                    nome = input.next();
                    u.setNome(nome);
                    System.out.println("Endereço:");
                    endereco = input.next();
                    u.setEndereco(endereco);
                    System.out.println("Telefone:");
                    telefone = input.next();
                    u.setTelefone(telefone);
                    System.out.println("Data de nascimento:");
                    dataNascimento = input.next();
                    u.setDataNascimento(dataNascimento);
                    System.out.println("RG:");
                    String rg = input.next();
                    u.setRG(rg);
                    System.out.println("Usuário alterado.");
                } else if (resposta.equals("N")) {
                    System.out.println("Usuário alterado.");
                }
            }
        }
        if (!achou) {
            System.out.println("Usuário não encontrado no sistema.");
        }
    }

    public void excluirUsuario(){

    }

    public void imprimirUsuarios(ArrayList<Usuario> usuarios) {
        for (Usuario u : usuarios) {
            System.out.println(u.toString());
        }
    }
}
