package Intefaces;
public interface IntfLlista {
    
    public int length();
    
    // Per afegir un element
    public void afegirElement(Object obj);
    
    // Per obtenir l'element i-èssim
    public Object getElement(int i);
    
    // Per comprovar si la llista ja compté l'element obj
    public boolean compte(Object obj);
    
    // Per ordenar la llista
    public void sort();
    
    // Per eliminar l'element i-èssim
    public void eliminarElement(int i);
    
    
    // Per convertir la llista en un String
    @Override
    public String toString();
    
}
