package org.ds.algos.practice.ds.algos.dp;

import java.util.Scanner;
/***********SOLVED DUDE ************/

public class MaximumStock {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t= in.nextInt();
		for(int i=0;i<t;i++){
			
			int n = in.nextInt();
			int[] price = new int[n];
			for(int j=0;j<n;j++)
				price[j]=in.nextInt();
			
			//LEDGER: 0 : Do nothing, 1 : buy, 2 : Sell, 
			int[] ledger = new int[n];
			long profit=0;
			for(int j=0;j<n;j++){
				if(ledger[j]==0) {
					int todayPrice=price[j];
					//Find the maximum rate we can sell this
					int selling=todayPrice;
					int tracker=0;
					for(int k=j;k<n;k++){
						if(selling < price[k]){
							selling = price[k];
							tracker=k;
						}
					}
					if(tracker!=0) {
						ledger[tracker] = 2;
						for(int m=j;m<tracker;m++){
							profit += (price[tracker] - price[m]);
							ledger[m]=1;
						}
					}
				}
			}
		System.out.println(profit);
		}
		in.close();
	}
}
