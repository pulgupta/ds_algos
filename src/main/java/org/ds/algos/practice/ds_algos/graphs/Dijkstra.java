package org.ds.algos.practice.ds_algos.graphs;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * VERIFIED SOLUTION ON HACKER RANK AND ALL TEST CASES ARE PASSING
 * https://www.hackerrank.com/challenges/dijkstrashortreach/problem
 */
/**
 * INPUT FORMAT 
1 // Number of test cases
4 4 // Nodes and Edges count
1 2 24 // Starting edge, ending edge and the distance
1 4 20
3 1 3
4 3 12
1 // Starting edge to calculate the distances

 * @author pulgupta
 */
class Distance implements Comparable<Distance>{
	int node;
	int distance;
	
	public Distance(int node, int distance) {
		super();
		this.node = node;
		this.distance = distance;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + node;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Distance))
			return false;
		Distance other = (Distance) obj;
		if (node != other.node) // Equality is only based on the node name
			return false;
		return true;
	}
	@Override
	public int compareTo(Distance o) {
		return this.distance - o.distance;
	}
}

public class Dijkstra {

	//It will contain the final shortest paths
	private static int[] solution;
	private static int[][] adjMatrix;
	private static boolean[] visited;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt(); // Number of test cases
		//Execute a loop for each test case
		for(int t=0;t<T;t++){
			int N = in.nextInt(); 	//Nodes
			int M = in.nextInt(); 	//Edges
			adjMatrix = new int[N][N];
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					adjMatrix[i][j] = Integer.MAX_VALUE; 
				}
			}
			
			for(int m=0;m<M;m++) {
				int n1 = in.nextInt();
				int n2 = in.nextInt();
				int w = in.nextInt();
				// Because this is a non directional graph we are putting weight for both
				// a->b and b->a 
				if(adjMatrix[n1-1][n2-1] > w) {
					adjMatrix[n1-1][n2-1] = w;
					adjMatrix[n2-1][n1-1] = w;
				}
			}
			
			int s = in.nextInt();
			solution = new int[N];
			visited = new boolean[N];
			dijkstra(s-1, N);
		}
		in.close();
	}
	public static void dijkstra(int s, int N){
		// To start with all the distances are marked to max value
		for (int i=0;i<N;i++) {
			solution[i] = Integer.MAX_VALUE;
		}
		solution[s] = 0;
		Queue<Distance> queue = new PriorityQueue<>();
		// Add the starting element and the distance to itself as 0
		queue.offer(new Distance(s,0));
		
		while(!queue.isEmpty()) {
			int node;
			node=queue.poll().node;
			visited[node] = true;
			
			for(int i=0;i<N;i++) {
				if(adjMatrix[node][i]!=Integer.MAX_VALUE && s!=i) {

					if(solution[i]> solution[node] + adjMatrix[node][i]) 
						solution[i]= solution[node] + adjMatrix[node][i];
					// If the target node i is not in the queue we will add it with its updated distance
					Distance newNode = new Distance(i, solution[i]);
					if(!visited[i] && !queue.contains(newNode)) {
						queue.add(newNode);
					}
					else if (!visited[i] && queue.contains(newNode)) {
						boolean found=false;
						for(Distance d: queue) {
							if(d.equals(newNode) && d.distance > solution[i])
								found = true;
						}
						if(found==true) {
							queue.remove(newNode);
							queue.add(newNode);	
						}
					}
				}
			}
		}
		
		for (int i=0;i<N;i++) {
			if(i!=s) {
				if(solution[i]!=Integer.MAX_VALUE)
					System.out.print(solution[i] + " ");
				else
					System.out.print( -1 + " ");
			}
			
		}
		System.out.println();
	}
}

