package model.exceptions;

public class DomainException extends RuntimeException {
	private static final long serialVersionUID = 1L; // Declara a versão de uma classe Serializable

	public DomainException(String msg) {
		super(msg);
	}
}
