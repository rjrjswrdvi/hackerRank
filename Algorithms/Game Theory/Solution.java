import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();

		for(int i=0;i<t;i++){
			int n = scan.nextInt();
			
			if(n==1 || n%2 == 0)
			{
				
					System.out.println("Kitty");
				
			}
			else{

				System.out.println("Katty");

			}


		}


	}


}