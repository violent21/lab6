package ad211.dovbyshev;

public class Truck extends Car{

    private int[] weight;

    public Truck(int maxNumber){
        super(maxNumber);
        weight = new int[maxNumber];
    }

    public int[] getWeight() {
        return weight;
    }

    public void setWeight(int[] weight) {
        this.weight = weight;
    }

    @Override
    public double getSalePrice(int number) {
        if (weight[number] > 2000)
            return regularPrice[number] * (1 - 0.1);
        else
            return regularPrice[number];
    }
}