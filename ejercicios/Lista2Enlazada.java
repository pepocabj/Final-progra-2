package ejercicios;

public class Lista2Enlazada implements Lista2EnlazadaTDA{
    public class Nodo{
        Nodo sig;
        Nodo prev;
        int Valor;
    }
    private Nodo Cabeza;
    private Nodo Cola;
    public void InicializarLst(){
        Cabeza = null;
        Cola = null;
    }

    public void Agregar(int x){
        Nodo aux = new Nodo();
        aux.Valor = x;
        if (ListaVacia2()) {
            Cabeza = aux;
            aux.prev = null;
        }else if (Cola == null && Cabeza != null) {
            Cola = aux;
            aux.sig = null;
            aux.prev = Cabeza;
            Cabeza.sig = Cola;
        }else{
            if (Cola.prev == Cabeza) {
                Cola.prev = aux;
            }
            Cabeza.sig.prev = aux;
            aux.sig = Cabeza.sig;
            Cabeza.sig = aux;
            aux.prev = Cabeza;
        }
    }

    public void Eliminar(int x){
        if (!ListaVacia2()) {
            Nodo aux = Cabeza.sig;
            if (Cabeza.Valor == x) {
                aux.prev= null;
            }else{
                while (aux.sig != null) {
                    if (aux.Valor == x) {
                        aux.sig.prev = aux.prev;
                        aux.prev.sig = aux.sig;
                    }
                    aux = aux.sig;
                }
            }
            if (aux == Cola && Cola.Valor == x) {
                Cola.prev.sig = null;
            }
        }
    }


    public String MostrarLista(){
        Nodo aux = Cabeza;
        String txt = "";
        if (!ListaVacia2()) {
            while (aux.sig != null) {
                txt+= aux.Valor + ";";
                aux = aux.sig;
            }
            System.out.println(aux.Valor);
            txt+= aux.Valor + ";";
        }
        return txt;
    }

    public boolean ListaVacia2(){
        return (Cabeza == null);
    }
}
