package com.example.project;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Exercise2 obj = new Exercise2();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            System.out.println(obj.existenDuplicados(s));
        }
    }

    public boolean existenDuplicados(String str) {
        MyStack<Character> stack = new LinkedListStack<>();
        // Colocar codigo aqui
        String letra= "";
        int cont= 0; //Indica el número de abiertos
        for(int i= 0; i< str.length(); i++){ // Recorre letra por letra
            letra= String.valueOf(str.charAt(i)); // Extrae la letra
            if(letra.equals("(")){ // Verifica si es un simbolo de abertura
                cont++; //Aumenta el número de abiertos
                stack.push(letra.charAt(0)); // Lo agrega a la pila
            }
            else if(letra.equals(")")){ // verifica si es simbolo de cierre
                if("x".equals(String.valueOf(stack.top())) && cont > 0){ // Verifica que no este vacio y si hay algun abierto
                    stack.pop(); // Retira lo de adentro
                    stack.pop(); // Retira el de abertura
                    cont--; // Disminuye el numero de abiertos
                }
                else{
                    return true; //Hay un parentesis vacio
                }
            }
            else {
                if(!"x".equals(String.valueOf(stack.top()))){ //Cualquier caracter es convertido a x (sin repeticiones)
                    stack.push("x".charAt(0));  
                }
            }
        }
        if(String.valueOf(stack.top()).equals("x")){ //Remueve las x (numeros u operaciones) restantes
            stack.pop();   
        }
        return !stack.isEmpty(); // Verifica que este vacia la lista despues del recorrido
    }
}
