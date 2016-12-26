import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	static Map<String,Integer> map = new HashMap<String,Integer>();
	static Map<Integer,List<Integer>> conn = new HashMap<Integer,List<Integer>>();
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		int[] nodes = new int[n];
		for(int nodes_i=0; nodes_i < n; nodes_i++){
			nodes[nodes_i] = in.nextInt();
		}
		int[][] edges = new int[n-1][2];
		List<Integer> list;
		for(int edges_i=0; edges_i < n-1; edges_i++){
			int[] a = new int[2];
			for(int edges_j=0; edges_j < 2; edges_j++){
				a[edges_j] = in.nextInt();
			}

			if(!conn.containsKey(a[0])){
				conn.put(a[0], new ArrayList<Integer>());
			}
			list = conn.get(a[0]);
			list.add(a[1]);
			if(!conn.containsKey(a[1])){
				conn.put(a[1], new ArrayList<Integer>());
			}
			list = conn.get(a[1]);
			list.add(a[0]);
		}
		List<Integer> path;
		for(int a0 = 0; a0 < q; a0++){
			int u = in.nextInt();
			int v = in.nextInt();
			if(u==v){print(0);continue;}
			// check if the nodes are already covered
			if(map.containsKey(u+"-"+v)){print(map.get(u+"-"+v));continue;}
			else if(map.containsKey(v+"-"+u)){print(map.get(v+"-"+u));continue;}

			// find the solution
			path = getShortestPath(u,v);
			//print path
//			for(int i:path)
//				System.out.print(i + " ");
//			System.out.println();
			int val = getCoPrimePathCount(nodes,path);
			map.put(u+"-"+v, val);
			System.out.println(val);
		}
	}

	private static int getCoPrimePathCount(int[] nodes, List<Integer> path) {
		int ct = 0;
		for(int i=0;i<path.size();i++)
		{
			BigInteger I = new BigInteger(nodes[path.get(i)-1]+"");
			for(int j=i+1;j<path.size();j++){
				if(I.gcd(new BigInteger(nodes[path.get(j)-1]+"")).equals(BigInteger.ONE)){ct++;}
			}
		}
		return ct;
	}

	private static List<Integer> getShortestPath(int start,int end) {
		//Map<Integer, Integer> nextNodeMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> prevNodeMap = new HashMap<Integer, Integer>();
		int currentNode = start;
		//int previousNode = start;

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(currentNode);

		Set<Integer> visitedNodes = new HashSet<Integer>();
		visitedNodes.add(currentNode);


		//Search.
		while (!queue.isEmpty()) {
			currentNode = queue.remove();
			if (currentNode == end) {
				// Handle case where the node leading to the destinatino node
				// itself pointed to multiple nodes. In this case,
				// nextNodeMap is incorrect and we need to rely on the previously
				// seen node.
				// Also need to check for edge-case of start node == end node.
				// correct all entries
				 
				break;
			} else {
				for (Integer nextNode : conn.get(currentNode)) {
					if (!visitedNodes.contains(nextNode)) {
						queue.add(nextNode);
						visitedNodes.add(nextNode);

						// Look up of next node instead of previous.
						//nextNodeMap.put(currentNode, nextNode);
						prevNodeMap.put(nextNode, currentNode);
						//previousNode = currentNode;
					}
				}
			}
		}

		// If all nodes are explored and the destination node hasn't been found.
		if (currentNode != end) {
			throw new RuntimeException("No feasible path.");
		}

		// Reconstruct path. No need to reverse.
		List<Integer> path = new LinkedList<Integer>();
		for (Integer node = end; node != null; node = prevNodeMap.get(node)) {
			path.add(node);
		}
		return path;
	}


	static void print(int val){
		System.out.println(val);
	}
}
