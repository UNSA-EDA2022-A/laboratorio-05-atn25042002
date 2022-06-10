package com.example.project;

import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {
        Exercise1 obj = new Exercise1();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            System.out.println(obj.esBalanceado(s));
        }
    }

    public boolean esBalanceado(String s) {
        MyStack<Character> stack = new LinkedListStack<>();
        // Colocar codigo aqui
        String letra= "", abertura= "{([", cierre ="})]", equiv;
        for(int i= 0; i< s.length(); i++){ // Recorre letra por letra
            letra= s.charAt(i); // Extrae la letra
            if(abertura.indexOf(letra)>= 0){ // Verifica si es un simbolo de abertura
                stack.push(letra.charAt(0)); // Lo agrega a la pila
            }
            else if(cierre.indexOf(letra)>= 0){ // verifica si es simbolo de cierre
                equiv= abertura.charAt(cierre.indexOf(letra)); // Obtiene el simbolo de abertura equivalente
                if(equiv.equals(stack.top())){ // Verifique que el ultimo simbolo de abertura corresponda con el ultimo de cierre ingresado
                    stack.pop(); //Si coincide lo retira
                }
                else{
                    return false; //Si no coincide es porque es porque no esta balanceado
                }
            }
        }
        return stack.isEmpty(); // Verifica que este vacia la lista despues del recorrido
    }
}
