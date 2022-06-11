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
        int cont= 0;
        for(int i= 0; i< str.length(); i++){ // Recorre letra por letra
            letra= String.valueOf(str.charAt(i)); // Extrae la letra
            if(letra.equals("(")){ // Verifica si es un simbolo de abertura
                cont++
                stack.push(letra.charAt(0)); // Lo agrega a la pila
            }
            else if(letra.equals(")")){ // verifica si es simbolo de cierre
                if("x".equals(String.valueOf(stack.top())) && cont > 0){ // Verifique que el ultimo simbolo de abertura corresponda con el ultimo de cierre ingresado
                    stack.pop(); //Si coincide lo retira
                    stack.pop();
                    cont--;
                }
                else{
                    return true; //Si no coincide es porque es porque no esta balanceado
                }
            }
            else {
                if(!"x".equals(String.valueOf(stack.top()))){
                    stack.push("x".charAt(0));  
                }
            }
        }
        if(String.valueOf(stack.top()).equals("x")){
            stack.pop();   
        }
        return !stack.isEmpty(); // Verifica que este vacia la lista despues del recorrido
    }
}
