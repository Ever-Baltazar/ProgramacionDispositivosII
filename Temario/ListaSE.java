/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasimpleenlace;

public class ListaSE<T>
{
    private T ini;
    private ListaSE<T> sig;
    private int tamaño;
    
    public ListaSE(int tamaño)
    {
        this.tamaño = tamaño;
        ini = null;
        sig = null;
        llenar();
    }
    
    public ListaSE()
    {
        ini = null;
        sig = null;
    }
    
    public ListaSE(T ini, ListaSE<T> sig)
    {
        this.ini = ini;
        this.sig = sig;
    }
    public void llenar()
    {
        llenar(tamaño);                 
    }
    
    private void llenar(int tam)
    {
        if(tam != 0)
        {
            ini = null;
            sig = new ListaSE<T>();
            sig.llenar(tam-1);
        }
    }
    
    public boolean vacia()
    {
        return ini == null;
    }
    
    public void insertarFinal(T dato)
    {
        if(vacia())
        {
            ini = dato;
            sig = new ListaSE<T>();
        }
        else
        {
            sig.insertarFinal(dato);
        }
    }
    
    public int tamaño()
    {
        if(vacia())
        {
            return 0;
        }
        else
        {
            return sig.tamaño()+1;
        }
    }
    
    public T eliminar(int indice)
    {
        T res;
        if(vacia())
            res = null;
        else
        {            
            if(indice == 1)
            {
                res = ini;
                ini = sig.ini;
                sig = sig.sig;
            }
            else
                res = sig.eliminar(indice -1);
        }
        return res;
    }
    
    public void insertarInicio(T dato)
    {
        if(vacia())
        {
            ini = dato;
            sig = new ListaSE<T>();
        }
        else
        {
            ListaSE<T> aux = sig;
            T aux1 = ini;
            ini = dato;
            sig = new ListaSE<T>(aux1,aux);
        }
    }
    
    public T getIni()
    {
        return ini;
    }
    
    public T eliminarInicio()
    {
        T res = ini;
        ini = sig.ini;
        sig = sig.sig;
        return res;
    }
    
    public void insertar(int indice, T dato)
    {        
            if(indice == 1)
            {
                ini = dato;
            }
            else
                sig.insertar(indice-1,dato);        
    }
    
    public T obtener(int indice)
    {     
        T res;
            if(indice == 1)
                res = ini;
            else 
                res = sig.obtener(indice-1);
        return res;
    }     
}

