package Interfaces;
public interface IntfLlista {
    
    public int length();
    
    // Per afegir un element
    public void afegirElement(Object obj);
    
    // Per obtenir l'element i-èssim
    public Object getElement(int i);
    
    // Per comprovar si la llista ja compté l'element obj
    public boolean compte(int codi);
    
    // Per ordenar la llista
    public void sort();
    
    // Per eliminar l'element i-èssim
    public void eliminarElement(int i);
    
    // afegeix un element a la posició i-èssima
    public void afegirElement(Object obj, int pos);
    
}
