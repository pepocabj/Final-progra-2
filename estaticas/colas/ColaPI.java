package estaticas.colas;

public class ColaPI implements ColaTDA {  // PI Primero Inicio
	int[] arr;
	int inx;
	
	public void InicializarCola() {
		arr = new int[100]; // 100 son los elementos posibles
		inx = 0;
	}
	
	public void Acolar(int x) {
		arr[inx] = x;
		inx++;
	}
	
	public void Desacolar() {
		for (int i = 0; i < inx - 1; i++) {
			arr[i] = arr[i + 1];
		}
		inx--;
	}
	
	public boolean ColaVacia() {
		return (inx == 0);
	}
	
	public int Primero() {
		return arr[0];
	}
}
