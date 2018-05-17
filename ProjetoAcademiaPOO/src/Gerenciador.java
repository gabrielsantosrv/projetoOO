import java.util.ArrayList;
import java.util.Scanner;

public class Gerenciador {
    private String username;
    private String senha;
    protected BaseDados academia;
    protected Scanner input;
    private Permissoes permissoes;

    public Gerenciador(String username, String senha) {
        this.setPermissoes(Permissoes.COMUM);
        this.setUsername(username);
        this.setSenha(senha);
        this.academia = new BaseDados();
        this.input = new Scanner(System.in);
    }

    public Permissoes getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(Permissoes permissoes) {
        this.permissoes = permissoes;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (!username.equals(""))
            this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (!senha.equals(""))
            this.senha = senha;
    }

    public void incluirCliente(){
        System.out.println("INCLUSÃO DE CLIENTE");
        String nome, endereco, telefone, dataNascimento;
        System.out.println("Nome:");
        nome = this.input.next();
        System.out.println("Endereço:");
        endereco = this.input.next();
        System.out.println("Telefone:");
        telefone = this.input.next();
        System.out.println("Data de nascimento:");
        dataNascimento = this.input.next();
        System.out.println("RG:");
        String rg = this.input.next();
        Cliente cliente = new Cliente(rg, nome, endereco, telefone, dataNascimento, true);
        if (this.academia.incluirCliente(cliente)) {
            System.out.println("Cliente incluído.");
        } else {
            System.out.println("Já existe um cliente com esse RG.");
        }
    }

    public void desativarCliente(){
        System.out.println("DESATIVAR CLIENTE");
        System.out.println("RG do cliente:");
        String rg = this.input.next();
        Cliente c = this.academia.encontrarCliente(rg);
        if (this.academia.desativarCliente(c)) {
            System.out.println("Cliente desativado.");
        } else {
            System.out.println("Cliente não encontrado no sistema.");
        }
    }

    public void alterarCliente(){
        System.out.println("ALTERAÇÃO DOS DADOS DO CLIENTE");
        System.out.println("RG do cliente:");
        String rg = this.input.next();
        Cliente antigo = this.academia.encontrarCliente(rg);
        Cliente novo = new Cliente();
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
        novo.setRG(rg);
        if (this.academia.alterarCliente(antigo, novo))
            System.out.println("Cliente alterado.");
        else
            System.out.println("Cliente não encontrado no sistema.");
    }

    public void incluirAtividade(){
        System.out.println("INCLUSÃO DE ATIVIDADE");
        String nome;
        float preco;
        System.out.println("Nome:");
        nome = this.input.next();
        System.out.println("Preco:");
        preco = this.input.nextFloat();
        Atividade atividade = new Atividade(nome, preco);
        if (this.academia.incluirAtividade(atividade))
            System.out.println("Atividade incluída.");
        else
            System.out.println("Essa atividade já existe.");
    }

    public void excluirAtividade(){
        System.out.println("EXCLUSÃO DE ATIVIDADES");
        System.out.println("Nome da atividade:");
        String nome = this.input.next();
        Atividade a = this.academia.encontrarAtividade(nome);
        if (this.academia.excluirAtividade(a))
            System.out.println("Atividade excluída.");
        else
            System.out.println("Atividade não existe no sistema.");
    }

    public void alterarAtividade(){
        System.out.println("ALTERAÇÃO DE ATIVIDADE");
        System.out.println("Nome da atividade:");
        String atividade = this.input.next();
        Atividade antiga = this.academia.encontrarAtividade(atividade);
        Atividade nova = new Atividade();
        System.out.println("Mudar preço?");
        float preco = this.input.nextFloat();
        nova.setPreco(preco);
        nova.setNome(atividade);
        if (this.academia.alterarAtividade(antiga, nova))
            System.out.println("Atividade alterada.");
        else
            System.out.println("Atividade não encontrada no sistema.");
    }

    public void incluirTurma(){
        System.out.println("CRIAÇÃO DE TURMA");
        System.out.println("Atividade:");
        String atividade = this.input.next();
        Atividade a = this.academia.encontrarAtividade(atividade);
        System.out.println("Horário:");
        String horario = this.input.next();
        System.out.println("Máximo de pessoas:");
        int maximo = this.input.nextInt();
        System.out.println("ID:");
        String id = this.input.next();
        Turma turma = new Turma(horario, a.getPreco(), maximo, id);
        if (this.academia.incluirTurma(turma, a))
            System.out.println("Turma incluída.");
        else
            System.out.println("Turma já existe ou atividade não existe.");
    }

