package co.com.udem.arbol;
public class ProgramaNodo {
    private final int valor;
    private ProgramaNodo izquierdo;
    private ProgramaNodo derecho;
    public ProgramaNodo(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }

    public int getValor() {
        return valor;
    }

    public ProgramaNodo getIzquierdo() {
        return izquierdo;
    }
    public void setIzquierdo(ProgramaNodo izquierdo) {
        this.izquierdo = izquierdo;
    }
    public ProgramaNodo getDerecho() {
        return derecho;
    }
    public void setDerecho(ProgramaNodo derecho) {
        this.derecho = derecho;
    }
}

