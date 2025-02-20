package org.example;

import org.example.model.QueueOfStacks;
import org.example.model.StaticStack;
import org.example.model.MatrixOperations;

public class Main {
    public static void main(String[] args) {
        int n = 3;

        // Construimos manualmente la matriz 3x3: [ [1,2,3], [4,5,6], [7,8,9] ]
        QueueOfStacks qOfStacks = new QueueOfStacks(n);

        // Fila 0
        StaticStack row0 = new StaticStack();
        row0.add(1); // col 0
        row0.add(2); // col 1
        row0.add(3); // col 2
        qOfStacks.enqueue(row0);

        // Fila 1
        StaticStack row1 = new StaticStack();
        row1.add(4);
        row1.add(5);
        row1.add(6);
        qOfStacks.enqueue(row1);

        // Fila 2
        StaticStack row2 = new StaticStack();
        row2.add(7);
        row2.add(8);
        row2.add(9);
        qOfStacks.enqueue(row2);

        // OPCIONAL: Imprimir la matriz original (destructivo + reconstrucción)
        MatrixOperations.printMatrix(qOfStacks, "Matriz original");

        // 1) Calcular traza (destruye la estructura, pero la reconstruimos en el método)
        int traza = MatrixOperations.trace(qOfStacks);
        System.out.println("Traza = " + traza);  // Debería imprimir 15 (1 + 5 + 9)

        // 2) Generar una matriz caracol de dimensión n y mostrarla
        QueueOfStacks snail = MatrixOperations.snailMatrix(n);
        MatrixOperations.printMatrix(snail, "Matriz caracol");

        // 3) Obtener la traspuesta de la matriz caracol y mostrarla
        QueueOfStacks snailT = MatrixOperations.transpose(snail);
        MatrixOperations.printMatrix(snailT, "Matriz caracol traspuesta");
    }
}