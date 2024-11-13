public class PayPal implements FormaDeCompra {
	private String email;
	private String senha;

	public PayPal(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	@Override
	public boolean comprar() {
		System.out.println("Comprando com PayPal");
		return true;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
