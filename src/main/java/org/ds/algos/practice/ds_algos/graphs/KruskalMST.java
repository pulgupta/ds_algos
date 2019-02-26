package org.ds.algos.practice.ds_algos.graphs;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class EdgeData implements Comparable<EdgeData>{
	int weight;
	int node1;
	int node2;
	
	public EdgeData(int node1, int node2, int weight) {
		super();
		this.weight = weight;
		this.node1 = node1;
		this.node2 = node2;
	}

	@Override
	public int compareTo(EdgeData o) {
		return(weight - o.weight);
	}

}
public class KruskalMST {
	public static void main(String[] args) {
		try(Scanner in = new Scanner(System.in)){
			int n = in.nextInt();
			int v = in.nextInt();
			Queue<EdgeData> priority = new PriorityQueue<>();
			for (int i=0;i<v;i++) {
				priority.add(new EdgeData(in.nextInt()-1, in.nextInt()-1, in.nextInt()) );
			}
			//We have the data and also we have the adjacency matrix created
			kruskals(priority, n);
			
		}
		
	}
	private static void kruskals(Queue<EdgeData> priority, int n){
		int[] ds = new int[n];
		for(int i=0;i<n;i++)
			ds[i]=-1;
		long count=0;
		while(checkStatus(ds)){
			boolean found =false;
			EdgeData e = priority.poll();
			if(findParent(ds,e.node1)!=findParent(ds,e.node2)){
				found=true;
				union(ds, e.node1, e.node2);
			}
			if(found)
				count+=(long)e.weight;
		}
		System.out.println(count);
	}
	private static void union(int[] ds, int parent, int child) {
		//Because we have to merge two tress we will find the parent of those trees
		int bigParent = findParent(ds,parent);
		int bigChild = findParent(ds,child);
		//Now we have the parents we will now try to make the smaller tree
		//the child of the bigger tree. Along with this we will also increase
		//the size of the already bigger tree
		if(bigParent!=bigChild){
			if(ds[bigChild]>ds[bigParent]){ //because sign is negative
				ds[bigParent] = ds[bigParent] + ds[bigChild];
				ds[bigChild] = bigParent;
			}
			else {
				ds[bigChild] = ds[bigChild] + ds[bigParent];
				ds[bigParent] = bigChild;
			}
		}
	}
	//Another find operation and this time it will return the parent element.
	//We can deleted the upper function as once we have the parent we 
	//can directly go and get the size.
	private static int findParent(int[] ds, int element) {
		if(ds[element]<0)
			return element;
		else {
			return findParent(ds, ds[element]);
		}
	}
	static boolean checkStatus(int[] ds){
		int count=0;
		for (int i : ds) {
			if(i<0)
				count++;
			if(count>1)
				return true;
		}
		return false;
	}
}
