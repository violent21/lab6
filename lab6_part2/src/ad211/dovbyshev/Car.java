package ad211.dovbyshev;

public abstract class Car {

    int[] speed;
    boolean[] isSellOut;
    double[] regularPrice;
    String[] color;

    public Car(int maxNumber){
        color = new String[maxNumber];
        speed = new int[maxNumber];
        regularPrice = new double[maxNumber];
        isSellOut = new boolean[maxNumber];
    }

    public int[] getSpeed() {
        return speed;
    }

    public boolean[] getIsSellOut() {
        return isSellOut;
    }

    public String[] getColor() {
        return color;
    }

    public void setColor(String[] color) {
        this.color = color;
    }

    public void setRegularPrice(double[] regularPrice) {
        this.regularPrice = regularPrice;
    }

    public void setIsSellOut(boolean[] sellOut) {
        isSellOut = sellOut;
    }

    public void setSpeed(int[] speed) {
        this.speed = speed;
    }

    public abstract double getSalePrice(int number);
}
