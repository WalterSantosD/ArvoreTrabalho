package ArvoreTrabalho;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Arvore arvore = new Arvore();
		
		while (true) {
			try {
				Scanner obj = new Scanner(System.in);
				String n = obj.nextLine();
				
				String[] array = n.split(" ");
				int cont = 0;
				for (String string : array) {
					if(string.equals("(")) {
						cont++;
					}else if(string.equals(")")) {
						cont--;
					}
					if(cont<0) {
						break;
					}
				}
				
				if(cont == 0) {
					System.out.println("expressao valida");					
					No et = arvore.parse(array);
					System.out.println("Resultado  = " + et.calcular());
				}


			} catch (Exception e) {
			}
		}
	}

}
