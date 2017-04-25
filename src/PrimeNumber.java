import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by AFrangopoulos on 4/22/2017.
 */
public class PrimeNumber implements PrimeNumberGenerator {
    //Note: avoided having a private List and getter/setters.
    //decreases test coverage and I avoid setters/getters if possible.
    //This class doesnt really have a "state".  If generate signature was void, I
    //would have used a private list that I updated and have also added print() in this class.

    @Override
    public List<Integer> generate(final int startingValue, final int endingValue) {
        if( startingValue < 0 && endingValue < 0)
            return Collections.emptyList();

        List<Integer> listOfPrimes = new ArrayList<>();

//bottom and top are used to deal with inverted input ranges
        int bottom = Math.min(startingValue,endingValue);
        int top = Math.max(startingValue,endingValue);

        for(int i = bottom; i <= top; ++i)
        {
            if(isPrime(i))
                listOfPrimes.add(i);
        }
        return listOfPrimes;
    }

    @Override
    public boolean isPrime(final int value) {
        if( value < 2 || (value > 2 && value % 2 == 0))
            return false;
        /*algorithm refactoring for better performance. Only check values we need to.
        if c = a*b, and a<=b....then we know that a^2 <= a*b = n.*/
        int top = (int)Math.floor(Math.sqrt(value));
        for(int i = 3; i <= top; i+=2)
        {
            if(value % i == 0)
                return false;
        }
        return true;
    }
}
