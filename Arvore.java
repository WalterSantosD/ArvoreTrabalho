package ArvoreTrabalho;

import java.util.Stack;

public class Arvore {

public No Operacao(String simb, No esq, No dir) {
		if (simb.equals("+")) {
			return new Soma(esq, dir);
		}
		
		else if (simb.equals("-")){
			return new Subtracao(esq, dir);
		}
			
		else if (simb.equals("*")){
			return new Multiplicacao(esq, dir);
		}
			
		else if (simb.equals("/")){
			return new Divisao(esq, dir);
		}
			
		else {
			throw new IllegalArgumentException();	
		}
			
	}

public No parse(String[] dados) {
		
		Stack<String> simbolos = new Stack<String>();
		Stack<No> nos = new Stack<No>();

		No esq, dir;

		for (int i = 0; i < dados.length; i++) {
			String dado = dados[i];
			

			if (dado.chars().allMatch(Character::isDigit)) {
				No numero = new Numero(Integer.parseInt(dado));
				nos.push(numero);
			}

			else if (dado.equals("(")) {
				simbolos.push("(");				
			}

			else if (dado.equals(")")) {
				while(true){
					String op = simbolos.pop();
					if (op.equals("(")) {
						break;						
					}
					dir = nos.pop();
					esq = nos.pop();
					No operacao = Operacao(op, esq, dir);
					nos.push(operacao);
				}
			}

			else {
				for (; !simbolos.isEmpty();) {
					String op = simbolos.peek();
					if (op.equals("(")) {
						break;																						
					}
					simbolos.pop();
					dir = nos.pop();
					esq = nos.pop();
					nos.push(Operacao(op, esq, dir));
				}

				simbolos.push(dado);
			}
		}

		return nos.pop();

	}

}
