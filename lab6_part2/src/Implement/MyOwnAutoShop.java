package Implement;
import Interface.Admin;
import ad211.dovbyshev.Car;
import ad211.dovbyshev.Truck;
import ad211.dovbyshev.Ford;
import ad211.dovbyshev.Sedan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class MyOwnAutoShop implements Admin {
    private final int range = 5;
    Car[] carArray = {new Truck(range), new Ford(range), new Sedan(range)};
    public void getIncome(double price) throws IOException{
        File summaryText = new File("Income.rtf");
        Scanner file = new Scanner (summaryText);
        double sum = 0;
        while (file.hasNextLine()){
            sum = Double.parseDouble(file.nextLine());
        }
        sum += price;
        FileWriter writer = new FileWriter(summaryText, false);
        System.out.printf("\n\nIncome: %.2f$", sum);
        writer.write(String.valueOf(sum));
        writer.close();
    }

    public void getIsSellOut(int id){
        Random rand = new Random();
        boolean[] bool = new boolean[range];
        for (int i = 0; i < range; i++)
            bool[i] = rand.nextBoolean();
        carArray[id].setIsSellOut(bool);
    }

    public void getCarSpeed(int id) throws FileNotFoundException{
        File speedText = new File("/Users/mac/IdeaProjects/lab6_part2/Speed.rtf");
        Scanner file = new Scanner (speedText);
        int[] speed = new int[range];
        int i = 0;
        while (file.hasNextLine()){
            speed[i] = Integer.parseInt(file.nextLine());
            if (id == 0)
                speed[i] -= 20;
            else if (id == 2)
                speed[i] += 20;
            i++;
        }
        carArray[id].setSpeed(speed);
    }

    public void getCarPrice(int id) throws FileNotFoundException{
        File priceText = new File("/Users/mac/IdeaProjects/lab6_part2/Price.rtf");
        Scanner file = new Scanner (priceText);
        double[] price = new double[range];
        int i = 0;
        while (file.hasNextLine()){
            price[i] = Integer.parseInt(file.nextLine());
            if (id == 0)
                price[i] -= 2000;
            else if (id == 2)
                price[i] += 2000;
            i++;
        }
        carArray[id].setRegularPrice(price);
    }

    public void getCarColor(int id) throws FileNotFoundException{
        File colorText = new File("/Users/mac/IdeaProjects/lab6_part2/Color.rtf");
        Scanner file = new Scanner (colorText);
        String[] color = new String[range];
        int i = 0;
        while (file.hasNextLine()){
            color[i] = file.nextLine();
            i++;
        }
        carArray[id].setColor(color);
    }

    public void purchaseCar(int id) throws IOException{
        setCarSetting(id);
        Scanner scanner = new Scanner(System.in);
        int answer;
        for(int i = 0; i < range; i++){
            System.out.print("\n#" + (i+1) + " - " + carArray[id].getSpeed()[i] + " km/h, " + carArray[id].getColor()[i] + ", ");
            if (id == 0)
                System.out.print(((Truck)carArray[id]).getWeight()[i] + " kg, ");
            else if (id == 1)
                System.out.printf(((Ford)carArray[id]).getYear()[i] + " year, -%.2f$ discount, ", ((Ford)carArray[id]).getManufacturerDiscount()[i]);
            else
                System.out.print(((Sedan)carArray[id]).getLength()[i] + " cm, ");
        }
        do{
            System.out.println("\n");
            answer = scanner.nextInt();
            if (!carArray[id].getIsSellOut()[answer - 1])
                System.out.print("\nOut of stock.");
        } while ((answer > 10||answer < 1) || !carArray[id].getIsSellOut()[answer - 1]);
    }

    private void gettingFord(int id) throws FileNotFoundException{
        if (id==1) {
            File yearText = new File("/Users/mac/IdeaProjects/lab6_part2/Year.rtf");
            File discountText = new File("/Users/mac/IdeaProjects/lab6_part2/Discount.rtf");
            Scanner y = new Scanner(yearText);
            Scanner d = new Scanner(discountText);
            int[] year = new int[range];
            double[] discount = new double[range];
            int i = 0;
            while (y.hasNextLine()) {
                year[i] = Integer.parseInt(y.nextLine());
                discount[i] = Integer.parseInt(d.nextLine());
                i++;
            }
            ((Ford) carArray[id]).setYear(year);
            ((Ford) carArray[id]).setManufacturerDiscount(discount);
        }
    }

    private void gettingWeight(int id) throws FileNotFoundException{
        if (id==0){
            File weightText = new File("/Users/mac/IdeaProjects/lab6_part2/Weight.rtf");
            Scanner file = new Scanner(weightText);
            int[] weight = new int[range];
            int i = 0;
            while (file.hasNextLine()) {
                weight[i] = Integer.parseInt(file.nextLine());
                i++;
            }
            ((Truck) carArray[id]).setWeight(weight);
        }
    }

    private void gettingLength(int id) throws FileNotFoundException{
        if (id == 2) {
            File lengthText = new File("/Users/mac/IdeaProjects/lab6_part2/Length.rtf");
            Scanner file = new Scanner(lengthText);
            int[] length = new int[range];
            int i = 0;
            while (file.hasNextLine()) {
                length[i] = Integer.parseInt(file.nextLine());
                i++;
            }
            ((Sedan) carArray[id]).setLength(length);
        }
    }

    private void setCarSetting(int id) throws FileNotFoundException{
        getIsSellOut(id);
        getCarSpeed(id);
        getCarPrice(id);
        getCarColor(id);
        gettingWeight(id);
        gettingFord(id);
        gettingLength(id);
    }
}