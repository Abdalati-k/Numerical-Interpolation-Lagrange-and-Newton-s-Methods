import java.util.Scanner;
public class Run {

    static double numerator(double p, int n)
    {
        double numerator_sum = p;

        for (int i = 1; i < n; i++)

            numerator_sum = numerator_sum * (p - i);

        return numerator_sum;
    }

// calculating factorial denominator
    static int fact(int n)
    {

        int f = 1;

        for (int i = 1; i <= n; i++)

            f *= i;

        return f;
    }


    public static void main(String[] args)
    {
  Scanner sc = new Scanner(System.in);
        // inter values of x
        System.out.print("Enter No of terms : ");
        int n = sc.nextInt();

        //Entering x values and find h
        double [] x = new double[n];

        System.out.print("Enter x0 value : ");
        x[0] = sc.nextDouble();

        System.out.print("Enter x1 value : ");
        x[1] = sc.nextDouble();


        while (x[1] <  x[0]) {
            System.out.println("x1 must be bigger than x0 please reenter x1 again");
            System.out.print("Enter x1 value : ");
            x[1] = sc.nextDouble();
        }
        double h =  (x[1] - x[0]); // calculating h
        System.out.println("___________");
        System.out.println("h = " + h);
        System.out.println("___________");



        double pp = h + x[1];
        for (int i = 2 ; i<n ; i++){
          x[i] = pp;
          if (i<n)
          pp = x[i] + h;

    }

        //display x values
        System.out.print("x values =  \t");
        for (int i = 0; i < n; i++)
            System.out.print(x[i] + "  \t");
            System.out.println();



        // y[][] is used for difference table

        // with y[][0] used for f(x) values

        double y[][]=new double[n][n];
        for (int i = 0 ; i<n ; i++) {
            System.out.print("Enter f(x"+ i + ") value : ");
            y[i][0] = sc.nextDouble();
        }


        // Calculating the  difference table
        // i start from 1 because we already have f(x) values
        for (int i = 1; i < n; i++) {

            for (int j = 0; j < n - i; j++)

                y[j][i] = y[j + 1][i - 1] - y[j][i - 1];

        }


        // Displaying the forward difference table

        for (int i = 0; i < n; i++) {

            System.out.print(x[i]+"  \t");
        // n - i for we dont want to see zeros
            for (int j = 0; j < n - i; j++)

                System.out.print(y[i][j]+"  \t");

            System.out.println();

        }


        // Value to interpolate at value
        System.out.print("Enter the value which you want to find interpolate at : ");

        double value = sc.nextDouble() ;



        double interpolate = y[0][0];
        double p = (value - x[0]) / h; // Calculating P

        for (int i = 1; i < n; i++) {

            interpolate = interpolate + (numerator(p, i) * y[0][i]) / fact(i);



        }


        System.out.println("\nValue at "+value+" is "+String.format("%.6g%n",interpolate));

    }
}