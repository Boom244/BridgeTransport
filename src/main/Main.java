package main;

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
			if ((currentWeight + lineup.peek()) <= maxWeight)
			{
				//keep adding cars to the queue:
				bridge.add(lineup.peek());
				currentWeight += lineup.poll();
				maxCars++;
				continue;
			}
			if (lineup.isEmpty())
			{
				break;
			}
			else if (((currentWeight - bridge.peek()) + lineup.peek()) > maxWeight)
			{
				break;
			}
			if (!bridge.isEmpty())
			{
				//Once we exit the loop and it's possible to load more cars and we've hit our max,
				currentWeight -= bridge.peek(); //sub this from our current weight
				bridge.poll(); //and remove the head of the bridge queue
				//and keep doing this dance up until we've emptied the line-up
			}
			
			
		}
		System.out.println(maxCars);
	}
}
