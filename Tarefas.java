package ProjetoTarefas;

import java.time.LocalDate;

public class Tarefas {
	
	private String nome;
	private String descricao;
	private boolean concluida;
	private LocalDate dataLimite;
	
	public Tarefas(String nome, String descricao, LocalDate dataLimite) {
		this.nome = nome;
		this.descricao = descricao;
		this.concluida = false;
		this.dataLimite = dataLimite;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public boolean isConcluida() {
		return concluida;
	}
	
	public void setConcluida(boolean concluida) {
		this.concluida = concluida;
	}
	
	public LocalDate getDataLimite() {
		return dataLimite;
	}
	
	public void setDataLimite(LocalDate dataLimite) {
		this.dataLimite = dataLimite;
	}
	
	public String toString() {
		return nome + " - " + (concluida ? "Concluída" : "Pendente") + 
				"(Limite: " + dataLimite + ")";
	}

}
