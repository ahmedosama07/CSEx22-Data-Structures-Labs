import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public int[] reverse(int[] array){
    
        int n = array.length;
        int[] temp = new int[n]; 
        int j = n; 
        for (int i = 0; i < n; i++) { 
            temp[j - 1] = array[i]; 
            j = j - 1; 
        } 
        return temp;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
    	String[] s = sin.split(", ");;
		int[] arr = new int[s.length];
        if (s.length == 1 && s[0].isEmpty())
            arr = new int[]{};
        else {
            for(int i = 0; i < s.length; ++i)
        	   arr[i] = Integer.parseInt(s[i]);
        }
      	int[] res = new Solution().reverse(arr);
     	System.out.print("[");
      	for(int i = 0; i < res.length; ++i) {
        	System.out.print(res[i]);
            if(i != s.length - 1)
              System.out.print(", ");
        }
        System.out.print("]");
    }
}