package fibonacci;

import java.util.Scanner;

public class Fibonacci {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	    int qtd = scanner.nextInt();
	    
//	    System.out.println(qtd);
//	    
//	    int ant = 0;
//	    int prox = 1;
//	    int s = ant + prox;
//	    
//	    System.out.println(ant);
//	    System.out.println(prox);
//	   
//	    for(int i = 0; i < qtd; i++) {
//	    	System.out.println(s);
//	    	ant = prox;
//	    	prox =  s;
//	    	s = ant + prox;	    
	    
//	    }
	    
	    fibonacciRecursive(1, qtd);
	}
	
	public static void fibonacciRecursive(int n, int num) {
		System.out.println(calcular(n));
		if (++n <= num) {
			fibonacciRecursive(n, num);
		}
	}

	public static int calcular(int n) {
		return (n < 2) ? n : (calcular(n - 1) + calcular(n - 2));
	}

}
