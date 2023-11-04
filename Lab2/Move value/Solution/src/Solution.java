import java.util.*;

public class Solution {
	public int[] moveValue(int[] array, int value) {
        int c = 0;
    	for (int i = 0; i < array.length; i++) 
            if (array[i] != value) 
                array[c++] = array[i];

        
        while (c < array.length)
            array[c++] = value;
            
        return array;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //String sin = sc.nextLine();
        // int num = Integer.parseInt(sin.substring(sin.indexOf("]") + 1));
        // sin = sin.substring(0, sin.indexOf("]")).replaceAll("\\[|\\]", "");
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
    	String[] s = sin.split(", ");;
		int[] arr = new int[s.length];
        int num = sc.nextInt();
        if (s.length == 1 && s[0].isEmpty())
            arr = new int[]{};
        else {
            for(int i = 0; i < s.length; ++i)
        	   arr[i] = Integer.parseInt(s[i]);
        }
      	int[] res = new Solution().moveValue(arr, num);
     	System.out.print("[");
      	for(int i = 0; i < res.length; ++i) {
        	System.out.print(res[i]);
            if(i != s.length - 1)
              System.out.print(", ");
        }
        System.out.print("]");
    }
}