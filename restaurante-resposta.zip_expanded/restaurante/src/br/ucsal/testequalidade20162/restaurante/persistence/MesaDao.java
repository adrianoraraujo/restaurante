package br.ucsal.testequalidade20162.restaurante.persistence;

import java.util.ArrayList;
import java.util.List;

import br.ucsal.testequalidade20162.restaurante.domain.Mesa;
import br.ucsal.testequalidade20162.restaurante.exception.RegistroNaoEncontrado;

public class MesaDao {

	private static final String MESA_NAO_ENCONTRADA = "Mesa não encontrada (número = %d).";
	
	public List<Mesa> itens = new ArrayList<>();

	public void incluir(Mesa mesa) {
		itens.add(mesa);
	}

	public Mesa obterPorNumero(Integer numero) throws RegistroNaoEncontrado {
		for (Mesa mesa : itens) {
			if (mesa.getNumero().equals(numero)) {
				return mesa;
			}
		}
		throw new RegistroNaoEncontrado(String.format(MESA_NAO_ENCONTRADA, numero));
	}

}
