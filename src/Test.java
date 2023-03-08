import java.text.DecimalFormat;

public class Test {
    public static void main(String[] args) {
        double number = 3.14159;
        double roundedNumber = Math.round(number * 100.0) / 100.0;
        System.out.println(roundedNumber);
    }
}
