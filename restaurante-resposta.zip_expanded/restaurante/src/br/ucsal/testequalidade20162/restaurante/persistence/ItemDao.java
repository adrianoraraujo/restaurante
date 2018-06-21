package br.ucsal.testequalidade20162.restaurante.persistence;

import java.util.ArrayList;
import java.util.List;

import br.ucsal.testequalidade20162.restaurante.domain.Item;
import br.ucsal.testequalidade20162.restaurante.exception.RegistroNaoEncontrado;

public class ItemDao {

	private static final String ITEM_NAO_ENCONTRADO = "Item não encontrado (código = %d).";
	
	public List<Item> itens = new ArrayList<>();

	public void incluir(Item item) {
		itens.add(item);
	}

	public Item obterPorCodigo(Integer codigo) throws RegistroNaoEncontrado {
		for (Item item : itens) {
			if (item.getCodigo().equals(codigo)) {
				return item;
			}
		}
		throw new RegistroNaoEncontrado(String.format(ITEM_NAO_ENCONTRADO, codigo));
	}

}
