package co.com.udem.arbol;

public class ProgramaArbol {
    private ProgramaNodo raiz;
    public ProgramaArbol() {
        raiz = null;
    }

    public void insertar(int valor) {
        raiz = insRec(raiz, valor);
    }

    private ProgramaNodo insRec(ProgramaNodo nodo, int valor) {
        if (nodo == null) {
            nodo = new ProgramaNodo(valor);
            return nodo;
        }
        if (valor < nodo.getValor()) {
            nodo.setIzquierdo(insRec(nodo.getIzquierdo(), valor));
        } else if (valor > nodo.getValor()) {
            nodo.setDerecho(insRec(nodo.getDerecho(), valor));
        }
        return nodo;
    }

    public void recPostOrden() {
        recPostOrden(raiz);
    }

    private void recPostOrden(ProgramaNodo nodo) {
        if (nodo != null) {
            recPostOrden(nodo.getIzquierdo());
            recPostOrden(nodo.getDerecho());
            System.out.print(nodo.getValor() + " ");
        }
    }

    public void recPreOrden() {
        recPreOrden(raiz);
    }

    private void recPreOrden(ProgramaNodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.getValor() + " ");
            recPreOrden(nodo.getIzquierdo());
            recPreOrden(nodo.getDerecho());
        }
    }

    public void recEnOrden() {
        recorEnOrden(raiz);
    }

    private void recorEnOrden(ProgramaNodo nodo) {
        if (nodo != null) {
            recorEnOrden(nodo.getIzquierdo());
            System.out.print(nodo.getValor() + " ");
            recorEnOrden(nodo.getDerecho());
        }
    }

    public int cont_h() {
        return contHojasRec(raiz);
    }

    private int contHojasRec(ProgramaNodo nodo) {
        if (nodo == null) {
            return 0;
        }
        if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
            return 1;
        }
        return contHojasRec(nodo.getIzquierdo()) + contHojasRec(nodo.getDerecho());
    }

    public int altura() {
        return alturaRec(raiz);
    }

    private int alturaRec(ProgramaNodo nodo) {
        // Si el nodo es nulo, la altura de este subárbol es 0.
        if (nodo == null) {
            return 0;
        }
        return 1 + Math.max(alturaRec(nodo.getIzquierdo()), alturaRec(nodo.getDerecho()));
    }

    public boolean esCompleto() {
        int altura = altura();
        return esComRec(raiz, 0, altura);
    }

    private boolean esComRec(ProgramaNodo nodo, int nivel, int altura) {
        if (nodo == null) {
            return true;
        }

        if (nivel >= altura) {
            return false;
        }

        return esComRec(nodo.getIzquierdo(), nivel + 1, altura)
                && esComRec(nodo.getDerecho(), nivel + 1, altura);
    }

    public int contarNodos() {
        return contarNodosRec(raiz);
    }

    private int contarNodosRec(ProgramaNodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + contarNodosRec(nodo.getIzquierdo()) + contarNodosRec(nodo.getDerecho());
    }

}

