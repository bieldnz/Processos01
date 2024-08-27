package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Principal {
	public static void main(String[] args) {
		RedesController controller = new RedesController();
		int opc;
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 - IP \n"
															 + "2 - Ping \n"
															 + "9 - FIM"));
			switch(opc) {
				case 1:
					controller.ip();
					break;
				case 2:
					controller.ping("ping -4 -n 10 www.google.com.br");
					break;
				case 9:
					break;
				default:
					System.out.println("Digite uma opção válida");
					break;
			}
		}while(opc != 9);
	}
}
