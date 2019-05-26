package example;

public class Main {
    public static void main(String[] args) {
        Tarta[] tartas = {new Tarta("pinneapple",4,2),
                new Tarta("Manzana",4,2),
                new Tarta("Pizza",12,6),
                new Tarta("Mercurio",4,10)};

        Knapsack knapsack = new Knapsack(tartas,15);
        Solution solution = knapsack.solve();
        solution.display();
    }
}
