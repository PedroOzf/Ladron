package example;

public class Tarta {
    public String name;
    public int value;
    public int weight;

    public Tarta(String name, int value, int weight) {
        this.name = name;
        this.value = value;
        this.weight = weight;
    }

    public String str(){
        return name + " Value : " + value + " Weight : " + weight;
    }
}
