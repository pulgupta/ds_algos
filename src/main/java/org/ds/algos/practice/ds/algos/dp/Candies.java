package org.ds.algos.practice.ds.algos.dp;

import java.util.Scanner;

/**********SOLVED**********/

public class Candies {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = in.nextInt();
		}
		
		long[] candies = new long[n];
		//As the base case the first child will receive either
		//1 or 2 candies based in the second rating
		if(n==1){
			System.out.println(1);
			System.exit(0);
		}
			
		if(arr[0]>arr[1])
			candies[0]=2;
		else
			candies[0]=1;
		for (int i = 1; i < candies.length; i++) {
			candies[i]=1;
		}
		distCandies(arr, candies, 1, n);
		distCandiesBack(arr, candies, n-1, n);
		int sum =0;
		for(int i=0;i<n;i++) {
			sum+=candies[i];
		}
		System.out.println(sum);
		in.close();
	}

	public static void distCandies(int[] arr, long[] candies, int pointer, int n ) {
		for(int i=1;i<n;i++) {
			if(arr[i]>arr[i-1])
				candies[i] = candies[i-1] + 1;
		}
	}
	public static void distCandiesBack(int[] arr, long[] candies, int pointer , int n) {
		for(int i=arr.length-1; i>0;i--) {
			if(arr[i-1]>arr[i] && candies[i-1]<=candies[i])
				candies[i-1] = candies[i] + 1;
		}
	}
}

/*
 * 
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = in.nextInt();
		}
		
		int[] candies = new int[n];
		//As the base case the first child will receive either
		//1 or 2 candies based in the second rating
		if(n==1){
			System.out.println(1);
			System.exit(0);
		}
			
		if(arr[0]>arr[1])
			candies[0]=2;
		else
			candies[0]=1;
		for (int i = 1; i < candies.length; i++) {
			candies[i]=1;
		}
		distCandies(arr, candies, 1);
		distCandiesBack(arr, candies, n-1);
		int sum =0;
		for(int i=0;i<n;i++) {
			sum+=candies[i];
		}
		System.out.println(sum);
	}

	public static void distCandies(int[] arr, int[] candies, int pointer) {
		if(pointer>=0 && pointer<arr.length) {
			if(arr[pointer]>arr[pointer-1])
				candies[pointer] = candies[pointer-1] + 1;
			distCandies(arr, candies, pointer+1);
		}
	}
	public static void distCandiesBack(int[] arr, int[] candies, int pointer) {
		if(pointer>0 && pointer<arr.length) {
			if(arr[pointer-1]>arr[pointer] && candies[pointer-1]<=candies[pointer])
				candies[pointer-1] = candies[pointer] + 1;
			distCandiesBack(arr, candies, pointer-1);
		}
	}
}
*/