    public void excluirTurma(){
        System.out.println("EXCLUSÃO DE TURMAS");
        System.out.println("Nome da atividade:");
        String nome = this.input.next();
        Atividade a = this.academia.encontrarAtividade(nome);
        System.out.println("ID da turma:");
        String id = this.input.next();
        Turma t = this.academia.encontrarTurma(id, a);
        if (this.academia.excluirTurma(t, a))
            System.out.println("Turma excluída.");
        else
            System.out.println("Turma ou atividade não existe no sistema.");
    }

    public void alterarTurma(){
        System.out.println("ALTERAÇÃO DE TURMA");
        System.out.println("Atividade:");
        String atividade = this.input.next();
        Atividade atividade1 = this.academia.encontrarAtividade(atividade);
        System.out.println("ID da turma:");
        String id = this.input.next();
        Turma antiga = this.academia.encontrarTurma(id, atividade1);
        Turma nova = new Turma();
        System.out.println("Mudar horário?");
        String horario = this.input.next();
        System.out.println("Mudar máximo de pessoas?");
        int max = this.input.nextInt();
        nova.setMaximoPessoas(max);
        nova.setHorario(horario);
        nova.setId(id);
        if (this.academia.alterarTurma(antiga, nova, atividade1))
            System.out.println("Turma alterada.");
        else
            System.out.println("Turma ou atividade não encontrada no sistema.");
    }

    public void relacionarTurmaCliente(){
        System.out.println("RELACIONAMENTO DE TURMA E CLIENTE");
        System.out.println("RG do cliente:");
        String rg = this.input.next();
        Cliente c = this.academia.encontrarCliente(rg);
        System.out.println("Atividade:");
        String nomeAtividade = this.input.next();
        Atividade a = this.academia.encontrarAtividade(nomeAtividade);
        System.out.println("ID da turma:");
        String id = this.input.next();
        Turma t = this.academia.encontrarTurma(id, a);
        if (this.academia.relacionarTurmaCliente(t, c))
            System.out.println("Cliente incluído na turma.");
        else
            System.out.println("Erro.");
    }

    public void desrelacionarTurmaCliente() {
        System.out.println("DESFAZER RELACIONAMENTO DE TURMA E CLIENTE");
        System.out.println("RG do cliente:");
        String rg = this.input.next();
        Cliente c = this.academia.encontrarCliente(rg);
        System.out.println("Atividade:");
        String nomeAtividade = this.input.next();
        Atividade a = this.academia.encontrarAtividade(nomeAtividade);
        System.out.println("ID da turma:");
        String id = this.input.next();
        Turma t = this.academia.encontrarTurma(id, a);
        if (this.academia.desrelacionarTurmaCliente(t, c))
            System.out.println("Cliente removido da turma.");
        else
            System.out.println("Erro.");
    }

    public void relacionarTurmaInstrutor(){
        System.out.println("RELACIONAMENTO DE TURMA E INSTRUTOR");
        System.out.println("RG do instrutor:");
        String rg = this.input.next();
        Instrutor i = this.academia.encontrarInstrutor(rg);
        System.out.println("Atividade:");
        String nomeAtividade = this.input.next();
        Atividade a = this.academia.encontrarAtividade(nomeAtividade);
        System.out.println("ID da turma:");
        String id = this.input.next();
        Turma t = this.academia.encontrarTurma(id, a);
        if (this.academia.relacionarTurmaInstrutor(t, i))
            System.out.println("Instrutor associado à turma.");
        else
            System.out.println("Erro.");
    }

    public void desrelacionarTurmaInstrutor(){
        System.out.println("DESFAZER RELACIONAMENTO DE TURMA E INSTRUTOR");
        System.out.println("RG do instrutor:");
        String rg = this.input.next();
        Instrutor i = this.academia.encontrarInstrutor(rg);
        System.out.println("Atividade:");
        String nomeAtividade = this.input.next();
        Atividade a = this.academia.encontrarAtividade(nomeAtividade);
        System.out.println("ID da turma:");
        String id = this.input.next();
        Turma t = this.academia.encontrarTurma(id, a);
        if (this.academia.desrelacionarTurmaInstrutor(t, i))
            System.out.println("Instrutor desassociado da turma.");
        else
            System.out.println("Erro.");
    }

