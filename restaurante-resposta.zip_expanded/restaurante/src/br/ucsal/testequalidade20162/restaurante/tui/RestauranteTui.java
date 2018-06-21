package br.ucsal.testequalidade20162.restaurante.tui;

import java.util.Scanner;

import br.ucsal.testequalidade20162.restaurante.business.RestauranteBO;
import br.ucsal.testequalidade20162.restaurante.exception.ComandaFechadaException;
import br.ucsal.testequalidade20162.restaurante.exception.MesaOcupadaException;
import br.ucsal.testequalidade20162.restaurante.exception.RegistroNaoEncontrado;

public class RestauranteTui {

	private static final String VALOR_COMANDA = "Valor comanda = %10.2f";
	private static final String INFORME_QUANTIDADE_ITEM = "Informe a quantidade do item:";
	private static final String INFORME_CODIGO_ITEM = "Informe o código da item:";
	private static final String MES_INFORME_CODIGO_COMANDA = "Informe o código da comanda:";
	private static final String MENS_INFORME_NUMERO_MESA = "Informe o número da mesa:";

	public Scanner sc = new Scanner(System.in);

	public RestauranteBO restauranteBO;

	public RestauranteTui(RestauranteBO restauranteBO) {
		this.restauranteBO = restauranteBO;
	}

	public void abrirComanda() {
		Integer numeroMesa = obterInteiro(MENS_INFORME_NUMERO_MESA);
		try {
			restauranteBO.abrirComanda(numeroMesa);
		} catch (RegistroNaoEncontrado | MesaOcupadaException e) {
			System.out.println(e.getMessage());
		}
	}

	public void incluirItemComanda() {
		Integer codigoComanda = obterInteiro(MES_INFORME_CODIGO_COMANDA);
		Integer codigoItem = obterInteiro(INFORME_CODIGO_ITEM);
		Integer qtdItem = obterInteiro(INFORME_QUANTIDADE_ITEM);
		try {
			restauranteBO.incluirItemComanda(codigoComanda, codigoItem, qtdItem);
		} catch (RegistroNaoEncontrado | ComandaFechadaException e) {
			System.out.println(e.getMessage());
		}
	}

	public void fecharComanda() {
		Integer codigoComanda = obterInteiro(MES_INFORME_CODIGO_COMANDA);
		try {
			Double valorComanda = restauranteBO.fecharComanda(codigoComanda);
			System.out.println(String.format(VALOR_COMANDA, valorComanda));
		} catch (RegistroNaoEncontrado e) {
			System.out.println(e.getMessage());
		}
	}

	public Integer obterInteiro(String mesagem) {
		System.out.println(mesagem);
		Integer valor = sc.nextInt();
		sc.nextLine();
		return valor;
	}

}
