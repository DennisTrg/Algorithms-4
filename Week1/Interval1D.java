/*
 Write an Interval1D client that takes an int value N as command-line argu-
ment, reads N intervals (each defined by a pair of double values) from standard input,
and prints all pairs that intersect
 */

public class Interval1D {
    
    double low;
    double high;
    String name;

    public Interval1D(String name, double low, double high) {
        this.name = name;
        this.low = low;
        this.high = high;
    }

    public Boolean intersects(Interval1D that) {
        if(this.high < that.low || that.high < this.low) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        Interval1D interval1d1 = new Interval1D("1", 3, 5);
		Interval1D interval1d2 = new Interval1D("2", 4, 5);
		Interval1D interval1d3 = new Interval1D("3", 1, 5);
		Interval1D interval1d4 = new Interval1D("4", 7, 9);
		Interval1D interval1d5 = new Interval1D("5", 1, 2);

        Interval1D[] array = new Interval1D[5];
        array[0] = interval1d1;
        array[1] = interval1d2;
        array[2] = interval1d3;
        array[3] = interval1d4;
        array[4] = interval1d5;

        for(int i = 0; i < array.length; i++) {
            for(int j = i + 1; j < array.length; j++) {
                if(array[i].intersects(array[j])) {
                    System.out.println("This pair intersect " + array[i].toString() + " " + array[j].toString());
                }
            }
        }
        
    }
}
