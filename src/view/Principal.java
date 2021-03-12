package view;
import controller.Matriz;
public class Principal {
	public static void main(String[] args) {
		int mat [] []= new int [3] [5];
		int vetor []= new int [5];
		for (int i= 0; i<3; i++) {
			for (int c= 0; c<5; c++) {
				mat [i] [c]= (int) (Math.random()*11);
			}
		}
		for (int i= 0; i<3; i++) {
			for (int c= 0; c<5; c++) {
				System.out.print("[" + mat[i][c]+"]");
			}
				System.out.println("\n");
		}
		for (int i= 0; i<3; i++) {
			for (int c= 0; c<5; c++) {
				vetor [c]= mat[i] [c];
			}
			System.out.println("\n");
			Thread calc= new Matriz(i, vetor);
			calc.start();
			synchronized(calc) {
				try {
					calc.wait();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}