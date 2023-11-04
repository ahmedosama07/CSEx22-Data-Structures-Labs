import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public int fibonacci(int n) {
    	int fib[] = new int[n];
        fib[0] = 0;
        if (n > 1) {
            fib[1] = 1;
            for (int i = 2; i <= n-1; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
        }
        return fib[n-1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int f = new Solution().fibonacci(num);
        System.out.println(f);
    }
}