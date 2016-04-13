package chooser;

public class VectorInvalidException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4203438662752719063L;
	private String mensagem;

	public VectorInvalidException(String mensagem) {
		super(mensagem);
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}
}
