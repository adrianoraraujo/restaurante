package br.ucsal.testequalidade20162.restaurante.domain;

public class Item {

	public static Integer seq = 1;

	public Integer codigo;

	public String nome;

	public Double valorUnitario;

	public Item(String nome, Double valorUnitario) {
		super();
		definirCodigoItem();
		this.nome = nome;
		this.valorUnitario = valorUnitario;
	}

	public void definirCodigoItem() {
		seq++;
		this.codigo = seq;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Integer getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return "Item [codigo=" + codigo + ", nome=" + nome + ", valorUnitario=" + valorUnitario + "]";
	}

}
