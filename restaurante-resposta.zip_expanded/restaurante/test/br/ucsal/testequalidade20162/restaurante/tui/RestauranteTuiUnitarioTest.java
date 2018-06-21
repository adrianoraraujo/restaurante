package br.ucsal.testequalidade20162.restaurante.tui;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class RestauranteTuiUnitarioTest {

	private RestauranteTui restauranteTui;

	@Before
	public void setup() {
		restauranteTui = new RestauranteTui(null);
	}

	// Método a ser testado: public Integer obterInteiro(String mesagem)
	// Verificar o processo de entrada e saída para obtenção de um número
	// inteiro.
	// Obs: lembrar de fazer o dublê do System.in e do System.out.
	@Test
	public void verificarObterInteiro() throws Exception {
		// Dados de entrada. O "\n" é necessário, pois após o nextInt() é feita
		// uma chamada ao nextLine().
		String mensagem = "Informe um valor:";
		String valorEntrada = "23\n";

		// Saída esperada
		Integer valorEsperado = 23;

		// Setup
		// Setup1 = Utilizando a última versão estável do Mockito (1.10.19) não
		// é possível fazer mock de classes final, como a Scanner. Por este
		// motivo, não será feito um mock da mesma e sim um stub.
		InputStream inputStream = new ByteArrayInputStream(valorEntrada.getBytes());
		Scanner scannerStub = new Scanner(inputStream);
		restauranteTui.sc = scannerStub;

		// Setup2 = Criando o mock do System.out.
		PrintStream outOriginal = System.out;
		PrintStream outMock = Mockito.mock(PrintStream.class);
		System.setOut(outMock);

		// Executar método sob teste e coletar a saída esperada
		Integer valorAtual = restauranteTui.obterInteiro(mensagem);

		// Comparar o resultado esperado com o atual
		Assert.assertEquals(valorEsperado, valorAtual);

		// Verificar que a mensagem foi adequadamente exibida, através da
		// verificação da chamada do println do outMock.
		Mockito.verify(outMock).println(mensagem);

		// Devolver o outOriginal para o System.out, para que as novas chamadas
		// ao System.out.println ocorram normalmente.
		System.setOut(outOriginal);

	}
}
