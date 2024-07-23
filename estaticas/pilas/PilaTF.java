package estaticas.pilas;

public class PilaTF implements PilaTDA {  // TF: Tope al Final
	int[] arr;
	int inx;
	
	public void InicializarPila() {
		arr = new int[100]; // 100 son los elementos posibles
		inx = 0;
	}
	
	public void Apilar(int x) {
		arr[inx] = x;
		inx++;
	}
	
	public void Desapilar() {
		inx--;
	}
	
	public boolean PilaVacia() {
		return (inx == 0);
	}
	
	public int Tope() {
		return (arr[inx - 1]);
	}
}
