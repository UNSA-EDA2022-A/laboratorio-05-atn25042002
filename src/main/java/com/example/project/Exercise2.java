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
        Boolean aux = false;
        for(int i= 0; i< str.length(); i++){ // Recorre letra por letra
            letra= String.valueOf(str.charAt(i)); // Extrae la letra
            if(letra.equals("(")){ // Verifica si es un simbolo de abertura
                stack.push(letra.charAt(0)); // Lo agrega a la pila
            }
            else if(letra.equals(")") && aux){ // verifica si es simbolo de cierre
                if(")".equals(String.valueOf(stack.top()))){ // Verifique que el ultimo simbolo de abertura corresponda con el ultimo de cierre ingresado
                    stack.pop(); //Si coincide lo retira
                    aux= false;
                }
                else{
                    return true; //Si no coincide es porque es porque no esta balanceado
                }
            }
            else {
                aux= true;   
            }
        }
        return !stack.isEmpty(); // Verifica que este vacia la lista despues del recorrido
    }
}
