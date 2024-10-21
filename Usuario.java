package ProjetoTarefas;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private String nome;
	private String email;
	private List<Tarefas> tarefas;
	
	public Usuario(String nome, String email) {
		this.nome = nome;
		this.email = email;
		this.tarefas = new ArrayList<>();
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Tarefas> getTarefas(){
		return tarefas;
	}
	
	public void adicionarTarefa(Tarefas tarefa) {
		tarefas.add(tarefa);
	}
	
	public void removerTarefa(String nome) {
		tarefas.removeIf(tarefa -> tarefa.getNome().equals(nome));
	}
}
