package br.ucsal.testequalidade20162.restaurante.exception;

public class ComandaFechadaException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String COMANDA_FECHADA = "Comanda fechada (código = %d).";

	public ComandaFechadaException(Integer codigo) {
		super(String.format(COMANDA_FECHADA, codigo));
	}

}
