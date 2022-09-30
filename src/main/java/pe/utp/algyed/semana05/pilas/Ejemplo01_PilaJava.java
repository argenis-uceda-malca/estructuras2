package pe.utp.algyed.semana05.pilas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Stack;
/**
 *
 * @author DAVID VERA
 */
public class Ejemplo01_PilaJava {
    public static void main(String[] args){
        Stack<String> pila = new Stack<String>();
        
        pila.push("A");
        pila.push("B");
        pila.push("C");
        pila.push("D");
        
        //Imprimir la parte superior del stack : D
        System.out.println("El elemento superior es: "+ pila.peek());
        
        //Quitar elemento de la pila
        pila.pop();
        pila.pop();
        System.out.println("El elemento superior luego de hacer pop es: "+ pila.peek());
        
        //tamaño de la pila
        System.out.println("El tamaño de la pila es: "+ pila.size());
        
        //validar si la pila aesta vacia
        if(pila.empty()){
            System.out.println("La pila está vacía");
        }else{
            System.out.println("La pila no está vacía");
        }
    }
}
