import java.util.ArrayList;
import java.util.Scanner;

public class Controlador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//pedir al usuario hilos que van a participar
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce numero de hilos: ");
		int numeroHilos = sc.nextInt();	
		int num = 100000;
		int numStart = 1;
		int rango = num / numeroHilos;
		int numMax = rango;
		int countPrimos= 0;

		ArrayList<Primo> hilos = new ArrayList<>();
		for (int i = 0; i < numeroHilos ; i++) {
			hilos.add(new Primo(numStart, numMax));
			numStart = numMax;
			numMax += rango;		
		}		
		
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < hilos.size(); i++) {					
			try {
				hilos.get(i).start();
				hilos.get(i).join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long endTime = System.currentTimeMillis() - startTime;
	
		long tiempo = endTime/1000;
		System.out.println("Se ha tardado " + tiempo + "s con " + numeroHilos + " hilos" );
		
		for (int i = 0; i < hilos.size(); i++) {		
			countPrimos += hilos.get(i).getCountPrimos();
		}
		
		System.out.println("Primos totales: " + countPrimos);
		
		//hilos.forEach(Primo::start);
	}

}
