package ad211.dovbyshev;

import Implement.MyOwnAutoShop;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) throws IOException{
        MyOwnAutoShop shop = new MyOwnAutoShop();
        Scanner scanner = new Scanner(System.in);
        int answer;
        do {
            System.out.println("1. Truck\n2. Ford\n3. Sedan");
            answer = scanner.nextInt();
        } while (answer > 3||answer < 1);
        answer--;
        shop.purchaseCar(answer);
    }
}