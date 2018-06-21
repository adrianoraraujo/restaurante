package br.ucsal.testequalidade20162.restaurante.domain;

import br.ucsal.testequalidade20162.restaurante.enums.SituacaoMesaEnum;

public class Mesa {

	public SituacaoMesaEnum situacao = SituacaoMesaEnum.LIVRE;

	public Integer numero;

	public Mesa(Integer numero) {
		super();
		this.numero = numero;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public SituacaoMesaEnum getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoMesaEnum situacao) {
		this.situacao = situacao;
	}

	@Override
	public String toString() {
		return "Mesa [situacao=" + situacao + ", numero=" + numero + "]";
	}

}
