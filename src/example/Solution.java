package example;

import java.util.List;

public class Solution {
    public List<Tarta> tartas;
    public int value;

    public Solution(List<Tarta> tartas, int value) {
        this.tartas = tartas;
        this.value = value;
    }

    public void display(){

            if(tartas!=null && !tartas.isEmpty()){
                System.out.println("\nKnapsack Solution");
                System.out.println("Value = " + value);
                System.out.println("Tartas que tiene que coger");
                for(Tarta tartas : tartas){
                    System.out.println("-" + tartas.str());
                }
            }
    }

}
