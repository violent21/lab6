package ad211.dovbyshev;

public class Sedan extends Car{

    private int[] length;

    public Sedan(int maxNumber){
        super(maxNumber);
        length = new int[maxNumber];
    }

    @Override
    public double getSalePrice(int number) {
        if (length[number] > 20)
            return regularPrice[number] * (1 - 0.05);
        else
            return regularPrice[number];
    }

    public int[] getLength() {
        return length;
    }

    public void setLength(int[] length) {
        this.length = length;
    }
}