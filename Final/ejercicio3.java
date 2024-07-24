package Final;

import arboles.ABB;
import arboles.TDAABB;

public class ejercicio3 {
    public static void MostrarABB(TDAABB a, int nivel){
        if (!a.ArbolVacio()) {
            MostrarABB(a.HijoDer(), nivel+1);
            for(int i=0; i < nivel;i++){
                System.out.print("\t");
            }
            System.out.print(a.Raiz());
            System.out.println();
            MostrarABB(a.HijoIzq(), nivel+1);
        }
    }

    public static int hijos(TDAABB a, int x){
        int num = 0;
        if (a.ArbolVacio()) {
            return 0;
        }else if (a.Raiz() == x && !a.HijoIzq().ArbolVacio()) {
            num = a.HijoIzq().Raiz();
            return num;
        }else if (a.Raiz() > x) {
            return hijos(a.HijoIzq(), x);
        }else if (a.Raiz() < x) {
            return hijos(a.HijoDer(), x);
        }
        return num;
    }
    public static void main(String[] args) {
        TDAABB arbol = new ABB();
        arbol.InicializarArbol();

        arbol.AgregarElem(4);
        arbol.AgregarElem(7);
        arbol.AgregarElem(1);
        arbol.AgregarElem(9);
        arbol.AgregarElem(5);

        MostrarABB(arbol, 0);

        int num = hijos(arbol, 7);
        System.out.println(num);
    }
}
