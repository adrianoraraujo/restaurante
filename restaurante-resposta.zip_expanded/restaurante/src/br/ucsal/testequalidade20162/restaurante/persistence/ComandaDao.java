package br.ucsal.testequalidade20162.restaurante.persistence;

import java.util.ArrayList;
import java.util.List;

import br.ucsal.testequalidade20162.restaurante.domain.Comanda;
import br.ucsal.testequalidade20162.restaurante.exception.RegistroNaoEncontrado;

public class ComandaDao {

	private static final String MENS_COMANDA_NAO_ENCONTRADA = "Comanda não encontrada (código = %d).";
	
	public List<Comanda> itens = new ArrayList<>();

	public void incluir(Comanda comanda) {
		itens.add(comanda);
	}

	public Comanda obterPorCodigo(Integer codigo) throws RegistroNaoEncontrado {
		for (Comanda comanda : itens) {
			if (comanda.getCodigo().equals(codigo)) {
				return comanda;
			}
		}
		throw new RegistroNaoEncontrado(String.format(MENS_COMANDA_NAO_ENCONTRADA, codigo));
	}

}
