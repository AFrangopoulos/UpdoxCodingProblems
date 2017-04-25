import java.util.List;

/**
 * Created by AFrangopoulos on 4/22/2017.
 */
public interface PrimeNumberGenerator {
    List<Integer> generate(int startingValue, int endingValue);
    boolean isPrime(int value);
    //Note to Reader:
    // I could bring my class definition of isPrime into a default method here.
    // Highly likely that the best algorithm would be used here and then defaulted.
    //Though this is an atypical case for an interface (since it is setup this way in the test I used it as stated).
    //Normally an interface is an "adjective" and describes a noun(class) of what it "uses".
}
