
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Gerente gerentebasico[] = new Gerente[20];
		Cliente cliente[] = new Cliente[20];
		gerentebasico[0] = new Gerente("adm","123");
		Login MenuDeLogin = new Login(gerentebasico);
		MenuDeLogin.setVisible(true);
	}

}