package act1;

import java.util.Arrays;

public class Lanzador {
	public static void main(String[] args) {
		LeerNumeros myInput = new LeerNumeros();
		int[] numeros = myInput.getNumeros();
		int index = myInput.getLength();
		int pasos = Math.round(index / 4);
		Promediador prom1 = new Promediador(0, Arrays.copyOfRange(numeros, 0, pasos));
		Promediador prom2 = new Promediador(1, Arrays.copyOfRange(numeros, pasos + 1, pasos * 2));
		Promediador prom3 = new Promediador(2, Arrays.copyOfRange(numeros, pasos * 2 + 1, pasos * 3));
		Promediador prom4 = new Promediador(3, Arrays.copyOfRange(numeros, pasos * 3 + 1, pasos * 4));
		long inicio = System.nanoTime();
		prom4.start();
		prom1.start();
		prom2.start();
		prom3.start();
		// Wait all 
		while (prom1.isAlive() || prom2.isAlive() || prom3.isAlive() || prom4.isAlive());			
		long fin = System.nanoTime();
		double finalRes = (prom1.res + prom2.res + prom3.res + prom4.res) / 4;
			
		System.out.println("La cantidad de números es: " + index);
		System.out.println("El promedio total es: " + finalRes);		
		System.out.println("Lo que se tardo fue: " + (fin - inicio) + " nanoseg.");
	}
}
