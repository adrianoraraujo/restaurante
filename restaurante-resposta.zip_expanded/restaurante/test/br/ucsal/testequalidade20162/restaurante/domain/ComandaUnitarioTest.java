package br.ucsal.testequalidade20162.restaurante.domain;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ucsal.testequalidade20162.restaurante.exception.MesaOcupadaException;

public class ComandaUnitarioTest {

	private Comanda comanda;

	@Before
	public void setup() throws MesaOcupadaException {
		comanda = new Comanda(new Mesa(1));
	}

	// Método a ser testado: public Double calcularTotal() {
	// Verificar o cálculo do valor total,com um total de 4 itens.
	// Obs: lembre-se de substituir o conteúdo do atributo itens por uma lista
	// com 4 itens.
	@Test
	public void calcularTotal4Itens() {
		// Dados de entrada
		Map<Item, Integer> itensComanda = new HashMap<>();
		itensComanda.put(new Item("Refrigerante", 2.5), 2);
		itensComanda.put(new Item("Pizza", 5.15), 1);
		itensComanda.put(new Item("Lazanha", 12.60), 1);
		itensComanda.put(new Item("Suco", 3.2), 2);

		// Saída esperada
		Double totalEsperado = 29.15;

		// Setup
		comanda.itens = itensComanda;

		// Executar método sob teste e coletar a saída esperada
		Double totalAtual = comanda.calcularTotal();

		// Comparar o resultado esperado com o atual.
		// O último parâmetro do assertEquals é o delta, que representa a
		// diferença entre o valor esperado e o atual a partir da qual os
		// valores serão considerados diferentes. Neste exemplo, para diferenças
		// maiores ou iguais à 0.01 o assertEquals irá considerar os valores
		// diferentes.
		Assert.assertEquals(totalEsperado, totalAtual, 0.01);

	}

}
