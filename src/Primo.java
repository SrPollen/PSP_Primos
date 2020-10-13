import java.math.BigInteger;

public class Primo extends Thread {
	private int numStart;
	private int numMax;
	private int countPrimos;

	public Primo(int numStart, int numMax) {
		this.numStart = numStart;
		this.numMax = numMax;
		this.countPrimos = countPrimos;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		calcular();
	}
	
	public void calcular() {
		BigInteger bigInt;
		int countPrimos = 0;
		for (int i = this.numStart; i < this.numMax; i++) {
			bigInt = new BigInteger(String.valueOf(i));
			if(bigInt.isProbablePrime(i)) {
				System.out.println(Thread.currentThread().getName() + " Es primo: " + i);
				countPrimos++;
			}	
		}	
		this.countPrimos = countPrimos;
	}
	
	
	public int getCountPrimos() {
		return countPrimos;
	}
}