    public void verificarClientesPorTurma() {
        System.out.println("VERIFICAR CLIENTES DE UMA TURMA");
        System.out.println("Atividade:");
        String atividade = this.input.next();
        System.out.println("ID da turma:");
        String chave = this.input.next();
        boolean achou = false;
        for (Atividade a : this.academia.getAtividades()) {
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

    public void exibirAtividades() {
        System.out.println("EXIBIÇÃO DE ATIVIDADES");
        for (Atividade a : this.academia.getAtividades()) {
            System.out.println(a.toString());
        }
    }

    public void exibirClientes() {
        System.out.println("EXIBIÇÃO DE CLIENTES");
        for (Cliente c : this.academia.getClientes()) {
            if (c.isAtivo())
                System.out.println(c.toString());
        }
    }

    public void exibirInstrutores() {
        System.out.println("EXIBIÇÃO DE INSTRUTORES");
        for (Instrutor i : this.academia.getInstrutores()) {
            if (i.isAtivo())
                System.out.println(i.toString());
        }
    }

    public void exibirTurmasPorAtividade() {
        System.out.println("EXIBIÇÃO DE TURMAS POR ATIVIDADE");
        for (Atividade a : this.academia.getAtividades()) {
            System.out.println(a.toString());
            System.out.println("TURMAS:");
            for (Turma t : a.getTurmas()) {
                System.out.println(t.toString());
            }
        }
    }

    public String toString() {
        String ret = "Username: " + this.username + "\nSenha: " + this.senha + "\n";
        ret += super.toString();
        return ret;
    }

    public void clientesDeUmaAtividade(){
        System.out.println("CLIENTES DE UMA ATIVIDADE");
        System.out.println("Atividade:");
        String atividade = this.input.next();
        boolean achou = false;

        for(Atividade a : this.academia.getAtividades()) {
            if (a.getNome().equalsIgnoreCase(atividade)) {
                achou = true;
                if(a.quantidadeTurmas() == 0) {
                    System.out.println("A atividade ainda não tem turmas.");
                } else {
                    for (Turma t : a.getTurmas()) {
                        t.imprimirClientes();
                    }
                }
            }
        }

        if(!achou){
            System.out.println("Atividade inválida.");
        }
    }

    public void instrutoresDeUmaAtividade(){
        System.out.println("INSTRUTORES DE UMA ATIVIDADE");
        System.out.println("Atividade:");
        
        String atividade = this.input.next();
        boolean achou = false;

        for(Atividade a : this.academia.getAtividades()){
            if(a.getNome().equalsIgnoreCase(atividade)){
                achou = true;
                //TODO: avisar caso nao tenha instrutor
                for(Turma t : a.getTurmas()){
                    t.imprimirInstrutores();
                }
            }
        }

        if(!achou){
            System.out.println("Atividade inválida.");
        }
    }

    public void qtdClientesDeUmaAtividade(){
        System.out.println("QUANTIDADE DE CLIENTES QUE FAZEM UMA ATIVIDADE");
        System.out.println("Atividade:");
        
        String atividade = this.input.next();
        boolean achou = false;

        for(Atividade a : this.academia.getAtividades()){
            if(a.getNome().equalsIgnoreCase(atividade)){
                achou = true;
                System.out.println("Quantidade de clientes inscritos: " + a.quantosInscritos());
                break;
            }
        }

        if(!achou){
            System.out.println("Atividade inválida.");
        }
    }

    public void atividadeComMaisClientes(){
        System.out.println("ATIVIDADE COM MAIS CLIENTES");
        Atividade ativ = this.academia.atividadeComMaisInscritos();
        if(ativ != null) {
            System.out.println("Atividade: " + ativ.getNome());
            System.out.println("Número de clientes: " + ativ.quantosInscritos());
        }else{
            System.out.println("Nenhuma atividade registrada.");
        }
    }

    public void atividadeComMenosClientes(){
        System.out.println("ATIVIDADE COM MENOS CLIENTES");
        Atividade ativ = this.academia.atividadeComMenosInscritos();
        if(ativ != null) {
            System.out.println("Atividade: " + ativ.getNome());
            System.out.println("Número de clientes: " + ativ.quantosInscritos());
        }else{
            System.out.println("Nenhuma atividade registrada.");
        }
    }

    public void atividadeComMaiorPreco(){
        System.out.println("ATIVIDADE COM MAIOR PREÇO");
        Atividade ativ = this.academia.atividadeComMaiorPreco();
        if(ativ != null) {
            System.out.println("Atividade: " + ativ.getNome());
            System.out.println("Preco: " + ativ.getPreco());
        }else{
            System.out.println("Nenhuma atividade registrada.");
        }
    }

    public void atividadeComMenorPreco(){
        System.out.println("ATIVIDADE COM MENOR PRECO");
        Atividade ativ = this.academia.atividadeComMenorPreco();
        if(ativ != null) {
            System.out.println("Atividade: " + ativ.getNome());
            System.out.println("Preço: " + ativ.getPreco());
        }else{
            System.out.println("Nenhuma atividade registrada.");
        }
    }

    public void turmasDeUmCliente(){
        System.out.println("TURMAS DE UM CLIENTE");
        System.out.println("RG do cliente:");
        
        String rg = this.input.next();
        Cliente c = this.academia.encontrarCliente(rg);
        if(c != null) {
            if(c.quantidadeTurmas() > 0) {
                for (Turma t : c.getTurmas()) {
                    System.out.println("TURMA DE ID = " + t.getId());
                    System.out.println(t.toString());
                }
            }else{
                System.out.println("Cliente não está relacionado com nenhuma turma.");
            }
        }else{
            System.out.println("Cliente não registrado.");
        }
    }

    public void turmasDeUmInstrutor(){
        System.out.println("TURMAS DE UM INSTRUTOR");
        System.out.println("RG do instrutor:");
        
        String rg = this.input.next();
        Instrutor i = this.academia.encontrarInstrutor(rg);
        if(i != null){
            if(i.quantidadeTurmas() > 0) {
                for (Turma t : i.getTurmas()) {
                    System.out.println("TURMA DE ID = " + t.getId());
                    System.out.println(t.toString());
                }
            }else{
                System.out.println("Instrutor não está relacionado com nenhuma turma.");
            }
        }else{
            System.out.println("Instrutor nao registrado.");
        }
    }

    public void incluirInstrutor(){
        if (!this.permissoes.equals(Permissoes.ADMIN)) {
            System.out.println("Essa operação é permitida somente para administradores.");
            return;
        }
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
        if (!this.permissoes.equals(Permissoes.ADMIN)) {
            System.out.println("Essa operação é permitida somente para administradores.");
            return;
        }
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
        if (!this.permissoes.equals(Permissoes.ADMIN)) {
            System.out.println("Essa operação é permitida somente para administradores.");
            return;
        }
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

    public void incluirUsuario(ArrayList<Gerenciador> gerenciadores){
        if (!this.permissoes.equals(Permissoes.ADMIN)) {
            System.out.println("Essa operação é permitida somente para administradores.");
            return;
        }
        System.out.println("INCLUSÃO DE USUÁRIOS");
        String username, senha;
        System.out.println("Username:");
        username = this.input.next();
        System.out.println("Senha:");
        senha = this.input.next();
        Gerenciador gerenciador = new Gerenciador(username, senha);
        gerenciadores.add(gerenciador);
        System.out.println("Usuário incluído.");
    }

    public void alterarUsuario(ArrayList<Gerenciador> gerenciadores){
        if (!this.permissoes.equals(Permissoes.ADMIN)) {
            System.out.println("Essa operação é permitida somente para administradores.");
            return;
        }
        System.out.println("ALTERAÇÃO DE USUÁRIOS");
        String username, senha;
        System.out.println("Username:");

        username = this.input.next();
        boolean achou = false;
        for (Gerenciador u : gerenciadores) {
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

    public void excluirUsuario(ArrayList<Gerenciador> gerenciadores){
        if (!this.permissoes.equals(Permissoes.ADMIN)) {
            System.out.println("Essa operação é permitida somente para administradores.");
            return;
        }
        System.out.println("EXCLUSÃO DE USUÁRIOS");
        String username, senha;
        System.out.println("Username:");

        username = this.input.next();
        boolean achou = false;
        for (Gerenciador u : gerenciadores) {
            if (u.getUsername().equals(username)) {
                achou = true;
                gerenciadores.remove(u);
                System.out.println("Usuário excluído.");
                break;
            }
        }
        if (!achou) {
            System.out.println("Usuário não encontrado no sistema.");
        }
    }

    public void imprimirUsuarios(ArrayList<Gerenciador> gerenciadores) {
        if (!this.permissoes.equals(Permissoes.ADMIN)) {
            System.out.println("Essa operação é permitida somente para administradores.");
            return;
        }
        for (Gerenciador u : gerenciadores) {
            System.out.println(u.toString());
        }
    }
}