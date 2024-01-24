package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int maxWeight = sc.nextInt();
		int cars = sc.nextInt();
		int currentWeight = 0;
		int maxCars = 0;
		ArrayList<Integer> carMaxes = new ArrayList<>();
		Queue<Integer> lineup = new LinkedList<>();
		Queue<Integer> bridge = new LinkedList<>();
		for (int i = 0; i < cars; i++)
		{
			lineup.add(sc.nextInt());
		}
		//Here's what we're going to do
		while (!lineup.isEmpty())
		{
			//While the current weight + the next car <= our max weight:
			while ((currentWeight + lineup.peek()) <= maxWeight)
			{
				//keep adding cars to the queue:
				bridge.add(lineup.peek());
				currentWeight += lineup.poll();
				maxCars++;
				if (lineup.isEmpty())
				{break;}
			}
			//Once we exit the loop, we've hit our max,
			currentWeight -= bridge.peek(); //sub this from our current weight
			bridge.poll(); //and remove the head of the bridge queue
			//and keep doing this dance up until we've emptied the lineup
		}
		System.out.println(maxCars);
		
	}
	
	static int max(ArrayList<Integer> arr)
	{
		int currentmax = 0;
		for (int j: arr)
		{
			if (j < currentmax)
			{
				currentmax = j;
			}
		}
		return currentmax;
	}

}
