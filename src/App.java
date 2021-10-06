import java.util.Scanner;

public class App {
    
    static long takeNumber(){
        Scanner scan = new Scanner(System.in);
        long ccNumber;

        do{
            System.out.println("Digite o número do cartão: ");
            ccNumber = scan.nextLong();
        }while(ccNumber == 0);

        scan.close();
        return ccNumber;
    }

    static int sumOfSecondToLastDigit(long ccNumber){
        ccNumber /= 10;
        int sum = 0;

        while(ccNumber > 0){
            sum += (((ccNumber % 10) * 2) / 10) + (((ccNumber % 10) * 2) % 10);
            ccNumber /= 100;
        }

        return sum;
    }

    static int sumOfRemainDigits(long ccNumber){
        int sum = 0;
        
        while(ccNumber > 0){
            sum += ccNumber % 10;
            ccNumber /= 100;
        }

        return sum;
    }

    public static void main(String[] args) {
        long ccNumber = takeNumber();
        int sum1 = sumOfSecondToLastDigit(ccNumber);
        int sum2 = sumOfRemainDigits(ccNumber);
        int result = sum1 + sum2;

        if(result % 10 == 0){
            System.out.println("valido");
        }else{
            System.out.println("invalido");
        }
    }
}
