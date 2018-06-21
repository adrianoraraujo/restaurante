package br.ucsal.testequalidade20162.restaurante.business;

import br.ucsal.testequalidade20162.restaurante.domain.Comanda;
import br.ucsal.testequalidade20162.restaurante.domain.Item;
import br.ucsal.testequalidade20162.restaurante.domain.Mesa;
import br.ucsal.testequalidade20162.restaurante.exception.ComandaFechadaException;
import br.ucsal.testequalidade20162.restaurante.exception.MesaOcupadaException;
import br.ucsal.testequalidade20162.restaurante.exception.RegistroNaoEncontrado;
import br.ucsal.testequalidade20162.restaurante.persistence.ComandaDao;
import br.ucsal.testequalidade20162.restaurante.persistence.ItemDao;
import br.ucsal.testequalidade20162.restaurante.persistence.MesaDao;

public class RestauranteBO {
	
	public ComandaDao comandaDao;
	
	private ItemDao itemDao;

	private MesaDao mesaDao;

	public RestauranteBO(ComandaDao comandaDao, ItemDao itemDao, MesaDao mesaDao){
		this.comandaDao = comandaDao;
		this.itemDao = itemDao;
		this.mesaDao = mesaDao;
	}
	
	public Integer abrirComanda(Integer numeroMesa) throws RegistroNaoEncontrado, MesaOcupadaException {
		Mesa mesa = mesaDao.obterPorNumero(numeroMesa);
		Comanda comanda = new Comanda(mesa);
		comandaDao.incluir(comanda);
		return comanda.getCodigo();
	}

	public void incluirItemComanda(Integer codigoComanda, Integer codigoItem, Integer qtdItem)
			throws RegistroNaoEncontrado, ComandaFechadaException {
		Comanda comanda = comandaDao.obterPorCodigo(codigoComanda);
		Item item = itemDao.obterPorCodigo(codigoItem);
		comanda.incluirItem(item, qtdItem);
	}

	public Double fecharComanda(Integer codigoComanda) throws RegistroNaoEncontrado {
		Comanda comanda = comandaDao.obterPorCodigo(codigoComanda);
		return comanda.fechar();
	}

}
