/*
 * Problem
 * -------
 * 
 The member states of the UN are planning to send 2 people to the Moon. But there is a problem. In line with their principles of global unity, they want to pair astronauts of 2 different countries.

There are N trained astronauts numbered from 0 to N-1 . But those in charge of the mission did not receive information about the citizenship of each astronaut. The only information they have is that some particular pairs of astronauts belong to the same country.

Your task is to compute in how many ways they can pick a pair of astronauts belonging to different countries. Assume that you are provided enough pairs to let you identify the groups of astronauts even though you might not know their country directly. 
For instance, if  are astronauts {1,2,3} from the same country; it is sufficient to mention that {1,2} and {2,3} are pairs of astronauts from the same country without providing information about a third pair {1,3}. 

Input Format

The first line contains two integers, N and I, separated by a single space. I lines follow. Each line contains 2 integers separated by a single space A  and B such that
0<=A
B<=N-1

and A and B are astronauts from the same country.

Constraints
1<=N<=10 to power of 5
1<=I<=10 to power of 4

Output Format

An integer that denotes the number of permissible ways to choose a pair of astronauts.

Sample Input

4 2
0 1
2 3
Sample Output

4
 */
package journeytomoon;


import java.io.*;
import java.util.*;



public class Solution {



	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int l = scan.nextInt();

		int a,b;
		Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
		List<Integer> list;
		for(int i=0;i<l;i++){
			a = scan.nextInt();
			b = scan.nextInt();
			list = map.get(a);
			if(list == null){
				list = new ArrayList<Integer>();
				map.put(a, list);
			}
			list.add(b);
			list = map.get(b);
			if(list == null){
				list = new ArrayList<Integer>();
				map.put(b, list);
			}
			list.add(a);
		}
		 

		int ct = 0;
		List<Integer> keys = new ArrayList<Integer>(map.keySet());


		List<Integer> pairs,templist1;
		int j;
		List<Integer> done = new ArrayList<Integer>();
		 
		for(int i:keys){
			if(done.contains(new Integer(i))) {continue;}
			pairs = map.get(i);


			for(int t=0;t<pairs.size();t++){
				j = pairs.get(t);

				templist1 = map.get(j);
				if(null != templist1){
					templist1.remove(new Integer(i));
					templist1.removeAll(pairs);
					pairs.addAll(templist1);
					templist1.add(i);
				}

				done.add(new Integer(j));


			}

			
			ct += (pairs.size() + 1) * pairs.size();
		}

		long tot =(long) Math.pow(n,2);
		tot = (tot  - n- (ct))/2;
		System.out.println(tot);
		

	}





}
/*
 * test data
10 7
0 2
1 8
1 4
2 8
2 6
3 5
6 9
 */
