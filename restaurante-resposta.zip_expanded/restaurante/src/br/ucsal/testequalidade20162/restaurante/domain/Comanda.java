package br.ucsal.testequalidade20162.restaurante.domain;

import java.util.HashMap;
import java.util.Map;

import br.ucsal.testequalidade20162.restaurante.enums.SituacaoComandaEnum;
import br.ucsal.testequalidade20162.restaurante.enums.SituacaoMesaEnum;
import br.ucsal.testequalidade20162.restaurante.exception.ComandaFechadaException;
import br.ucsal.testequalidade20162.restaurante.exception.MesaOcupadaException;

public class Comanda {

	public static Integer seq = 1;

	public Integer codigo;

	public Mesa mesa;

	public Map<Item, Integer> itens = new HashMap<>();

	public SituacaoComandaEnum situacao = SituacaoComandaEnum.ABERTA;

	public Comanda(Mesa mesa) throws MesaOcupadaException {
		super();
		definirCodigoComanda();
		verificarSituacaoMesa(mesa);
		this.mesa = mesa;
	}

	public void definirCodigoComanda() {
		seq++;
		this.codigo = seq;
	}

	public void incluirItem(Item item, Integer qtd) throws ComandaFechadaException {
		Integer qtdAtual = 0;
		verificarComandaLivre();
		if (itens.containsKey(item)) {
			qtdAtual = itens.get(item);
		}
		qtdAtual += qtd;
		itens.put(item, qtdAtual);
	}

	public Double fechar() {
		situacao = SituacaoComandaEnum.FECHADA;
		return calcularTotal();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void verificarSituacaoMesa(Mesa mesa) throws MesaOcupadaException {
		if (mesa.getSituacao().equals(SituacaoMesaEnum.OCUPADA)) {
			throw new MesaOcupadaException(mesa.getNumero());
		}
	}

	public void verificarComandaLivre() throws ComandaFechadaException {
		if (situacao.equals(SituacaoComandaEnum.FECHADA)) {
			throw new ComandaFechadaException(codigo);
		}
	}

	public Double calcularTotal() {
		Double total = 0d;
		for (Item item : itens.keySet()) {
			total += item.getValorUnitario() * itens.get(item);
		}
		return total;
	}

}
