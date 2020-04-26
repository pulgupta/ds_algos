package org.ds.algos.practice.ds.algos.trees;

import java.util.Scanner;

public class MakeEvenForest {
	static int answer;
	static boolean visited[];
	public static void main(String[] args) {
		try(Scanner in = new Scanner(System.in)){
			int nodes = in.nextInt();
			int edges = in.nextInt();
			int[][] adjacencyMatrix = new int[nodes][nodes];
			visited = new boolean[nodes];
			for(int i=0;i<edges;i++){
				int vertex1 = in.nextInt();
				int vertex2 = in.nextInt();
				adjacencyMatrix[vertex1-1][vertex2-1] = 1;
				adjacencyMatrix[vertex2-1][vertex1-1] = 1;
			}
			//So now we have the adjacency matrix set
			//lets find out the divisions.
			
			traverseDepth(adjacencyMatrix, 0, nodes);
			System.out.println(answer);
		}
	}
	static int traverseDepth(int[][] adjacency, int root, int n) {
		int child=0;
		visited[root]=true;
		for(int i=0;i<n;i++){
			if(adjacency[root][i]!=0 && !visited[i])
				child = child + 1 + traverseDepth(adjacency, i, n);
		}
		if(child%2==0){
			answer++;
		}
		return child;
	}
}
