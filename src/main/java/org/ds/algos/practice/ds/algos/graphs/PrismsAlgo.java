package org.ds.algos.practice.ds.algos.graphs;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Weights implements Comparable<Weights>{
	int vertex;
	int weight;
	public Weights(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}

	@Override
	public int compareTo(Weights o1) {
		return weight-o1.weight;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Weights weights = (Weights) o;
		return weight == weights.weight;
	}

	@Override
	public int hashCode() {
		return Objects.hash(weight);
	}
}
public class PrismsAlgo {
	public static void main(String[] args) {
		try(Scanner in = new Scanner(System.in)){
			int n = in.nextInt();
			int v = in.nextInt();
			int[][] adjacency = new int[n][n];
			for(int i=0;i<n;i++){
				for (int j=0;j<n;j++){
					adjacency[i][j] = -1;
				}
			}
			for (int i=0;i<v;i++) {
				int v1=in.nextInt()-1;
				int v2=in.nextInt()-1;
				int w=in.nextInt();
				adjacency[v1][v2] = w;
				adjacency[v2][v1] = w;
			}
			int start = in.nextInt()-1;
			//We have the data and also we have the adjacency matrix created
			prisms(adjacency, n, start);
			
		}
		
	}
	private static void prisms(int[][] adjacency, int n, int start){
		Queue<Weights> weight = new PriorityQueue<>();
		long count=0;
		boolean[] visited = new boolean[n];
		visited[start]=true;
		//added all the vertex adjacent to start into a queue
		for(int i=0;i<n;i++){
			if(adjacency[start][i]!=-1)
				weight.add(new Weights(i, adjacency[start][i]));
		}
		while(!weight.isEmpty()){
			Weights w = weight.poll();
			if(!visited[w.vertex]) {
				count+=(long)w.weight;
				visited[w.vertex]=true;
				for(int i=0;i<n;i++){
					if(adjacency[w.vertex][i]!=-1){
						weight.add(new Weights(i, adjacency[w.vertex][i]));
					}
						
				}
			}
		}
		System.out.println(count);
	}
}
