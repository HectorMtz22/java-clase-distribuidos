package act1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class PromedioSecuencial {
	public static void main(String[] args) {
		int BUFFER = 100_000_000;
		try {
			String path = "numeros.txt";
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = "";
			int[] numeros = new int[BUFFER];
			int index = 0;
			
			while((line = br.readLine()) != null) {
				String[] values = line.split(",");
				for (int i = 0; i < values.length; i++) {
					numeros[index++] = Integer.parseInt(values[i]);
				}
			}

			long inicio = System.nanoTime();
			double suma = 0;
			double finalRes = 0;
			for (int i = 0; i < index; i++) {
				suma += numeros[i];
			}
			finalRes = suma / index;
			long fin = System.nanoTime();
			System.out.println("La cantidad de números es: " + index);
			System.out.println("El promedio total es: " + finalRes);			
			System.out.println("Lo que se tardo fue: " + (fin - inicio) + " nanoseg.");
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no se encuentra, intentelo nuevamente");
		} catch (IOException e) {
			System.out.println("Ocurrio un problema al leer el archivo: " + e);
		}
	}
}
