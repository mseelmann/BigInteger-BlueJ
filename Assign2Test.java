import java.math.BigInteger;
import java.util.Random;
import java.util.Arrays;
public class Assign2Test {
    public static void main(String[] args) {

        Assign2 a = new Assign2();
        System.out.println(a);

        //Extra test code:
        try {
            BigInteger[] col2 = a.column(2); //x is valid column number
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }

        try {
            BigInteger[] row8 = a.row(8); //x is not valid row number
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }

        BigInteger[][] copy = a.copy();
        a.sortCol();
        System.out.println("\nSorted by column then by row:\n"+a);
        Assign2 aCopy = new Assign2(copy);
        aCopy.sortRow();
        System.out.println("Sorted by row then by column:\n"+aCopy);

        Boolean b = a.check();
        System.out.println("sortRow() and sortCol() give the same result? "+b);

    }
}