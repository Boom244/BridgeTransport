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
		while (true) //for each car in the lineup
		{
			if (lineup.isEmpty())
			{
				break;
			}
			//if the next car doesn't exceed the weight rating of the bridge, add it to the bridge
			if (currentWeight + lineup.peek() <= maxWeight)
			{
				bridge.add(lineup.peek());
				currentWeight += lineup.peek();
				lineup.poll();
				maxCars++;
				//if this causes us to be at the max amount of cars for the bridge (4), remove one
				//before going to the next loop
				if (bridge.size() == 4)
				{
					currentWeight -= bridge.peek();
					bridge.poll();
				}
				continue;
			}else { //if the car does exceed the weight rating of the bridge even when the bridge has a free slot
				break;
			}
			
		}
		System.out.println(maxCars);
	}
}