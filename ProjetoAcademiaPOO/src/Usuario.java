import java.util.Scanner;

public class Usuario extends Pessoa{

    private String username;
    private String senha;

    public Usuario(String rg, String nome, String endereco, String telefone, String dataNascimento, boolean ativo, String username, String senha) {
        super(rg, nome, endereco, telefone, dataNascimento, ativo);
        this.username = username;
        this.senha = senha;
    }

    public Usuario(String username, String senha) {
        super("", "", "", "", "", true);
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

    public void incluirCliente(BaseDados academia){
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
        System.out.println("RG:");
        String rg = input.next();
        Cliente cliente = new Cliente(rg, nome, endereco, telefone, dataNascimento, true);
        if (academia.incluirCliente(cliente)) {
            System.out.println("Cliente incluído.");
        } else {
            System.out.println("Já existe um cliente com esse RG.");
        }
    }

    public void desativarCliente(BaseDados academia){
        System.out.println("DESATIVAR CLIENTE");
        System.out.println("RG do cliente:");
        Scanner input = new Scanner(System.in);
        String rg = input.next();
        Cliente c = academia.encontrarCliente(rg);
        if (academia.desativarCliente(c)) {
            System.out.println("Cliente desativado.");
        } else {
            System.out.println("Cliente não encontrado no sistema.");
        }
    }

    public void alterarCliente(BaseDados academia){
        System.out.println("ALTERAÇÃO DOS DADOS DO CLIENTE");
        System.out.println("RG do cliente:");
        Scanner input = new Scanner(System.in);
        String rg = input.next();
        Cliente antigo = academia.encontrarCliente(rg);
        Cliente novo = new Cliente();
        System.out.println("Mudar nome?");
        String nome = input.next();
        novo.setNome(nome);
        System.out.println("Mudar endereço?");
        String endereco = input.next();
        novo.setEndereco(endereco);
        System.out.println("Mudar telefone?");
        String telefone = input.next();
        novo.setTelefone(telefone);
        System.out.println("Mudar data de nascimento?");
        String dataNascimento = input.next();
        novo.setDataNascimento(dataNascimento);
        novo.setRG(rg);
        if (academia.alterarCliente(antigo, novo))
            System.out.println("Cliente alterado.");
        else
            System.out.println("Cliente não encontrado no sistema.");
    }

    public void incluirAtividade(BaseDados academia){
        System.out.println("INCLUSÃO DE ATIVIDADE");
        String nome;
        float preco;
        Scanner input = new Scanner(System.in);
        System.out.println("Nome:");
        nome = input.next();
        System.out.println("Preco:");
        preco = input.nextFloat();
        Atividade atividade = new Atividade(nome, preco);
        if (academia.incluirAtividade(atividade))
            System.out.println("Atividade incluída.");
        else
            System.out.println("Essa atividade já existe.");
    }

    public void excluirAtividade(BaseDados academia){
        //TODO
    }

    public void alterarAtividade(BaseDados academia){
        //TODO
    }

    public void incluirTurma(BaseDados academia){
        System.out.println("CRIAÇÃO DE TURMA");
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
                System.out.println("Chave:");
                String chave = input.next();
                Turma turma = new Turma(horario, a.getPreco(), maximo, chave);
    //           todo academia.inserirTurma(a, turma);
                System.out.println("Turma criada.");
                break;
            }
        }
        if (!encontrouAtividade) {
            System.out.println("Atividade não encontrada.");
        }
    }

    public void excluirTurma(BaseDados academia){

    }

    public void alterarTurma(BaseDados academia){

    }

    public void relacionarTurmaCliente(BaseDados academia){
        System.out.println("ASSOCIAÇÃO DE TURMA E CLIENTE");
        System.out.println("RG do cliente:");
        Scanner input = new Scanner(System.in);
        String rg = input.next();
        System.out.println("Atividade:");
        String atividade = input.next();
        System.out.println("Chave da turma:");
        String chave = input.next();
        boolean parar = false;
        for (Cliente c : academia.getClientes()) {
            if (parar)
                break;

            if (rg.equals(c.getRg())) {
                for (Atividade a : academia.getAtividades()) {
                    if (parar)
                        break;

                    if (atividade.equalsIgnoreCase(a.getNome())) {
                        for (Turma t : a.getTurmas()) {
                            if (parar)
                                break;

                            if (t.getId().equals(chave)) {
                                t.adicionarCliente(c);
                                c.adicionarTurma(t);
                                System.out.println("Cliente incluído na turma. Turma incluída na lista de turmas do cliente.");
                                parar = true;
                            }
                        }
                    }
                }
            }
        }
        if (!parar)
            System.out.println("Cliente, atividade ou chave da turma inválidos.");
    }

    public void desrelacionarTurmaCliente(BaseDados academia) {
        System.out.println("REMOVER CLIENTE DE TURMA");
        System.out.println("RG do cliente:");
        Scanner input = new Scanner(System.in);
        String rg = input.next();
        System.out.println("Atividade:");
        String atividade = input.next();
        System.out.println("Chave da turma:");
        String chave = input.next();
        boolean parar = false;
        for (Cliente c : academia.getClientes()) {
            if (parar)
                break;

            if (rg.equals(c.getRg())) {
                for (Atividade a : academia.getAtividades()) {
                    if (parar)
                        break;

                    if (atividade.equalsIgnoreCase(a.getNome())) {
                        for (Turma t : a.getTurmas()) {
                            if (parar)
                                break;

                            if (t.getId().equals(chave)) {
                                t.removerCliente(c);
                                c.removerTurma(t);
                                System.out.println("Cliente removido da turma. Turma removida da lista de turmas do cliente.");
                                parar = true;
                            }
                        }
                    }
                }
            }
        }
        if (!parar)
            System.out.println("Cliente, atividade ou chave da turma inválidos.");
    }

    public void relacionarTurmaInstrutor(BaseDados academia){
        System.out.println("ASSOCIAR INSTRUTOR E TURMA");
        System.out.println("RG do instrutor:");
        Scanner input = new Scanner(System.in);
        String rg = input.next();
        System.out.println("Atividade:");
        String atividade = input.next();
        System.out.println("Chave da turma:");
        String chave = input.next();
        boolean parar = false;
        for (Instrutor i : academia.getInstrutores()) {
            if (parar)
                break;

            if (rg.equals(i.getRg())) {
                for (Atividade a : academia.getAtividades()) {
                    if (parar)
                        break;

                    if (atividade.equalsIgnoreCase(a.getNome())) {
                        for (Turma t : a.getTurmas()) {
                            if (parar)
                                break;

                            if (t.getId().equals(chave)) {
                                t.adicionarInstrutor(i);
                                i.adicionarTurma(t);
                                System.out.println("Instrutor associado à turma. Turma incluída na lista de turmas do instrutor.");
                                parar = true;
                            }
                        }
                    }
                }
            }
        }
        if (!parar)
            System.out.println("Instrutor, atividade ou chave da turma inválidos.");
    }

    public void desrelacionarTurmaInstrutor(BaseDados academia){
        System.out.println("REMOVER INSTRUTOR DA TURMA");
        System.out.println("RG do instrutor:");
        Scanner input = new Scanner(System.in);
        String rg = input.next();
        System.out.println("Atividade:");
        String atividade = input.next();
        System.out.println("Chave da turma:");
        String chave = input.next();
        boolean parar = false;
        for (Instrutor i : academia.getInstrutores()) {
            if (parar)
                break;

            if (rg.equals(i.getRg())) {
                for (Atividade a : academia.getAtividades()) {
                    if (parar)
                        break;

                    if (atividade.equalsIgnoreCase(a.getNome())) {
                        for (Turma t : a.getTurmas()) {
                            if (parar)
                                break;

                            if (t.getId().equals(chave)) {
                                t.removerInstrutor(i);
                                i.removerTurma(t);
                                System.out.println("Instrutor removido da turma. Turma removida da lista de turmas do instrutor.");
                                parar = true;
                            }
                        }
                    }
                }
            }
        }
        if (!parar)
            System.out.println("Instrutor, atividade ou chave da turma inválidos.");
    }

    public void verificarClientesPorTurma(BaseDados academia) {
        System.out.println("VERIFICAR CLIENTES DE UMA TURMA");
        System.out.println("Atividade:");
        Scanner input = new Scanner(System.in);
        String atividade = input.next();
        System.out.println("Chave da turma:");
        String chave = input.next();
        boolean achou = false;
        for (Atividade a : academia.getAtividades()) {
            if (a.getNome().equalsIgnoreCase(atividade)) {
                for (Turma t : a.getTurmas()) {
                    if (t.getId().equals(chave)) {
                        achou = true;
                        if (t.getClientes().size() == 0) {
                            System.out.println("A turma ainda não tem clientes.");
                        } else t.imprimirClientes();
                    }
                }
            }
        }
        if (!achou) {
            System.out.println("Atividade ou turma inválidas.");
        }
    }

    public String toString() {
        String ret = "Username: " + this.username + "\nSenha: " + this.senha + "\n";
        ret += super.toString();
        return ret;
    }

    public boolean RGClienteRepetido(String rg, BaseDados academia) {
        for (Cliente c : academia.getClientes()) {
            if (c.getRg().equals(rg)) {
                return true;
            }
        }
        return false;
    }

    public boolean RGInstrutorRepetido(String rg, BaseDados academia) {
        for (Instrutor i : academia.getInstrutores()) {
            if (i.getRg().equals(rg)) {
                return true;
            }
        }
        return false;
    }

    public boolean idTurmaRepetido(String id, Atividade atividade) {
        for (Turma t : atividade.getTurmas()) {
            if (t.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}