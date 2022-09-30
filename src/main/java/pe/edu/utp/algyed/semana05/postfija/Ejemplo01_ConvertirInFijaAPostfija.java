/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.utp.algyed.semana05.postfija;

import java.util.Stack;
/**
 *
 * @author DAVID VERA
 */
public class Ejemplo01_ConvertirInFijaAPostfija {
    
    public static void main(String[] args){
        
        String infija = "A*(B*C+D*E)+F";
        String postfija = convertirInfijaAPostfija(infija);
        System.out.println("Infija: "+infija);
        System.out.println("Postfija: "+postfija);//ABC*DE*+*F+
            
    }
    
    //Metodo para devolver la precedencia del operador dado
    // Tener en cuenta que cuando mayor es la precedencia, menor es su valor
    public static int precedencia(char c){
        //Multiplicación y división
        if(c=='*' || c=='/'){
            return 3;
        }
        //suma y resta
        if(c=='+' ||  c=='-'){
            return 4;
        }
        //AND
        if(c=='&'){
            return 8;
        }
        //OR
        if(c=='|'){
            return 10;
        }
        
        return Integer.MAX_VALUE; //Para el parentesis de apertura
        
    }
    
    //metodo para verificar si un caracter ingresado es operando
    public static boolean esOperando(char c){
        return (c>='a' && c <='z') || (c>='A' && c<='Z') ||
                (c>='0' && c<='9');
    }
    
   //Metodo para convertir expresión infija en postfija
    public static String convertirInfijaAPostfija(String infija){
        //caso base
        if (infija==null || infija.length()==0){
            return infija;
        }
        //Crear una pila para guardar los operadores
        Stack<Character> pilaOperadores  = new Stack<Character>();
        //Crear una pila par aalmacenar la expresión de postfija
        String postfija = "";
        
        //Procesar la expresión  infija de izquierda a derecha
        for(char c: infija.toCharArray()){
            //Caso 1: El caracter actual es un parentesis de apertura
            //Se debe pasar al stack
            if(c=='('){
                pilaOperadores.add(c);
            }
            //Caso 2: Si el caracter actual es un paretensis de cierre
            else if(c==')'){
                //extraer los operadores del stack hasta el parentesis de
                // apertura. Agregarlos al final de la expresión postfija
                while(pilaOperadores.peek()!='('){
                    postfija += pilaOperadores.pop();
                }
                pilaOperadores.pop();
            }
            //Caso 3: Si el caracter es un operando, agregarlo al final
            //de la expresión postfija
            else if(esOperando(c)){
                postfija += c;
            }
            //Caso 4: Si el caracter es un operador
            else{
                //Eliminar operadores de la pila con mayor o igual precedencia
                //y los agregamos al final de la expresión postfija
                while(!pilaOperadores.isEmpty() &&
                        precedencia(c) >precedencia(pilaOperadores.peek()) ){
                    postfija += pilaOperadores.pop();
                }
                //finalmente colocar el operador actual en la cima de la pila
                pilaOperadores.add(c);
            }
        }
        
        //Agregar cualquier remanentte de operadores del stack hacia el final
        // de la expresión postfija
        while(!pilaOperadores.isEmpty()){
            postfija += pilaOperadores.pop();
        }
        
        //Devolvemos la expresión postfija
        return postfija;
        
    }
    
    
      
}
