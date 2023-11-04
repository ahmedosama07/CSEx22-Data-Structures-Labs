import java.util.*;

public class Solution {
	public int[][] transpose(int[][] array) {
        int N = array.length;
        int[][] trans = new int[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++) 
                trans[i][j] = array[j][i];
        }
        return trans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
    	String[] s = sin.split(", ");
        int N = (int)Math.sqrt(s.length);
		int[][] arr = new int[N][N];
        if (s.length == 1 && s[0].isEmpty())
            arr = new int[][]{};
        else {
            int k = 0;
            while(k < s.length){
                for(int i = 0; i < N; ++i){
                    for(int j = 0; j < N; ++j){
                        arr[i][j] = Integer.parseInt(s[k]);
                        ++k;
                    }
                }
            }
        }
      	int[][] res = new Solution().transpose(arr);
     	System.out.print("[");
      	for(int i = 0; i < N; ++i) {
            System.out.print("[");
        	for(int j = 0; j < res.length; ++j)
            {
                System.out.print(res[i][j]);
                if(j != res.length - 1)
                    System.out.print(", ");
            }
            System.out.print("]");
            if(i != N - 1)
                    System.out.print(", ");
        }
        System.out.print("]");
    }
}