package main;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public Main() {
		Scanner sc = new Scanner(System.in);
		int maxWeight = sc.nextInt();
		int cars = sc.nextInt();
		int currentWeight = 0;
		int maxCars = 0;
		Queue<Integer> lineup = new LinkedList<>();
		for (int i = 0; i < cars; i++)
		{
			lineup.add(sc.nextInt());
		}
		while (!lineup.isEmpty())
		{
			if ((currentWeight + lineup.peek()) < maxWeight)
			{
				currentWeight += lineup.remove();
				maxCars++;
			}
			else {
				break;
			}
		}
	}

}
