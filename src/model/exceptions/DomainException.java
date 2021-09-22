package model.exceptions;

public class DomainException extends RuntimeException {
	private static final long serialVersionUID = 1L; // Declara a vers�o de uma classe Serializable

	public DomainException(String msg) {
		super(msg);
	}
}
