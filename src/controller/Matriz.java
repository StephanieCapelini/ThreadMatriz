package controller;

public class Matriz extends Thread {
	private int [] vetor;
	private int c;
	public Matriz(int c, int []vetor) {
		this.c= c;
		this.vetor= vetor;
	}
	@Override
	public void run() {
		SomaVetores();
	}
	private void SomaVetores() {
		int soma=0;
		try {
			sleep(1000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		synchronized(this) {
			for(int y= 0; y<5; y++) {
				soma += vetor[y]; 
			}
			System.out.println((c+1)+" : "+ soma);
		}
	}

}
