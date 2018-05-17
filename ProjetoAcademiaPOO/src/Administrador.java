import java.util.ArrayList;
import java.util.Scanner;

public class Administrador extends Usuario {
    public Administrador(String username, String senha) {
        super(username, senha);
    }

    public void incluirInstrutor(){
        System.out.println("INCLUSÃO DE INSTRUTOR");
        String nome, endereco, telefone, dataNascimento;
        float salario;
        ArrayList<String> areas = new ArrayList<>();
        
        System.out.println("RG:");
        String rg = this.input.next();
        System.out.println("Nome:");
        nome = this.input.next();
        System.out.println("Endereço:");
        endereco = this.input.next();
        System.out.println("Telefone:");
        telefone = this.input.next();
        System.out.println("Data de nascimento:");
        dataNascimento = this.input.next();
        System.out.println("Salario:");
        salario = this.input.nextFloat();
        System.out.println("Em quantas áreas atua?");
        int quantidade = this.input.nextInt();
        System.out.println("Digite as áreas:");
        for (int i = 0; i < quantidade; i++) {
            areas.add(this.input.next());
        }
        Instrutor instrutor = new Instrutor(rg, nome, endereco, telefone, dataNascimento, true, salario, areas);
        if (this.academia.incluirInstrutor(instrutor))
            System.out.println("Instrutor incluído.");
        else
            System.out.println("Já existe um instrutor com esse RG no sistema.");
    }

    public void desativarInstrutor() {
        System.out.println("DESATIVAR INSTRUTOR");
        System.out.println("RG do instrutor:");
        
        String rg = this.input.next();
        Instrutor i = this.academia.encontrarInstrutor(rg);
        if (this.academia.desativarInstrutor(i)) {
            System.out.println("Instrutor desativado.");
        } else {
            System.out.println("Instrutor não encontrado no sistema.");
        }
    }

    public void alterarInstrutor(){
        System.out.println("ALTERAÇÃO DOS DADOS DO INSTRUTOR");
        System.out.println("RG do instrutor:");
        
        String rg = this.input.next();
        Instrutor antigo = this.academia.encontrarInstrutor(rg);
        Instrutor novo = new Instrutor();
        novo.setRG(rg);
        System.out.println("Mudar nome?");
        String nome = this.input.next();
        novo.setNome(nome);
        System.out.println("Mudar endereço?");
        String endereco = this.input.next();
        novo.setEndereco(endereco);
        System.out.println("Mudar telefone?");
        String telefone = this.input.next();
        novo.setTelefone(telefone);
        System.out.println("Mudar data de nascimento?");
        String dataNascimento = this.input.next();
        novo.setDataNascimento(dataNascimento);
        System.out.println("Mudar salário?");
        float salario = this.input.nextFloat();
        novo.setSalario(salario);
        System.out.println("Mudar quantidade de áreas?");
        int quantidade = this.input.nextInt();
        System.out.println("Digite as áreas:");
        ArrayList<String> areas = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            areas.add(this.input.next());
        }
        novo.setAreas(areas);
        if (this.academia.alterarInstutor(antigo, novo))
            System.out.println("Instrutor alterado.");
        else
            System.out.println("Instrutor não encontrado no sistema.");
    }

    public void incluirUsuario(ArrayList<Usuario> usuarios){
        System.out.println("INCLUSÃO DE USUÁRIOS");
        String username, senha;
        System.out.println("Username:");
        username = this.input.next();
        System.out.println("Senha:");
        senha = this.input.next();
        Usuario usuario = new Usuario(username, senha);
        usuarios.add(usuario);
        System.out.println("Usuário incluído.");
    }

    public void alterarUsuario(ArrayList<Usuario> usuarios){
        System.out.println("ALTERAÇÃO DE USUÁRIOS");
        String username, senha;
        System.out.println("Username:");
        
        username = this.input.next();
        boolean achou = false;
        for (Usuario u : usuarios) {
            if (u.getUsername().equals(username)) {
                achou = true;
                System.out.println("Novo username:");
                String novoUsername = this.input.next();
                u.setUsername(novoUsername);
                System.out.println("Nova senha:");
                senha = this.input.next();
                u.setSenha(senha);
                System.out.println("Usuário alterado.");
            }
        }
        if (!achou) {
            System.out.println("Usuário não encontrado no sistema.");
        }
    }

    public void excluirUsuario(ArrayList<Usuario> usuarios){
        System.out.println("EXCLUSÃO DE USUÁRIOS");
        String username, senha;
        System.out.println("Username:");

        username = this.input.next();
        boolean achou = false;
        for (Usuario u : usuarios) {
            if (u.getUsername().equals(username)) {
                achou = true;
                usuarios.remove(u);
                System.out.println("Usuário excluído.");
                break;
            }
        }
        if (!achou) {
            System.out.println("Usuário não encontrado no sistema.");
        }
    }

    public void imprimirUsuarios(ArrayList<Usuario> usuarios) {
        for (Usuario u : usuarios) {
            System.out.println(u.toString());
        }
    }
}
