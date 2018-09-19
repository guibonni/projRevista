package br.com.projRevista.model;

public class Revista {
	private int id;
	private String nome;
	private int ano;
	private String mes;
	private int qtdPaginas;
	
	public Revista(int id, String nome, int ano, String mes, int qtdPaginas) {
		super();
		this.id = id;
		this.nome = nome;
		this.ano = ano;
		this.mes = mes;
		this.qtdPaginas = qtdPaginas;
	}
	
	public Revista() {
		
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public String getMes() {
		return mes;
	}
	
	public void setMes(String mes) {
		this.mes = mes;
	}
	
	public int getQtdPaginas() {
		return qtdPaginas;
	}
	
	public void setQtdPaginas(int qtdPaginas) {
		this.qtdPaginas = qtdPaginas;
	}
}
