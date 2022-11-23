package ad211.dovbyshev;

public class Ford extends Car{

    private int[] year;
    private double[] manufacturerDiscount;

    public Ford(int maxNumber){
        super(maxNumber);
        year = new int[maxNumber];
        manufacturerDiscount = new double[maxNumber];
    }

    public double[] getManufacturerDiscount() {
        return manufacturerDiscount;
    }

    public int[] getYear() {
        return year;
    }

    public void setManufacturerDiscount(double[] manufacturerDiscount) {
        this.manufacturerDiscount = manufacturerDiscount;
    }

    public void setYear(int[] year) {
        this.year = year;
    }

    @Override
    public double getSalePrice(int number) {
        return regularPrice[number] - manufacturerDiscount[number];
    }
}