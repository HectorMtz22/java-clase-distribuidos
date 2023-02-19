package act1;

public class Promediador extends Thread {
	int id;
	int[] data;
	int from;
	int to;
	double res = 0.0;
	public Promediador(int id, int[] data, int from, int to) {
		this.id = id;
		this.data = data;
		this.from = from;
		this.to = to;
	}
	double suma = 0;
	public void run() {
		for (int i = from; i < to; i++) {
			suma += data[i];
		}
		res = suma / (to - from);
		//System.out.println("Hilo " + id + " suma: " + suma + " y promedio " + res);
	}
	
}
