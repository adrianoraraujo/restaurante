package br.ucsal.testequalidade20162.restaurante.business;

import org.junit.Before;
import org.junit.Test;

import br.ucsal.testequalidade20162.restaurante.domain.Item;
import br.ucsal.testequalidade20162.restaurante.domain.Mesa;
import br.ucsal.testequalidade20162.restaurante.exception.ComandaFechadaException;
import br.ucsal.testequalidade20162.restaurante.exception.MesaOcupadaException;
import br.ucsal.testequalidade20162.restaurante.exception.RegistroNaoEncontrado;
import br.ucsal.testequalidade20162.restaurante.persistence.ComandaDao;
import br.ucsal.testequalidade20162.restaurante.persistence.ItemDao;
import br.ucsal.testequalidade20162.restaurante.persistence.MesaDao;

public class RestauranteBOIntegradoTest {

	private RestauranteBO restauranteBO;

	private ComandaDao comandaDao;

	private ItemDao itemDao;

	private MesaDao mesaDao;

	@Before
	public void setup() {
		comandaDao = new ComandaDao();
		itemDao = new ItemDao();
		mesaDao = new MesaDao();
		restauranteBO = new RestauranteBO(comandaDao, itemDao, mesaDao);
	}

	// Método a ser testado: public void incluirItemComanda(Integer
	// codigoComanda, Integer codigoItem, Integer
	// qtdItem) throws RegistroNaoEncontrado, ComandaFechadaException {
	// Verificar se a inclusão de uma item em uma comanda fechada levanta
	// exceção.
	@Test(expected = ComandaFechadaException.class)
	public void incluirItemComandaFechada()
			throws RegistroNaoEncontrado, MesaOcupadaException, ComandaFechadaException {
		// Dados de entrada / Setup
		Mesa mesa = new Mesa(1);
		mesaDao.incluir(mesa);
		Item item = new Item("Refrigerante", 2.5);
		itemDao.incluir(item);
		Integer codigoComanda = restauranteBO.abrirComanda(mesa.getNumero());
		restauranteBO.fecharComanda(codigoComanda);

		// Saída esperada = avaliada através da propriedade expected da
		// anotation @Test

		// Executar método sob teste e coletar a saída esperada
		restauranteBO.incluirItemComanda(codigoComanda, item.getCodigo(), 1);

		// Comparar o resultado esperado com o atual = avaliada através da
		// propriedade expected da anotation @Test

	}
}
