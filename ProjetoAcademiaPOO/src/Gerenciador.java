import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
        System.out.println("INCLUSAO DE CLIENTE");
        String nome, endereco, telefone, dataNascimento;
        System.out.println("Nome:");
        nome = this.input.next();
        System.out.println("Endereco:");
        endereco = this.input.next();
        System.out.println("Telefone:");
        telefone = this.input.next();
        System.out.println("Data de nascimento:");
        dataNascimento = this.input.next();
        System.out.println("RG:");
        String rg = this.input.next();
        Cliente cliente = new Cliente(rg, nome, endereco, telefone, dataNascimento, true);
        if (this.academia.incluirCliente(cliente)) {
            System.out.println("Cliente incluido.");
        } else {
            System.out.println("Ja existe um cliente com esse RG.");
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
            System.out.println("Cliente nao encontrado no sistema.");
        }
    }

    public void alterarCliente(){
        System.out.println("ALTERACAO DOS DADOS DO CLIENTE");
        System.out.println("RG do cliente:");
        String rg = this.input.next();
        Cliente antigo = this.academia.encontrarCliente(rg);
        Cliente novo = new Cliente();
        System.out.println("Mudar nome?");
        String nome = this.input.next();
        novo.setNome(nome);
        System.out.println("Mudar endereco?");
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
            System.out.println("Cliente nao encontrado no sistema.");
    }

    public void incluirAtividade(){
        System.out.println("INCLUSÃƒO DE ATIVIDADE");
        String nome;
        float preco;
        System.out.println("Nome:");
        nome = this.input.next();
        System.out.println("Preco:");
        preco = this.input.nextFloat();
        Atividade atividade = new Atividade(nome, preco);
        if (this.academia.incluirAtividade(atividade))
            System.out.println("Atividade incluÃ­da.");
        else
            System.out.println("Essa atividade jÃ¡ existe.");
    }

    public void excluirAtividade(){
        System.out.println("EXCLUSÃƒO DE ATIVIDADES");
        System.out.println("Nome da atividade:");
        String nome = this.input.next();
        Atividade a = this.academia.encontrarAtividade(nome);
        if (this.academia.excluirAtividade(a))
            System.out.println("Atividade excluÃ­da.");
        else
            System.out.println("Atividade nÃ£o existe no sistema.");
    }

    public void alterarAtividade(){
        System.out.println("ALTERAÃ‡ÃƒO DE ATIVIDADE");
        System.out.println("Nome da atividade:");
        String atividade = this.input.next();
        Atividade antiga = this.academia.encontrarAtividade(atividade);
        Atividade nova = new Atividade();
        System.out.println("Mudar preÃ§o?");
        float preco = this.input.nextFloat();
        nova.setPreco(preco);
        nova.setNome(atividade);
        if (this.academia.alterarAtividade(antiga, nova))
            System.out.println("Atividade alterada.");
        else
            System.out.println("Atividade nÃ£o encontrada no sistema.");
    }

    public void incluirTurma(){
        System.out.println("CRIAÃ‡ÃƒO DE TURMA");
        System.out.println("Atividade:");
        String atividade = this.input.next();
        Atividade a = this.academia.encontrarAtividade(atividade);
        System.out.println("HorÃ¡rio:");
        String horario = this.input.next();
        System.out.println("MÃ¡ximo de pessoas:");
        int maximo = this.input.nextInt();
        System.out.println("ID:");
        String id = this.input.next();
        Turma turma = new Turma(horario, a.getPreco(), maximo, id);
        if (this.academia.incluirTurma(turma, a))
            System.out.println("Turma incluÃ­da.");
        else
            System.out.println("Turma jÃ¡ existe ou atividade nÃ£o existe.");
    }

    public void excluirTurma(){
        System.out.println("EXCLUSÃƒO DE TURMAS");
        System.out.println("Nome da atividade:");
        String nome = this.input.next();
        Atividade a = this.academia.encontrarAtividade(nome);
        System.out.println("ID da turma:");
        String id = this.input.next();
        Turma t = this.academia.encontrarTurma(id, a);
        if (this.academia.excluirTurma(t, a))
            System.out.println("Turma excluÃ­da.");
        else
            System.out.println("Turma ou atividade nÃ£o existe no sistema.");
    }

    public void alterarTurma(){
        System.out.println("ALTERAÃ‡ÃƒO DE TURMA");
        System.out.println("Atividade:");
        String atividade = this.input.next();
        Atividade atividade1 = this.academia.encontrarAtividade(atividade);
        System.out.println("ID da turma:");
        String id = this.input.next();
        Turma antiga = this.academia.encontrarTurma(id, atividade1);
        Turma nova = new Turma();
        System.out.println("Mudar horÃ¡rio?");
        String horario = this.input.next();
        System.out.println("Mudar mÃ¡ximo de pessoas?");
        int max = this.input.nextInt();
        nova.setMaximoPessoas(max);
        nova.setHorario(horario);
        nova.setId(id);
        if (this.academia.alterarTurma(antiga, nova, atividade1))
            System.out.println("Turma alterada.");
        else
            System.out.println("Turma ou atividade nÃ£o encontrada no sistema.");
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
            System.out.println("Cliente incluÃ­do na turma.");
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
            System.out.println("Instrutor associado Ã  turma.");
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
                            System.out.println("A turma ainda nÃ£o tem clientes.");
                        } else t.imprimirClientes();
                    }
                }
            }
        }
        if (!achou) {
            System.out.println("Atividade ou turma invÃ¡lidas.");
        }
    }

    public void exibirAtividades() {
        System.out.println("EXIBIÃ‡ÃƒO DE ATIVIDADES");
        for (Atividade a : this.academia.getAtividades()) {
            System.out.println(a.toString());
        }
    }

    public void exibirClientes() {
        System.out.println("EXIBIÃ‡ÃƒO DE CLIENTES");
        for (Cliente c : this.academia.getClientes()) {
            if (c.isAtivo())
                System.out.println(c.toString());
        }
    }

    public void exibirInstrutores() {
        System.out.println("EXIBIÃ‡ÃƒO DE INSTRUTORES");
        for (Instrutor i : this.academia.getInstrutores()) {
            if (i.isAtivo())
                System.out.println(i.toString());
        }
    }

    public void exibirTurmasPorAtividade() {
        System.out.println("EXIBIÃ‡ÃƒO DE TURMAS POR ATIVIDADE");
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
                    System.out.println("A atividade ainda nÃ£o tem turmas.");
                } else {
                    for (Turma t : a.getTurmas()) {
                        t.imprimirClientes();
                    }
                }
            }
        }

        if(!achou){
            System.out.println("Atividade invÃ¡lida.");
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
            System.out.println("Atividade invÃ¡lida.");
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
            System.out.println("Atividade invÃ¡lida.");
        }
    }

    public void atividadeComMaisClientes(){
        System.out.println("ATIVIDADE COM MAIS CLIENTES");
        Atividade ativ = this.academia.atividadeComMaisInscritos();
        if(ativ != null) {
            System.out.println("Atividade: " + ativ.getNome());
            System.out.println("NÃºmero de clientes: " + ativ.quantosInscritos());
        }else{
            System.out.println("Nenhuma atividade registrada.");
        }
    }

    public void atividadeComMenosClientes(){
        System.out.println("ATIVIDADE COM MENOS CLIENTES");
        Atividade ativ = this.academia.atividadeComMenosInscritos();
        if(ativ != null) {
            System.out.println("Atividade: " + ativ.getNome());
            System.out.println("NÃºmero de clientes: " + ativ.quantosInscritos());
        }else{
            System.out.println("Nenhuma atividade registrada.");
        }
    }

    public void atividadeComMaiorPreco(){
        System.out.println("ATIVIDADE COM MAIOR PREÃ‡O");
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
            System.out.println("PreÃ§o: " + ativ.getPreco());
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
                System.out.println("Cliente nÃ£o estÃ¡ relacionado com nenhuma turma.");
            }
        }else{
            System.out.println("Cliente nÃ£o registrado.");
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
                System.out.println("Instrutor nÃ£o estÃ¡ relacionado com nenhuma turma.");
            }
        }else{
            System.out.println("Instrutor nao registrado.");
        }
    }

    public void incluirInstrutor(){
        if (!this.permissoes.equals(Permissoes.ADMIN)) {
            System.out.println("Essa operaÃ§Ã£o Ã© permitida somente para administradores.");
            return;
        }
        System.out.println("INCLUSÃƒO DE INSTRUTOR");
        String nome, endereco, telefone, dataNascimento;
        float salario;
        ArrayList<String> areas = new ArrayList<>();

        System.out.println("RG:");
        String rg = this.input.next();
        System.out.println("Nome:");
        nome = this.input.next();
        System.out.println("EndereÃ§o:");
        endereco = this.input.next();
        System.out.println("Telefone:");
        telefone = this.input.next();
        System.out.println("Data de nascimento:");
        dataNascimento = this.input.next();
        System.out.println("Salario:");
        salario = this.input.nextFloat();
        System.out.println("Em quantas Ã¡reas atua?");
        int quantidade = this.input.nextInt();
        System.out.println("Digite as Ã¡reas:");
        for (int i = 0; i < quantidade; i++) {
            areas.add(this.input.next());
        }
        Instrutor instrutor = new Instrutor(rg, nome, endereco, telefone, dataNascimento, true, salario, areas);
        if (this.academia.incluirInstrutor(instrutor))
            System.out.println("Instrutor incluÃ­do.");
        else
            System.out.println("JÃ¡ existe um instrutor com esse RG no sistema.");
    }

    public void desativarInstrutor() {
        if (!this.permissoes.equals(Permissoes.ADMIN)) {
            System.out.println("Essa operaÃ§Ã£o Ã© permitida somente para administradores.");
            return;
        }
        System.out.println("DESATIVAR INSTRUTOR");
        System.out.println("RG do instrutor:");

        String rg = this.input.next();
        Instrutor i = this.academia.encontrarInstrutor(rg);
        if (this.academia.desativarInstrutor(i)) {
            System.out.println("Instrutor desativado.");
        } else {
            System.out.println("Instrutor nÃ£o encontrado no sistema.");
        }
    }

    public void alterarInstrutor(){
        if (!this.permissoes.equals(Permissoes.ADMIN)) {
            System.out.println("Essa operaÃ§Ã£o Ã© permitida somente para administradores.");
            return;
        }
        System.out.println("ALTERAÃ‡ÃƒO DOS DADOS DO INSTRUTOR");
        System.out.println("RG do instrutor:");

        String rg = this.input.next();
        Instrutor antigo = this.academia.encontrarInstrutor(rg);
        Instrutor novo = new Instrutor();
        novo.setRG(rg);
        System.out.println("Mudar nome?");
        String nome = this.input.next();
        novo.setNome(nome);
        System.out.println("Mudar endereÃ§o?");
        String endereco = this.input.next();
        novo.setEndereco(endereco);
        System.out.println("Mudar telefone?");
        String telefone = this.input.next();
        novo.setTelefone(telefone);
        System.out.println("Mudar data de nascimento?");
        String dataNascimento = this.input.next();
        novo.setDataNascimento(dataNascimento);
        System.out.println("Mudar salÃ¡rio?");
        float salario = this.input.nextFloat();
        novo.setSalario(salario);
        System.out.println("Mudar quantidade de Ã¡reas?");
        int quantidade = this.input.nextInt();
        System.out.println("Digite as Ã¡reas:");
        ArrayList<String> areas = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            areas.add(this.input.next());
        }
        novo.setAreas(areas);
        if (this.academia.alterarInstutor(antigo, novo))
            System.out.println("Instrutor alterado.");
        else
            System.out.println("Instrutor nÃ£o encontrado no sistema.");
    }

    public void incluirUsuario(ArrayList<Gerenciador> gerenciadores){
        if (!this.permissoes.equals(Permissoes.ADMIN)) {
            System.out.println("Essa operaÃ§Ã£o Ã© permitida somente para administradores.");
            return;
        }
        System.out.println("INCLUSÃƒO DE USUÃ�RIOS");
        String username, senha;
        System.out.println("Username:");
        username = this.input.next();
        System.out.println("Senha:");
        senha = this.input.next();
        Gerenciador gerenciador = new Gerenciador(username, senha);
        gerenciadores.add(gerenciador);
        System.out.println("UsuÃ¡rio incluÃ­do.");
    }

    public void alterarUsuario(ArrayList<Gerenciador> gerenciadores){
        if (!this.permissoes.equals(Permissoes.ADMIN)) {
            System.out.println("Essa operaÃ§Ã£o Ã© permitida somente para administradores.");
            return;
        }
        System.out.println("ALTERAÃ‡ÃƒO DE USUÃ�RIOS");
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
                System.out.println("UsuÃ¡rio alterado.");
            }
        }
        if (!achou) {
            System.out.println("UsuÃ¡rio nÃ£o encontrado no sistema.");
        }
    }

    public void excluirUsuario(ArrayList<Gerenciador> gerenciadores){
        if (!this.permissoes.equals(Permissoes.ADMIN)) {
            System.out.println("Essa operaÃ§Ã£o Ã© permitida somente para administradores.");
            return;
        }
        System.out.println("EXCLUSÃƒO DE USUÃ�RIOS");
        String username, senha;
        System.out.println("Username:");

        username = this.input.next();
        boolean achou = false;
        for (Gerenciador u : gerenciadores) {
            if (u.getUsername().equals(username)) {
                achou = true;
                gerenciadores.remove(u);
                System.out.println("UsuÃ¡rio excluÃ­do.");
                break;
            }
        }
        if (!achou) {
            System.out.println("UsuÃ¡rio nÃ£o encontrado no sistema.");
        }
    }

    public void imprimirUsuarios(ArrayList<Gerenciador> gerenciadores) {
        if (!this.permissoes.equals(Permissoes.ADMIN)) {
            System.out.println("Essa operaÃ§Ã£o Ã© permitida somente para administradores.");
            return;
        }
        for (Gerenciador u : gerenciadores) {
            System.out.println(u.toString());
        }
    }
    
    public ArrayList<Cliente> buscaClientePorRG(String rg){
    	return academia.getClientes().stream().filter(c -> c.getRg().contains(rg)).collect(Collectors.toCollection(ArrayList::new));
    }
    
    public ArrayList<Cliente> buscaClientePorNome(String nome){
    	return academia.getClientes().stream().filter(c -> c.getNome().contains(nome)).collect(Collectors.toCollection(ArrayList::new));
    }
    
    public ArrayList<Cliente> buscaClientePorEndereco(String endereco){
    	return academia.getClientes().stream().filter(c -> c.getEndereco().contains(endereco)).collect(Collectors.toCollection(ArrayList::new));
    }
    
    public ArrayList<Cliente> buscaClientePorTelefone(String telefone){
    	return academia.getClientes().stream().filter(c -> c.getTelefone().contains(telefone)).collect(Collectors.toCollection(ArrayList::new));
    }
    
    public ArrayList<Cliente> buscaClientePorDataNascimento(String dataNascimento){
    	return academia.getClientes().stream().filter(c -> c.getDataNascimento().contains(dataNascimento)).collect(Collectors.toCollection(ArrayList::new));
    }
    
    public ArrayList<Cliente> buscaClientePorAtivo(boolean ativo){
    	return academia.getClientes().stream().filter(c -> c.isAtivo() == ativo).collect(Collectors.toCollection(ArrayList::new));
    }
    
    public ArrayList<Instrutor> buscaInstrutorPorRG(String rg){
    	return academia.getInstrutores().stream().filter(c -> c.getRg().contains(rg)).collect(Collectors.toCollection(ArrayList::new));
    }
    
    public ArrayList<Instrutor> buscaInstrutorPorNome(String nome){
    	return academia.getInstrutores().stream().filter(c -> c.getNome().contains(nome)).collect(Collectors.toCollection(ArrayList::new));
    }
    
    public ArrayList<Instrutor> buscaInstrutorPorEndereco(String endereco){
    	return academia.getInstrutores().stream().filter(c -> c.getEndereco().contains(endereco)).collect(Collectors.toCollection(ArrayList::new));
    }
    
    public ArrayList<Instrutor> buscaInstrutorPorTelefone(String telefone){
    	return academia.getInstrutores().stream().filter(c -> c.getTelefone().contains(telefone)).collect(Collectors.toCollection(ArrayList::new));
    }
    
    public ArrayList<Instrutor> buscaInstrutorPorDataNascimento(String dataNascimento){
    	return academia.getInstrutores().stream().filter(c -> c.getDataNascimento().contains(dataNascimento)).collect(Collectors.toCollection(ArrayList::new));
    }
    
    public ArrayList<Instrutor> buscaInstrutorPorAtivo(boolean ativo){
    	return academia.getInstrutores().stream().filter(c -> c.isAtivo() == ativo).collect(Collectors.toCollection(ArrayList::new));
    }
    
    public ArrayList<Instrutor> buscaInstrutorPorSalario(float salario){
    	return academia.getInstrutores().stream().filter(c -> c.getSalario() == salario).collect(Collectors.toCollection(ArrayList::new));
    }
    
    public ArrayList<Instrutor> buscaInstrutorPorAreas(ArrayList<String> areas){
    	return academia.getInstrutores().stream().filter(c -> c.getAreas() == areas).collect(Collectors.toCollection(ArrayList::new));
    }
    
    public ArrayList<Instrutor> buscaInstrutorPorArea(String area){
    	return academia.getInstrutores().stream().filter(c -> c.getAreas().contains(area)).collect(Collectors.toCollection(ArrayList::new));
    }
    
    public ArrayList<Atividade> buscaAtividadePorNome(String nome){
    	return academia.getAtividades().stream().filter(c -> c.getNome().contains(nome)).collect(Collectors.toCollection(ArrayList::new));
    }
    
    public ArrayList<Atividade> buscaAtividadePorPreco(float preco){
    	return academia.getAtividades().stream().filter(c -> c.getPreco() == preco).collect(Collectors.toCollection(ArrayList::new));
    }
    
    public ArrayList<Atividade> buscaAtividadePorTurmas(ArrayList<Turma> turmas){
    	return academia.getAtividades().stream().filter(c -> c.getTurmas() == turmas).collect(Collectors.toCollection(ArrayList::new));	
    }
    
    public ArrayList<Atividade> buscaAtividadePorTurma(Turma turma){
    	return academia.getAtividades().stream().filter(c -> c.getTurmas().contains(turma)).collect(Collectors.toCollection(ArrayList::new));	
    }
    
}