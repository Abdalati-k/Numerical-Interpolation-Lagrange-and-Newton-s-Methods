import java.util.Scanner;
public class Run {



        public static void main(String[] args)
        {
            //Declaration of the scanner variable
            Scanner myScanner = new Scanner(System.in);

            //Declaration of variables
            int count, count2; //Loop variables, for counting loops

            double value ; //interpolate value at x
            double interpolate = 0; //interpolate value
            double numerator;
            double denominator;

            //No. of elements
            System.out.print("Enter No of terms : ");
            int n = myScanner.nextInt();
            double [] x = new double[n];
            double [] y = new double[n];


            // Enter x values
            for(count = 0; count<n; count++) //Start the loop for X
            {
                System.out.print("Enter  x" + count + " value : ");
                x[count] = myScanner.nextDouble();
            }


            // Enter y values
            for(count = 0; count<n; count++) // loop for Y
            {
                System.out.print("Enter f(x"+ count + ") value : ");
                y[count] = myScanner.nextDouble();
            }


            System.out.print("Enter the value which you want to find interpolate at : ");
            value = myScanner.nextDouble();

            //first Loop for the polynomial calculation
            for(count = 0; count<n; count++)
            { // loop 1
                numerator = 1; denominator = 1;
                //second Loop for the polynomial calculation
                for(count2 = 0; count2<n; count2++)
                { //loop 2 L
                    if (count2 != count)
                    { // if
                        numerator = numerator * (value - x[count2]);
                        denominator = denominator * (x[count] - x[count2]);
                    } //if
                } // loop2 Ln
                 interpolate  = interpolate + (numerator/denominator) * y[count]; //
            } //loop 1
            System.out.println("When x = " + value + "," + " y = " +  interpolate);
        }
    }


