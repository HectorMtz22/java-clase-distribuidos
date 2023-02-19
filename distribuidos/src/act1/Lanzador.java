package act1;

public class Lanzador {
	public static void main(String[] args) {
		// Read all numbers and put it in an array
		LeerNumeros myInput = new LeerNumeros();
		int[] numeros = myInput.getNumeros();
		int length = myInput.getLength();

		double finalRes = 0;
		
		// Number of threads
		int numeroThreads = 4;
		
		int pasos = Math.round(length / numeroThreads);		
		Promediador[] prom = new Promediador[numeroThreads];
		
		long inicio = System.nanoTime();

		for (int i = 0; i < numeroThreads; i++) {
			int from = i * pasos;
			prom[i] = new Promediador(i, numeros, from, from + pasos); 
			prom[i].start();
		}
		// Wait all threads

		while (true) {
			int threadsCompletados = 0;
			for (int i = 0; i < numeroThreads; i++) {
				if (!prom[i].isAlive()) threadsCompletados++;
			}
			if (threadsCompletados == numeroThreads) break;
		}
		// When all threads finish
		for (int i = 0; i < numeroThreads; i++) {
			finalRes += prom[i].res;
		}
		finalRes /= numeroThreads;
		long fin = System.nanoTime();
		
		System.out.println("La cantidad de números es: " + length);
		System.out.println("El promedio total es: " + finalRes);		
		System.out.println("Lo que se tardo fue: " + (fin - inicio) + " nanoseg.");
	}
}
