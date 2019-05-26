package example;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    private Tarta[] tartas;
    private int capacity;

    public Knapsack(Tarta[] tartas, int capacity) {
        this.tartas = tartas;
        this.capacity = capacity;
    }

    public void display(){
        if(tartas!=null && tartas.length>0){
            System.out.println("\nKnapsack Solution");
            System.out.println("Capacidad = " + capacity);
            System.out.println("Tartas que tiene que coger");
            for(Tarta tartas : tartas){
                System.out.println("---" + tartas.str());
            }
        }
    }

    public Solution solve(){
        int nbTartas = tartas.length;
        int[][] matrix = new int[nbTartas + 1][capacity + 1];

        // first line is initialized to 0
        for (int i = 0; i <= capacity; i++)
            matrix[0][i] = 0;

        // we iterate on items
        for (int i = 1; i <= nbTartas; i++) {
            // we iterate on each capacity
            for (int j = 0; j <= capacity; j++) {
                if (tartas[i - 1].weight > j)
                    matrix[i][j] = matrix[i-1][j];
                else
                    // we maximize value at this rank in the matrix
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i-1][j - tartas[i-1].weight]
                            + tartas[i-1].value);
            }
        }

        int res = matrix[nbTartas][capacity];
        int w = capacity;
        List<Tarta> itemsSolution = new ArrayList<>();

        for (int i = nbTartas; i > 0  &&  res > 0; i--) {
            if (res != matrix[i-1][w]) {
                itemsSolution.add(tartas[i-1]);
                // we remove items value and weight
                res -= tartas[i-1].value;
                w -= tartas[i-1].weight;
            }
        }

        return new Solution(itemsSolution, matrix[nbTartas][capacity]);
    }

}

