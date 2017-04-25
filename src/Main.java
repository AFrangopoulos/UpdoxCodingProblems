import java.util.List;
import java.util.Scanner;

/**
 * Created by AFrangopoulos on 4/22/2017.
 */
public class Main {

    //input: list<Integers>
    //output: void - prints list of ints
    public static void print(List<Integer> list){
        if(list.isEmpty())
            System.out.println("Empty List: No primes");
        //for(int n:list){ System.out.print(n);  }
        for(int i = 0; i < list.size(); ++i){
            if(i != list.size()-1){
                System.out.print(list.get(i) + ", ");
            }
            else{
                System.out.println(list.get(i));
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter two values for the range you want and then press Enter." +
                "\nFor example, \"1 100\" for all primes from [1 to 100] :");
        int startingValue = in.nextInt();
        int endingValue = in.nextInt();
        in.close();

        PrimeNumber prime = new PrimeNumber();
        List<Integer> primeList = prime.generate(startingValue,endingValue);
        print(primeList);
    }
}
