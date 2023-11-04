import java.util.*;

interface ICalculator {
    /**
    * Adds given two numbers
    * @param x first number
    * @param y second number
    * @return the sum of the two numbers
    */
    int add(int x, int y);
    /**
    * Divides two numbers
    * @param x first number
    * @param y second number
    * @return the division result
    */
    float divide(int x, int y) throws RuntimeException;
}


public class Calculator implements ICalculator{
  /* Implement your calculator class here*/
    public int add(int x, int y)
    {
        return x + y;
    }
    public float divide(int x, int y)
    {
        try {
            int q = 0;
            q = x / y;
        }
        catch (ArithmeticException e) {
            // Exception handler
            System.out.println("Error");
        }

        return (float)x / (float)y;
    }


    public static void main(String[] args)
    {
        Calculator calc = new Calculator();

        String eqn;
        int num1, num2;
        float result = 0;

        Scanner scanner = new Scanner(System.in);
        eqn = scanner.nextLine();
        scanner.close();

        eqn = eqn.replaceAll("\\s+", "");    // Handle input with white spaces

        if(eqn.indexOf("+") > -1)
        {
            num1 = Integer.parseInt(eqn.substring(0, eqn.indexOf("+")));
            num2 = Integer.parseInt(eqn.substring(eqn.indexOf("+") + 1));

            result = (float)calc.add(num1, num2);
        }
        else if(eqn.indexOf("/") > -1)
        {
            num1 = Integer.parseInt(eqn.substring(0, eqn.indexOf("/")));
            num2 = Integer.parseInt(eqn.substring(eqn.indexOf("/") + 1));

            result = calc.divide(num1, num2);
        }
        else
        {
            System.out.println("Error");
        }
        if(!Float.isInfinite(result) && !Float.isNaN(result))
        {
            if(result == (int)result)
                System.out.println(String.format("%d",(int)result));
            else
                System.out.println(String.format("%s",result));
        }
        
    }
}