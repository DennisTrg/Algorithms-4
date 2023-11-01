import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Point2D {
    public double x;
    public double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distCalculate(Point2D otherPoint2d) {
        double xDistance = this.x - otherPoint2d.x;
        double yDistance = this.y - otherPoint2d.y;
        return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
    }

    public static double closetDistance(Point2D[] arrayPointArray) {
        double minDistance = Double.MAX_VALUE;

        for(int i = 0; i < arrayPointArray.length; i++) {
            for(int j = i +1; j < arrayPointArray.length; j++) {
                double distance = arrayPointArray[i].distCalculate(arrayPointArray[j]);
                if (minDistance > distance) {
                    minDistance = distance;
                }
            }
        }
        return minDistance;
    } 

    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Provide 1 number");
        }

        int n = Integer.parseInt(args[0]);

        Point2D[] array = new Point2D[n];
        for(int i = 0; i < array.length; i++) {
            Point2D randomPoint2d = new Point2D(Math.random(), Math.random());
            array[i] = randomPoint2d;
        }
        double result;

        result = closetDistance(array);
        System.out.println(result);
    }
}
