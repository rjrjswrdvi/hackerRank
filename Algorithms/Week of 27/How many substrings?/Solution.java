import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	static Map<String,Long> map = new HashMap<String,Long>();
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		String s = in.next();
		for(int a0 = 0; a0 < q; a0++){
			int left = in.nextInt();
			int right = in.nextInt();
			if(left == right){
				print(1);
				continue;
			}
			String key = s.substring(left, right+1);
			if(map.containsKey(key)){print(map.get(key));continue;}
			long value = findDistinct(key);
			print(value);
			map.put(key, value);
		}
	}
	private static long findDistinct(String s) {
		int length = s.length();
	    String[] arr = new String[length];
	    for (int i = 0; i < length; ++i) {
	      arr[i] = s.substring(length - 1 - i, length);
	    }

	    Arrays.sort(arr);

	    long ct = arr[0].length();

	    for (int i = 0; i < length - 1; ++i) {
	      int j = 0;
	      for (; j < arr[i].length(); ++j) {
	        if (!((arr[i].substring(0, j + 1)).equals((arr)[i + 1]
	            .substring(0, j + 1)))) {
	          break;
	        }
	      }
	      ct += arr[i + 1].length() - j;
	    }
	    return ct;
	}
	static void print(long value){
		System.out.println(value);
	}
}
