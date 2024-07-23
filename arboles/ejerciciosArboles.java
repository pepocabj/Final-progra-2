package arboles;

public class ejerciciosArboles {

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

    public static boolean HojaNo(TDAABB a,int x){
        if (!a.ArbolVacio()) {
            if (a.Raiz() == x && a.HijoDer().ArbolVacio() && a.HijoIzq().ArbolVacio()) {
                return true;
            } else if (a.Raiz() == x && (!a.HijoDer().ArbolVacio() || !a.HijoIzq().ArbolVacio())) {
                return false;
            } else if(a.Raiz()>x ){
                return HojaNo(a.HijoIzq(),x);
            }else if (a.Raiz() < x) {
                return HojaNo(a.HijoDer(), x);
            }
        }
        return false;
    }

    public static int Profundidad(TDAABB a,int nivel,int x){
        if (!a.ArbolVacio()) {
            if (a.Raiz() == x && a.HijoDer().ArbolVacio() && a.HijoIzq().ArbolVacio()) {
                return nivel;
            } else if(a.Raiz()>x ){
                return Profundidad(a.HijoIzq(),nivel+1,x);
            }else if (a.Raiz() < x) {
                return Profundidad(a.HijoDer(), nivel+1,x);
            }
        }
        return nivel;
        
    }

    public static void preOrder(TDAABB a){
        if (!a.ArbolVacio()) {
            System.out.println(a.Raiz());
            preOrder(a.HijoIzq());
            preOrder(a.HijoDer());
        }
    }

    public static int Menor(TDAABB a, int mini){
        if (!a.ArbolVacio()) {
            if (a.HijoDer().ArbolVacio() && a.HijoIzq().ArbolVacio()) {
                return a.Raiz();
            }else if (a.Raiz() < mini ) {
                mini = a.Raiz();
                return Menor(a.HijoIzq(),mini);
            }
        }
        return mini;
    }

    public static int cantidad(TDAABB a){
        if (a.ArbolVacio()) {
            return 0;
        }
        return 1 + cantidad(a.HijoIzq()) + cantidad(a.HijoDer());
    }
    
    public static int suma(TDAABB a){
        if (a.ArbolVacio()) {
            return 0;
        }else{
            return a.Raiz() + suma(a.HijoIzq()) + suma(a.HijoDer());
        }
    }

    public static int cantHojas(TDAABB a){
        if (!a.ArbolVacio()) {
            if (a.HijoDer().ArbolVacio() && a.HijoIzq().ArbolVacio()) {
                return 1 + cantHojas(a.HijoIzq()) + cantHojas(a.HijoDer());
            }else{
                return cantHojas(a.HijoIzq()) + cantHojas(a.HijoDer());
            }
        }
        return 0;
    }

    public static int altura(TDAABB a){
        if (a.ArbolVacio()) {
            return -1;
        }else{
            int alturaIzq = altura(a.HijoIzq());
            int alturaDer = altura(a.HijoDer());
            return 1 + Math.max(alturaIzq, alturaDer);
        }
    }

    public static boolean iguales(TDAABB a, TDAABB b){
        if (a.ArbolVacio() && b.ArbolVacio()) {
            return true;
        }
        
        if (a.ArbolVacio() || b.ArbolVacio()) {
            return false;
        }

        boolean igualesIzq = iguales(a.HijoIzq(), b.HijoIzq());
        boolean igualesDer = iguales(a.HijoDer(), b.HijoDer());

        return igualesIzq && igualesDer;
    }

    public static boolean identicos(TDAABB a, TDAABB b){
        if (a.ArbolVacio() && b.ArbolVacio()) {
            return true;
        }
        
        if (a.ArbolVacio() || b.ArbolVacio()) {
            return false;
        }

        boolean IgualesRaiz = a.Raiz() == b.Raiz();
        boolean igualesIzq = identicos(a.HijoIzq(), b.HijoIzq());
        boolean igualesDer = identicos(a.HijoDer(), b.HijoDer());

        return IgualesRaiz && igualesIzq && igualesDer;
    }

    public static void main(String[] args) {
        TDAABB arbol = new ABB();
        TDAABB arbol2 = new ABB();
        arbol2.InicializarArbol();
        arbol2.AgregarElem(15);
        arbol2.AgregarElem(40);
        arbol2.AgregarElem(7);
        arbol2.AgregarElem(11);
        arbol2.AgregarElem(24);
        arbol2.AgregarElem(77);
        arbol2.AgregarElem(19);
        arbol2.AgregarElem(1);

        arbol.InicializarArbol();
        arbol.AgregarElem(15);
        arbol.AgregarElem(40);
        arbol.AgregarElem(7);
        arbol.AgregarElem(11);
        arbol.AgregarElem(24);
        arbol.AgregarElem(77);
        arbol.AgregarElem(19);
        arbol.AgregarElem(1);
        
        MostrarABB(arbol, 0);
        System.out.println("\t");
        MostrarABB(arbol2, 0);
        System.out.println(identicos(arbol, arbol2));
    }
}
