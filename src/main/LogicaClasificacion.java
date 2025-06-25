package main;

import java.util.*;

public class LogicaClasificacion {

    public String invertirCadena(String texto) {
        Stack<Character> pila = new Stack<>();
        for (char c : texto.toCharArray()) {
            pila.push(c);
        }
        StringBuilder invertido = new StringBuilder();
        while (!pila.isEmpty()) {
            invertido.append(pila.pop());
        }
        return invertido.toString();
    }

    public boolean validarSimbolos(String expresion) {
        Stack<Character> pila = new Stack<>();
        Map<Character, Character> pares = new HashMap<>();
        pares.put(')', '(');
        pares.put(']', '[');
        pares.put('}', '{');

        for (char c : expresion.toCharArray()) {
            if (pares.containsValue(c)) {
                pila.push(c);
            } else if (pares.containsKey(c)) {
                if (pila.isEmpty() || pila.pop() != pares.get(c)) {
                    return false;
                }
            }
        }

        return pila.isEmpty();
    }
    public List<Integer> ordenarPila(Stack<Integer> pila) {
        Stack<Integer> auxiliar = new Stack<>();

        while (!pila.isEmpty()) {
            int temp = pila.pop();
            while (!auxiliar.isEmpty() && auxiliar.peek() > temp) {
                pila.push(auxiliar.pop());
            }
            auxiliar.push(temp);
        }

    List<Integer> resultado = new ArrayList<>();
    while (!auxiliar.isEmpty()) {
        resultado.add(0, auxiliar.pop());
    }
    return resultado;
}
    public List<Integer> clasificarPorParidad(LinkedList<Integer> original) {
        List<Integer> pares = new LinkedList<>();
        List<Integer> impares = new LinkedList<>();

        for (int num : original) {
            if (num % 2 == 0) {
                pares.add(num);
            } else {
                impares.add(num);
            }
        }

        List<Integer> resultado = new LinkedList<>(pares);
        resultado.addAll(impares);
        return resultado;
    }
}
