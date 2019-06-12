package org.ds.algos.practice.ds_algos.UnionFind;

import java.util.Scanner;

public class QuickUnion {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int items = in.nextInt();
		int queries = in.nextInt();
		in.nextLine();
		int[] ds = new int[items];
		for(int i=0;i<items;i++)
			ds[i] = -1;
		for(int i=0;i<queries;i++) {
			String data = in.nextLine();
			String[] dataArr = data.split(" ");
			int element1 = Integer.parseInt(dataArr[1]);
			element1--;
			if(dataArr[0].equals("M")) {
				int element2 = Integer.parseInt(dataArr[2]);
				element2--;
				union(ds, element1, element2);
			}
			else {
				System.out.println(find(ds, element1));
			}
			in.close();
		}
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
	//Just a recursive find operation to find the size of the root.
	private static int find(int[] ds, int element) {
		if(ds[element]<0)
			return ds[element]*-1;
		else {
			return find(ds, ds[element]);
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
}
