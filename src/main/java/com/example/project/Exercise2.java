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
        String letra= "", abertura= "{([", cierre ="})]", equiv;
        for(int i= 0; i< s.length(); i++){ // Recorre letra por letra
            letra= String.valueOf(s.charAt(i)); // Extrae la letra
            if(abertura.indexOf(letra)>= 0){ // Verifica si es un simbolo de abertura
                stack.push(letra.charAt(0)); // Lo agrega a la pila
            }
            else if(cierre.indexOf(letra)>= 0){ // verifica si es simbolo de cierre
                equiv= String.valueOf(abertura.charAt(cierre.indexOf(letra))); // Obtiene el simbolo de abertura equivalente
                if(equiv.equals(String.valueOf(stack.top()))){ // Verifique que el ultimo simbolo de abertura corresponda con el ultimo de cierre ingresado
                    stack.pop(); //Si coincide lo retira
                }
                else{
                    return true; //Si no coincide es porque es porque no esta balanceado
                }
            }
        }
        return !stack.isEmpty(); // Verifica que este vacia la lista despues del recorrido
    }
}
