package com.revature;

import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		int pick;
		ArrayList<Integer> array = new ArrayList<Integer>();
		/*METHOD 1
		 * Random rand = new Random();
		
		for(int i = 0; i<= rand.nextInt(100); i++) {
			
			pick = rand.nextInt(100);
			
			array.add(pick);
		}
		
		System.out.println(array);*/
		
		/*METHOD 2
		 * Random rand = new Random();
		int input = rand.nextInt(10);
		int[]num = new int[input];
		for(int i = 0; i< input; i++)
		{
			num[i] = rand.nextInt(100);
		}
		for(int i :num) {
		System.out.print(i + "");
		}*/
		
		//METHOD 3, optimized
		Random rand = new Random();
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i<rand.nextInt(100); i++) {
            arraylist.add(rand.nextInt(100));
            System.out.print(arraylist.get(i) +" ");
        }
		}
}


//if (e.getSource() == Add && to <= 99)