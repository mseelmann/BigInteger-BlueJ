/**
 * @author Mary Seelmann
 * @version November 2022
 */
import java.math.BigInteger;
import java.util.Random;
import java.util.Arrays;
public class Assign2
{
    private static int n = 5;
    private BigInteger[][] m;

    /**
     * No-args Assign 2 Constructor:
     * Declares and initializes a 5 x 5 matrix with random BigInteger values [500000000,1000000000).
     */
    public Assign2()
    {
        this.m = new BigInteger[n][n];
        BigInteger max = new BigInteger("1000000000");
        BigInteger min = new BigInteger("500000000");
        Random rnd = new Random();
        int numBits = max.bitLength();
        BigInteger diff = max.subtract(min);
        
        for(int i=0; i<m.length; i++) {
            for(int j=0; j<m[0].length; j++) {
                BigInteger r = new BigInteger(numBits, rnd);
                //if r < min, add min to r to ensure value is greater than min
                if(r.compareTo(min) < 0)
                    r = r.add(min);
                //if r >= max, get remainder of r divided by the interval and add the min
                if(r.compareTo(max) >=0)
                    r = r.mod(diff).add(min);
                m[i][j] = r;
            }
        }
    }
    
    /**
     * Assign2 Constructor
     * 
     * @param m A parameter 2d BigInteger array.
     */
    public Assign2(BigInteger[][] m)
    {
        this.m = m;
    }

    /**
     * Creates a String representation of the 2d BigInteger array attribute of Assign2.
     *
     * @return The return value is the String representation of 2d BigInteger array attribute of Assign2.
     */
    public String toString()
    {
        String s = "";
        for(int i=0; i<this.m.length; i++) {
            for(int j=0; j<this.m[0].length; j++) {
                s = s + this.m[i][j] + " ";
            }
            s = s + "\n";
        }
        return s;
    }
    
    /**
     * Checks if parameter Object is equal to Assign2. 
     *
     * @param o Any object.
     * @return The return value is true if the objects are equal, otherwise it is false.
     */
    public boolean equals(Object o)
    {
        if(this==o)
            return true;
        if(o==null || this.getClass()!=o.getClass())
            return false;
        Assign2 obj = (Assign2) o;
        if(this.toString().equals(obj.toString()))
            return true;
        return false;
    }
    
    /**
     * Creates and returns a copy of the 2d array.
     *
     * @return The return value is a copy of the 2d array.
     */
    public BigInteger[][] copy()
    {
        BigInteger[][] c = new BigInteger[this.m.length][this.m[0].length];
        for(int i=0; i<c.length; i++) {
            for(int j=0; j<c[0].length; j++) {
                c[i][j] = this.m[i][j];
            }
        }
        return c;
    }
    
    /**
     * Creates and returns an array of the column of the 2d array specified by parameter int x
     *
     * @param x int value of the index of the desired column.
     * @return The return value is an array for column x.
     * @throws x must be a valid column number.
     */
    public BigInteger[] column(int x)
    {
        if(x<0 || x>this.m[0].length)
            throw new ArrayIndexOutOfBoundsException("x not in bounds");
        BigInteger[] col = new BigInteger[this.m.length];
        for(int i=0; i<col.length; i++) {
            col[i] = this.m[i][x];
        }
        return col;
    }
    
    /**
     * Creates and returns an array of the row of the 2d array specified by parameter int x.
     *
     * @param x int value of the index of the desired row.
     * @return The return value is an array for row x.
     * @throws x must be a valid row number.
     */
    public BigInteger[] row(int x)
    {
        if(x<0 || x>this.m.length)
            throw new ArrayIndexOutOfBoundsException("x not in bounds");
        return this.m[x];
    }
    
    /**
     * Returns the 2d BigInteger array attribute of Assign2 object.
     *
     * @return The return value gives the 2d BigInteger array.
     */
    public BigInteger[][] getData()
    {
        return m;
    }
    
    /**
     * Sorts the 2d BigInteger array column by column.
     */
    private void sortColOnly()
    {
        BigInteger[][] transposed = new BigInteger[this.m[0].length][this.m.length];
        for(int i=0; i<this.m.length; i++) {
            for(int j=0; j<this.m[0].length; j++) {
                transposed[j][i] = this.m[i][j];
            }
        }
        for(int i=0; i<transposed.length; i++) {
            Arrays.sort(transposed[i]);
        }
        for(int i=0; i<this.m.length; i++) {
            for(int j=0; j<this.m[0].length; j++) {
                this.m[j][i] = transposed[i][j];
            }
        }
    }
    
    /**
     * Sorts the 2d BigInteger array row by row.
     */
    private void sortRowOnly()
    {
        for(int i=0; i<this.m.length; i++) {
            Arrays.sort(m[i]);
        }
    }
    
    /**
     * First sorts the 2d BigInteger array by column, then by row.
     */
    public void sortCol() {
        this.sortColOnly();
        this.sortRowOnly();
    }
    
    /**
     * First sorts the 2d BigInteger array by row, then by column.
     */
    public void sortRow() {
        this.sortRowOnly();
        this.sortColOnly();
    }
    
    /**
     * Checks if the 2d array sorted by row first then column is the same as the 2d array sorted by column first then row.
     *
     * @return The return value is true if the sortRow() and sortCol() methods give the same reuslt, otherwise it is false.
     */
    public boolean check() {
        this.sortCol();
        BigInteger[][] colSort = this.m;
        this.sortRow();
        BigInteger[][] rowSort = this.m;
        for(int i=0; i<this.m.length; i++) {
            for(int j=0; j<this.m[0].length; j++) {
                if(colSort[i][j] != rowSort[i][j])
                    return true;
            }
        }
        return false;
    }
}