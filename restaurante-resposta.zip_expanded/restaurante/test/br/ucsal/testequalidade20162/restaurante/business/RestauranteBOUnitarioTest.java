package br.ucsal.testequalidade20162.restaurante.business;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.ucsal.testequalidade20162.restaurante.domain.Comanda;
import br.ucsal.testequalidade20162.restaurante.domain.Mesa;
import br.ucsal.testequalidade20162.restaurante.exception.MesaOcupadaException;
import br.ucsal.testequalidade20162.restaurante.exception.RegistroNaoEncontrado;
import br.ucsal.testequalidade20162.restaurante.persistence.ComandaDao;
import br.ucsal.testequalidade20162.restaurante.persistence.ItemDao;
import br.ucsal.testequalidade20162.restaurante.persistence.MesaDao;

public class RestauranteBOUnitarioTest {

	private RestauranteBO restauranteBO;

	private ComandaDao comandaDaoMock;

	private ItemDao itemDaoMock;

	private MesaDao mesaDaoMock;

	@Before
	public void setup() {
		comandaDaoMock = Mockito.mock(ComandaDao.class);
		itemDaoMock = Mockito.mock(ItemDao.class);
		mesaDaoMock = Mockito.mock(MesaDao.class);
		restauranteBO = new RestauranteBO(comandaDaoMock, itemDaoMock, mesaDaoMock);
	}

	// Método a ser testado: public Integer abrirComanda(Integer numeroMesa)
	// throws RegistroNaoEncontrado,
	// MesaOcupadaException {
	// Verificar se a abertura de uma comanda para uma mesa livre apresenta
	// sucesso.
	@Test
	public void abrirComandaMesaLivre() throws RegistroNaoEncontrado, MesaOcupadaException {
		// Dados de entrada
		Integer numeroMesa = 1;
		Mesa mesa = new Mesa(numeroMesa);

		// Saída esperada - Verificação das chamadas aos mocados no final deste
		// método.

		// Setup
		Mockito.doReturn(mesa).when(mesaDaoMock).obterPorNumero(numeroMesa);
		Mockito.doNothing().when(comandaDaoMock).incluir(Mockito.any(Comanda.class));

		// Executar método sob teste e coletar a saída esperada
		restauranteBO.abrirComanda(numeroMesa);

		// Verificar se as chamadas aos métodos mocados ocorreu como esperado.
		Mockito.verify(mesaDaoMock).obterPorNumero(numeroMesa);
		Mockito.verify(comandaDaoMock).incluir(Mockito.any(Comanda.class));

	}
}
