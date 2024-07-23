package ejercicios;

public class ListaCircular implements ListaCircularTDA{
    public class Nodo{
        int dato;
        Nodo sig;
    }

    private Nodo origen;

    public void InicializarLista(){
        origen = null;
    }

    public void Agregar(int x){
        Nodo aux = new Nodo();
        if (ListaVacia()) {
            aux.dato = x;
            aux.sig = aux;
            origen = aux;
        }else{
            aux.dato = x;
            aux.sig = origen.sig;
            origen.sig = aux;
        }
    }

    public void Eliminar(int x){
        Nodo aux = origen;
        if (!ListaVacia()) {
            if (aux.dato == x && aux.sig == origen) { //Elimino el 1ero y unico
                aux = null;
            }else{
                while (aux.sig != origen) {
                    if (aux.sig.dato == x) {
                        aux.sig = aux.sig.sig;
                    }
                    aux = aux.sig;
                }
                if (aux.sig == origen && aux.sig.dato == x) {
                    origen = aux;
                    aux.sig = aux.sig.sig;
                }
            }
        }
    }

    public boolean Existe(int x){
        Nodo aux = origen;
        int cont = 0;
        if (!ListaVacia()) {
            while (aux.sig != origen) {
                if (aux.dato == x) {
                    cont = 1;
                }
                aux = aux.sig;
            }
            if (cont == 1) {
                return true;
            }
        }
        return false;
    }

    public String MostrarLista(){
        Nodo aux = origen;
        String txt = "";
        if (!ListaVacia()) {
            while (aux.sig != origen) {
                txt+= aux.dato + ";";
                aux = aux.sig;
            }
            txt+= aux.dato + ";";
        }
        return txt;
    }

    public boolean ListaVacia(){
        return (origen == null);
    }

    public void Verificar(){
        Nodo aux = origen;
        if (!ListaVacia()) {
            while (aux.sig != origen) {
                System.out.println(aux.sig.dato);
                System.out.println("-->");
                aux = aux.sig;
            }
        }
        System.out.println(aux.sig.dato);
        System.out.println("El ultimo");
    }
}
