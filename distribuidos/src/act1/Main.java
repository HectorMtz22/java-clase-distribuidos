package act1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int hilos = 8;
		long[] time = new long[hilos];
		Lanzador[] lanzadores = new Lanzador[hilos];
		for (int i = 0; i < hilos; i++) {
			lanzadores[i] = new Lanzador(i + 1);
			time[i] = lanzadores[i].getTime();
		}
	}

}
