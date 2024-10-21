package ProjetoTarefas;

import java.time.LocalDate;

public class Principal {
	
	public static void main(String[] args) {
		
		GerenciamentoTarefas gerenciador = new GerenciamentoTarefas();
		
		Usuario usuario1 = new Usuario("Alice", "alice@exemplo.com");
		Usuario usuario2 = new Usuario("Bruno", "bruno@exemplo.com");
		
		gerenciador.cadastrarUsuario(usuario1);
		gerenciador.cadastrarUsuario(usuario2);
		
		Tarefas tarefa1 = new Tarefas("Estudar Java", "Estudar conceitos de POO", LocalDate.of(2024, 10, 16));
		Tarefas tarefa2 = new Tarefas("Fazer exercícios", "Praticar exercícios de lógica", LocalDate.of(2024, 10, 17));
		
		usuario1.adicionarTarefa(tarefa1);
		usuario1.adicionarTarefa(tarefa2);
		
		System.out.println("Tarefas de Alice: ");
		gerenciador.exibirTarefas("alice@exemplo");
		
		gerenciador.marcarTarefaComoConcluida("alice@exemplo.com", "Estudar Java");
		
		System.out.println("\nTarefas de Alice após marcar uma como concluída: ");
		gerenciador.exibirTarefas("alice@exemplo.com");
	}
}
