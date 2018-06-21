package br.ucsal.testequalidade20162.restaurante.exception;

public class MesaOcupadaException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String MESA_OCUPADA = "Mesa ocupada (número = %d).";

	public MesaOcupadaException(Integer numero) {
		super(String.format(MESA_OCUPADA, numero));
	}

}
