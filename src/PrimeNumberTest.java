import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AFrangopoulos on 4/22/2017.
 */
public class PrimeNumberTest {
    private final int EVEN_BOTTOM = 4;
    private final int EVEN_TOP = 100;//Pick any even number you want to test to.
    private PrimeNumber number;
    private List<Integer> list;

    @Before //do any initializations or any ctor work here
    public void before(){
        number = new PrimeNumber();
        list = new ArrayList<>();
    }

    //Primality Tests
    @Test
    public void isANaturalNumber(){
        //0 to infinity are Natural.  Negative numbers are not. Must be positive counting number, but 'int' takes care of that.
        Assert.assertFalse("-7 is not a natural number and therefore not prime.",number.isPrime(-7));
    }
    @Test
    public void zeroAndOneAreNotPrime(){
        Assert.assertFalse("0 is not prime", number.isPrime(0));
        Assert.assertFalse("1 is not prime", number.isPrime(1));
    }
    @Test
    public void twoIsPrime(){
        Assert.assertTrue("2 is a prime number.", number.isPrime(2));
    }
    @Test//check arbitrary amount of even numbers for primality
    public void evenNumbersExceptTwoAreNotPrime(){
        for(int i = EVEN_BOTTOM; i <= EVEN_TOP; i += 2) {
            String s = String.valueOf(i) + " is not prime.";
            Assert.assertFalse(s, number.isPrime(i));
        }
    }
    @Test
    public void isOnlyDivisibleByOneAndItself(){
        //even numbers have been checked already, so let's check some odd numbers that are not prime
        Assert.assertFalse("21 is not prime", number.isPrime(21));
        Assert.assertFalse("35 is not prime", number.isPrime(35));
    }

    //generate() Tests
    @Test
    public void generateReturnsANonEmptyListStandardRange(){
        list = number.generate(7900,7920);
        Assert.assertTrue("generate did not add primes to list",!list.isEmpty());
    }
    @Test
    public void generateReturnsValuesWithInclusiveRange(){
        list = number.generate(1,11);//11 should be last element in the list.
        Assert.assertTrue("not inclusive", list.contains(11));
    }
    @Test
    public void generateReturnsNonEmptyListWithInvertedRange(){
        list = number.generate(10,1);
        Assert.assertFalse("list should not be empty", list.isEmpty());
    }
    @Test
    public void generateReturnsSameListForStdAndInvertedRange(){
        list = number.generate(1,100);
        List<Integer> tempList = number.generate(100,1);
        Assert.assertTrue("Lists are not equal with same range", list.equals(tempList));
    }
    @Test
    public void generateReturnsEmptyListWhenNoValidPrimesInRange(){
        list = number.generate(-100,-1);
        Assert.assertTrue("",list.isEmpty());
        list = number.generate(-2,1);
        Assert.assertTrue("",list.isEmpty());
        list = number.generate(1,-3);
        Assert.assertTrue("",list.isEmpty());
        list = number.generate(1,1);
        Assert.assertTrue("",list.isEmpty());
    }
}
