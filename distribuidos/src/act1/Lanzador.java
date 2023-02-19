package act1;

public class Lanzador {

	// Read all numbers and put it in an array
	LeerNumeros myInput = new LeerNumeros();
	int[] numeros = myInput.getNumeros();
	int length = myInput.getLength();
	double finalRes = 0;

	// Number of threads
	int numeroThreads;
	
	public Lanzador(int numeroThreads) {
		this.numeroThreads = numeroThreads;
	}
	
	public long getTime() {
		int pasos = Math.round(length / numeroThreads);		
		Promediador[] prom = new Promediador[numeroThreads];
		
		long inicio = System.nanoTime();
		for (int i = 0; i < numeroThreads; i++) {
			int from = i * pasos;
			int to = from + pasos;
			if ((i + 1) == numeroThreads) to = length;
			prom[i] = new Promediador(i, numeros, from, to); 
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
		finalRes /= length;
		long fin = System.nanoTime();
		
		System.out.println("Hilos usados: " + numeroThreads);
		System.out.println("La cantidad de números es: " + length);
		System.out.println("El promedio total es: " + finalRes);		
		System.out.println("Lo que se tardo fue: " + (fin - inicio) + " nanoseg.");
		
		return fin - inicio;
	}
}
