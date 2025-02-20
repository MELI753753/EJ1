package org.example.model;

public class QueueOfStacks {
    private StaticStack[] array;  // cada posición es una pila (fila de la matriz)
    private int front;            // índice de la cabecera
    private int count;            // cuántas pilas hay en la cola
    private final int max;        // capacidad máxima (igual a n)

    public QueueOfStacks(int n) {
        this.max = n;
        this.array = new StaticStack[n];
        this.front = 0;
        this.count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == max;
    }

    // Encola una pila al final
    public void enqueue(StaticStack st) {
        if (isFull()) {
            throw new RuntimeException("QueueOfStacks llena");
        }
        int pos = (front + count) % max;
        array[pos] = st;
        count++;
    }

    // Desencola y retorna la pila del frente
    public StaticStack dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("QueueOfStacks vacia");
        }
        StaticStack st = array[front];
        front = (front + 1) % max;
        count--;
        return st;
    }

    // Retorna cuántas pilas hay en la cola
    public int size() {
        return count;
    }
}