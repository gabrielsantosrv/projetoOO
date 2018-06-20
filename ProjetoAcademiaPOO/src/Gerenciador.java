import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Gerenciador {
    protected static BaseDados academia = new BaseDados();
    
    private static Logavel loginAtual = null;

    public static void incluirCliente(String rg, String nome, String endereco, String telefone, String dataNascimento, Personal personal){
        System.out.println("INCLUSAO DE CLIENTE");
        Cliente cliente = new Cliente(rg, nome, endereco, telefone, dataNascimento, true, personal);
        if (academia.incluirCliente(cliente)) {
            System.out.println("Cliente incluido.");
        } else {
            System.out.println("Ja existe um cliente com esse RG.");
        }
    }

    public static void desativarCliente(String rg){
        System.out.println("DESATIVAR CLIENTE");
        Cliente c = academia.encontrarCliente(rg);
        if (academia.desativarCliente(c)) {
            System.out.println("Cliente desativado.");
        } else {
            System.out.println("Cliente nao encontrado no sistema.");
        }
    }

    public static void alterarCliente(String rg, String nome, String endereco, String telefone, String dataNascimento, Personal personal){
        System.out.println("ALTERACAO DOS DADOS DO CLIENTE");
        Cliente antigo = academia.encontrarCliente(rg);
        Cliente novo = new Cliente();
        novo.setNome(nome);
        novo.setEndereco(endereco);
        novo.setTelefone(telefone);
        novo.setDataNascimento(dataNascimento);
        novo.setRG(rg);
        novo.setPersonal(personal);
        if (academia.alterarCliente(antigo, novo))
            System.out.println("Cliente alterado.");
        else
            System.out.println("Cliente nao encontrado no sistema.");
    }

    public static void incluirAtividade(String nome, float preco){
        System.out.println("INCLUSÃƒO DE ATIVIDADE");
        Atividade atividade = new Atividade(nome, preco);
        if (academia.incluirAtividade(atividade))
            System.out.println("Atividade incluÃ­da.");
        else
            System.out.println("Essa atividade jÃ¡ existe.");
    }

    public static void excluirAtividade(String nome){
        System.out.println("EXCLUSÃƒO DE ATIVIDADES");
        Atividade a = academia.encontrarAtividade(nome);
        if (academia.excluirAtividade(a))
            System.out.println("Atividade excluÃ­da.");
        else
            System.out.println("Atividade nÃ£o existe no sistema.");
    }

    public static void alterarAtividade(String nome, float preco){
        System.out.println("ALTERAÃ‡ÃƒO DE ATIVIDADE");
        Atividade antiga = academia.encontrarAtividade(nome);
        Atividade nova = new Atividade();
        nova.setPreco(preco);
        nova.setNome(nome);
        if (academia.alterarAtividade(antiga, nova))
            System.out.println("Atividade alterada.");
        else
            System.out.println("Atividade nÃ£o encontrada no sistema.");
    }

    public static void incluirTurma(String atividade, String horario, int maximo){
        System.out.println("CRIAÃ‡ÃƒO DE TURMA");
        Atividade a = academia.encontrarAtividade(atividade);
        Turma turma = new Turma(horario, maximo, a);
        if (academia.incluirTurma(turma, a))
            System.out.println("Turma incluÃ­da.");
        else
            System.out.println("Turma jÃ¡ existe ou atividade nÃ£o existe.");
    }

    public static void excluirTurma(String nome, String id){
        System.out.println("EXCLUSÃƒO DE TURMAS");
        Atividade a = academia.encontrarAtividade(nome);
        Turma t = academia.encontrarTurma(id, a);
        if (academia.excluirTurma(t, a))
            System.out.println("Turma excluÃ­da.");
        else
            System.out.println("Turma ou atividade nÃ£o existe no sistema.");
    }

    public static void alterarTurma(String nomeAtividade, String id, String horario, int max){
        System.out.println("ALTERAÃ‡ÃƒO DE TURMA");
        Atividade atividade1 = academia.encontrarAtividade(nomeAtividade);
        Turma antiga = academia.encontrarTurma(id, atividade1);
        Turma nova = new Turma();
        nova.setMaximoPessoas(max);
        nova.setHorario(horario);
        nova.setId(id);
        if (academia.alterarTurma(antiga, nova, atividade1))
            System.out.println("Turma alterada.");
        else
            System.out.println("Turma ou atividade nÃ£o encontrada no sistema.");
    }

    public static void relacionarTurmaCliente(String rg, String nomeAtividade, String id){
        System.out.println("RELACIONAMENTO DE TURMA E CLIENTE");
        Cliente c = academia.encontrarCliente(rg);
        Atividade a = academia.encontrarAtividade(nomeAtividade);
        Turma t = academia.encontrarTurma(id, a);
        if (academia.relacionarTurmaCliente(t, c))
            System.out.println("Cliente incluÃ­do na turma.");
        else
            System.out.println("Erro.");
    }

    public static void desrelacionarTurmaCliente(String rg, String nomeAtividade, String id) {
        System.out.println("DESFAZER RELACIONAMENTO DE TURMA E CLIENTE");
        Cliente c = academia.encontrarCliente(rg);
        Atividade a = academia.encontrarAtividade(nomeAtividade);
        Turma t = academia.encontrarTurma(id, a);
        if (academia.desrelacionarTurmaCliente(t, c))
            System.out.println("Cliente removido da turma.");
        else
            System.out.println("Erro.");
    }

    public static void relacionarTurmaInstrutor(String rg, String nomeAtividade, String id){
        System.out.println("RELACIONAMENTO DE TURMA E INSTRUTOR");
        Instrutor i = academia.encontrarInstrutor(rg);
        Atividade a = academia.encontrarAtividade(nomeAtividade);
        Turma t = academia.encontrarTurma(id, a);
        if (academia.relacionarTurmaInstrutor(t, i))
            System.out.println("Instrutor associado Ã  turma.");
        else
            System.out.println("Erro.");
    }

    public static void desrelacionarTurmaInstrutor(String rg, String nomeAtividade, String id){
        System.out.println("DESFAZER RELACIONAMENTO DE TURMA E INSTRUTOR");
        Instrutor i = academia.encontrarInstrutor(rg);
        Atividade a = academia.encontrarAtividade(nomeAtividade);
        Turma t = academia.encontrarTurma(id, a);
        if (academia.desrelacionarTurmaInstrutor(t, i))
            System.out.println("Instrutor desassociado da turma.");
        else
            System.out.println("Erro.");
    }

    public static ArrayList<Cliente> verificarClientesPorTurma(String atividade, String chave) {
        System.out.println("VERIFICAR CLIENTES DE UMA TURMA");
        Optional<Atividade> ati = academia.getAtividades().stream().filter( a -> atividade.equals(a.getNome())).findFirst();
        if(ati.isPresent()){
        	Optional<Turma> turma = ati.get().getTurmas().stream().filter(t -> chave.equals(t.getId())).findFirst();
        	if(turma.isPresent())
        		return turma.get().getClientes();
        }
        return new ArrayList<>();
    }

    public static ArrayList<Atividade> exibirAtividades() {
        System.out.println("EXIBIÃ‡ÃƒO DE ATIVIDADES");
        for (Atividade a : academia.getAtividades()) {
            System.out.println(a.toString());
        }
        return academia.getAtividades();
    }

    public static ArrayList<Cliente> exibirClientes() {
        System.out.println("EXIBIÃ‡ÃƒO DE CLIENTES");
        for (Cliente c : academia.getClientes()) {
            if (c.isAtivo())
                System.out.println(c.toString());
        }
        return academia.getClientes();
    }

    public static ArrayList<Instrutor> exibirInstrutores() {
        System.out.println("EXIBIÃ‡ÃƒO DE INSTRUTORES");
        for (Instrutor i : academia.getInstrutores()) {
            if (i.isAtivo())
                System.out.println(i.toString());
        }
        return academia.getInstrutores();
    }

    public static void exibirTurmasPorAtividade() {
        System.out.println("EXIBIÃ‡ÃƒO DE TURMAS POR ATIVIDADE");
        for (Atividade a : academia.getAtividades()) {
            System.out.println(a.toString());
            System.out.println("TURMAS:");
            for (Turma t : a.getTurmas()) {
                System.out.println(t.toString());
            }
        }
    }

    public static ArrayList<Cliente> clientesDeUmaAtividade(String atividade){
        System.out.println("CLIENTES DE UMA ATIVIDADE");
        ArrayList<Cliente> retorno = new ArrayList<>();
        Optional<Atividade> ati = academia.getAtividades().stream().filter(a -> atividade.equals(a.getNome())).findFirst();
        if(ati.isPresent()){
        	ati.get().getTurmas().forEach(t -> retorno.addAll(t.getClientes()));
        }
        return retorno;
    }

    public static ArrayList<Instrutor> instrutoresDeUmaAtividade(String atividade){
        System.out.println("INSTRUTORES DE UMA ATIVIDADE");
        ArrayList<Instrutor> retorno = new ArrayList<>();
        Optional<Atividade> ati = academia.getAtividades().stream().filter(a -> atividade.equals(a.getNome())).findFirst();
        if(ati.isPresent()){
        	ati.get().getTurmas().forEach(t -> retorno.addAll(t.getInstrutores()));
        }
        return retorno;
    }

    public static int qtdClientesDeUmaAtividade(String atividade){
        System.out.println("QUANTIDADE DE CLIENTES QUE FAZEM UMA ATIVIDADE");
        Optional<Atividade> ati = academia.getAtividades().stream().filter(a -> atividade.equals(a.getNome())).findFirst();
        if(ati.isPresent()){
        	return ati.get().quantosInscritos();
        }
        return 0;
    }

    public static void atividadeComMaisClientes(){
        System.out.println("ATIVIDADE COM MAIS CLIENTES");
        Atividade ativ = academia.atividadeComMaisInscritos();
        if(ativ != null) {
            System.out.println("Atividade: " + ativ.getNome());
            System.out.println("NÃºmero de clientes: " + ativ.quantosInscritos());
        }else{
            System.out.println("Nenhuma atividade registrada.");
        }
    }

    public static void atividadeComMenosClientes(){
        System.out.println("ATIVIDADE COM MENOS CLIENTES");
        Atividade ativ = academia.atividadeComMenosInscritos();
        if(ativ != null) {
            System.out.println("Atividade: " + ativ.getNome());
            System.out.println("NÃºmero de clientes: " + ativ.quantosInscritos());
        }else{
            System.out.println("Nenhuma atividade registrada.");
        }
    }

    public static void atividadeComMaiorPreco(){
        System.out.println("ATIVIDADE COM MAIOR PREÃ‡O");
        Atividade ativ = academia.atividadeComMaiorPreco();
        if(ativ != null) {
            System.out.println("Atividade: " + ativ.getNome());
            System.out.println("Preco: " + ativ.getPreco());
        }else{
            System.out.println("Nenhuma atividade registrada.");
        }
    }

    public static void atividadeComMenorPreco(){
        System.out.println("ATIVIDADE COM MENOR PRECO");
        Atividade ativ = academia.atividadeComMenorPreco();
        if(ativ != null) {
            System.out.println("Atividade: " + ativ.getNome());
            System.out.println("PreÃ§o: " + ativ.getPreco());
        }else{
            System.out.println("Nenhuma atividade registrada.");
        }
    }

    public static ArrayList<Turma> turmasDeUmCliente(String rg){
        System.out.println("TURMAS DE UM CLIENTE");
        Cliente c = academia.encontrarCliente(rg);
        if(c != null){
        	return c.getTurmas();
        }else{
            System.out.println("Cliente nÃ£o registrado.");
        }
        return new ArrayList<>();
    }

    public static ArrayList<Turma> turmasDeUmInstrutor(String rg){
        System.out.println("TURMAS DE UM INSTRUTOR");
        Instrutor i = academia.encontrarInstrutor(rg);
        if(i != null){
        	return i.getTurmas();
        }else{
            System.out.println("Instrutor nao registrado.");
        }
		return new ArrayList<>();
    }

    public static void incluirInstrutorDiario(Logavel login,String rg, String nome, String endereco, String telefone, String dataNascimento, float salario, int diasTrabalhados, ArrayList<String> areas){
        if (!login.getPermissoes() .equals(Permissoes.ADMIN)) {
            System.out.println("Essa operaÃ§Ã£o Ã© permitida somente para administradores.");
            return;
        }
        System.out.println("INCLUSÃƒO DE INSTRUTOR");
        Instrutor instrutor = new InstrutorPorDia(rg, nome, endereco, telefone, dataNascimento, true, areas, diasTrabalhados, salario);
        if (academia.incluirInstrutor(instrutor))
            System.out.println("Instrutor incluÃ­do.");
        else
            System.out.println("JÃ¡ existe um instrutor com esse RG no sistema.");
    }
    
    public static void incluirInstrutorHorario(Logavel login, String rg, String nome, String endereco, String telefone, String dataNascimento, float salario, float horas, ArrayList<String> areas){
      if (!login.getPermissoes().equals(Permissoes.ADMIN)) {
          System.out.println("Essa operaÃ§Ã£o Ã© permitida somente para administradores.");
          return;
      }
      System.out.println("INCLUSÃƒO DE INSTRUTOR");
      Instrutor instrutor = new InstrutorPorHora(rg, nome, endereco, telefone, dataNascimento, true, areas, horas, salario);
      if (academia.incluirInstrutor(instrutor))
          System.out.println("Instrutor incluÃ­do.");
      else
          System.out.println("JÃ¡ existe um instrutor com esse RG no sistema.");
  }
    
    public static void incluirInstrutorPersonal(Logavel login, String rg, String nome, String endereco, String telefone, String dataNascimento, float salario, ArrayList<String> areas){
      if (!login.getPermissoes().equals(Permissoes.ADMIN)) {
          System.out.println("Essa operaÃ§Ã£o Ã© permitida somente para administradores.");
          return;
      }
      System.out.println("INCLUSÃƒO DE INSTRUTOR");
      Instrutor instrutor = new Personal(rg, nome, endereco, telefone, dataNascimento, true, areas, salario);
      if (academia.incluirInstrutor(instrutor))
          System.out.println("Instrutor incluÃ­do.");
      else
          System.out.println("JÃ¡ existe um instrutor com esse RG no sistema.");
  } 

    public static void desativarInstrutor(String rg) {
//        if (!permissoes.equals(Permissoes.ADMIN)) {
//            System.out.println("Essa operaÃ§Ã£o Ã© permitida somente para administradores.");
//            return;
//        }
        System.out.println("DESATIVAR INSTRUTOR");
        System.out.println("RG do instrutor:");

        Instrutor i = academia.encontrarInstrutor(rg);
        if (academia.desativarInstrutor(i)) {
            System.out.println("Instrutor desativado.");
        } else {
            System.out.println("Instrutor nÃ£o encontrado no sistema.");
        }
    }

    public static void alterarDadosInstrutor(Logavel login, String rg, String nome, String endereco, String telefone, String dataNascimento, float salario, ArrayList<String> areas){
        if (!login.getPermissoes().equals(Permissoes.ADMIN)) {
            System.out.println("Essa operaÃ§Ã£o Ã© permitida somente para administradores.");
            return;
        }
        System.out.println("ALTERAÃ‡ÃƒO DOS DADOS DO INSTRUTOR");
        System.out.println("RG do instrutor:");

        Instrutor instrutor = academia.encontrarInstrutor(rg);
        if (instrutor != null){
        	instrutor.setRG(rg);
        	instrutor.setNome(nome);
        	instrutor.setEndereco(endereco);
        	instrutor.setTelefone(telefone);
        	instrutor.setDataNascimento(dataNascimento);
        	instrutor.setAreas(areas);
            System.out.println("Instrutor alterado.");
        }else
            System.out.println("Instrutor nÃ£o encontrado no sistema.");
    }

    public static void incluirUsuario(Logavel login, String nome, String senha, Permissoes permissoes){
        if (!login.getPermissoes().equals(Permissoes.ADMIN)) {
            System.out.println("Essa operaÃ§Ã£o Ã© permitida somente para administradores.");
            return;
        }
        if(Permissoes.ADMIN.equals(permissoes)){
        	Admin admin = new Admin(nome, senha);
        	academia.insereLogin(admin);
        }else if(Permissoes.COMUM.equals(permissoes)){
        	Comum comum = new Comum(senha, senha);
        	academia.insereLogin(comum);
        }
    }
    
    //Funcao para chamar ao logar no Sistema
    public static boolean logar(String usuario, String senha){
    	for(Logavel l : academia.getLogins()){
    		if(l.logar(usuario, senha)){
    			loginAtual = l;
    			return true;
    		}
    	}
    	return false;
    }
    
    public static void deslogar(){
    	loginAtual = null;
    }
    
    public static Logavel getLoginAtual(){
    	return loginAtual;
    }

//    public static void alterarUsuario(ArrayList<Gerenciador> gerenciadores, String nome, String novoNome, String novaSenha){
//        if (!permissoes.equals(Permissoes.ADMIN)) {
//            System.out.println("Essa operaÃ§Ã£o Ã© permitida somente para administradores.");
//            return;
//        }
//        System.out.println("ALTERAÃ‡ÃƒO DE USUÃ�RIOS");
//
//        boolean achou = false;
//        for (Gerenciador u : gerenciadores) {
//            if (u.getUsername().equals(nome)) {
//                achou = true;
//                System.out.println("Novo username:");
//                u.setUsername(novoNome);
//                System.out.println("Nova senha:");
//                u.setSenha(novaSenha);
//                System.out.println("UsuÃ¡rio alterado.");
//            }
//        }
//        if (!achou) {
//            System.out.println("UsuÃ¡rio nÃ£o encontrado no sistema.");
//        }
//    }

    public static void excluirUsuario(Logavel login,ArrayList<Gerenciador> gerenciadores, String nome){
        if (!login.getPermissoes().equals(Permissoes.ADMIN)) {
            System.out.println("Essa operaÃ§Ã£o Ã© permitida somente para administradores.");
            return;
        }
        System.out.println("EXCLUSÃƒO DE USUÃ�RIOS");
        boolean achou = false;
        Optional<Logavel> findFirst = academia.getLogins().stream().filter(l -> l.getUsername().equals(nome)).findFirst();
        if(findFirst.isPresent()){
        	achou = true;
        	Logavel logavel = findFirst.get();
        	academia.removeLogin(logavel);
        }
        if (!achou) {
            System.out.println("UsuÃ¡rio nÃ£o encontrado no sistema.");
        }
    }

//    public static void imprimirUsuarios(ArrayList<Gerenciador> gerenciadores) {
//        //if (!permissoes.equals(Permissoes.ADMIN)) {
//            System.out.println("Essa operaÃ§Ã£o Ã© permitida somente para administradores.");
//            return;
//        //}
//        for (Gerenciador u : gerenciadores) {
//            System.out.println(u.toString());
//        }
//    }
    public static void relacionarPersonalCliente(String rgCliente, String rgPersonal){
    	Cliente cliente = academia.encontrarCliente(rgCliente);
    	Instrutor instrutor = academia.encontrarInstrutor(rgPersonal);
    	if(instrutor instanceof Personal){
    		Personal personal = (Personal) instrutor;
			cliente.setPersonal(personal);
			personal.adicionarCliente(cliente);    		
    	}else{
    		System.out.println("O instrutor selecionado não é um personal");
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