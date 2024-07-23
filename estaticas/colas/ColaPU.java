package estaticas.colas;

public class ColaPU implements ColaTDA {  // PU: Primero Ultimo
	int[] arr;
	int inx;
	
	public void InicializarCola() {
		arr = new int[100]; // 100 son los elementos posibles
		inx = 0;
	}
	
	public void Acolar(int x) {
		for ( int i = inx - 1; i >=0; i--) {
			arr[i + 1] = arr[i];
		}
		arr[0] = x;
		inx++;
	}
	
	public void Desacolar() {
		inx--;
	}
	
	public boolean ColaVacia() {
		return (inx == 0);
	}
	
	public int Primero() {
		return arr[inx - 1];
	}
}
