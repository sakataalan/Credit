import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        long creditCardNumber = scanNumber();
        int oddNumbers = sumOfSecondToLastDigit(creditCardNumber);
        int evenNumbers = sumOfRemainDigits(creditCardNumber);
        boolean isValid = result(oddNumbers, evenNumbers);

        if (isValid) {
            System.out.println("valido");
        } else {
            System.out.println("invalido");
        }
    }
    
    static long scanNumber() {
        
        Scanner scan = new Scanner(System.in);
        long creditCardNumber = 0;
        boolean isNaN;

        do {
            try {
                System.out.println("Digite o número do cartão: ");
                creditCardNumber = scan.nextLong();
                isNaN = false;
            } catch (Exception e) {
                System.out.println("Apenas números");
                scan.nextLine();
                isNaN = true;
            }
        } while (isNaN || creditCardNumber <= 0);
        
        scan.close();
        return creditCardNumber;
    }

    static int sumOfSecondToLastDigit(long creditCardNumber) {
        creditCardNumber /= 10;
        int sum = 0;

        while (creditCardNumber > 0) {
            sum += (((creditCardNumber % 10) * 2) / 10) + (((creditCardNumber % 10) * 2) % 10);
            creditCardNumber /= 100;
        }

        return sum;
    }

    static int sumOfRemainDigits(long creditCardNumber) {
        int sum = 0;

        while (creditCardNumber > 0) {
            sum += creditCardNumber % 10;
            creditCardNumber /= 100;
        }

        return sum;
    }

    static boolean result(int oddNumbers, int evenNumbers) {
        return (oddNumbers + evenNumbers) % 10 == 0; 
    }

}
