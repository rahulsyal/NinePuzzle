/*
 * How to implement a queue using two stacks:
 * First stack named S1
 * Second stack named S2
 * To queue:
 * 	Add element to S1
 * To dequeue:
 * 	(1) If S2 empty, pop elements from S1 and push them to S2.
 * 	(2) Pop from S2
 * N queue operations will take n time as each element will be pushed twice and popped twice, giving amortized constant time operation.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
public class NinePuzzle {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String initial = scan.next();

		int levelCounter = 1;
		String goalConfig = "123456789";
		ArrayList<String> checkedConfigs = new ArrayList<String>();
		checkedConfigs.add(initial);
		Queue<NinePuzzleState> states = new LinkedList<NinePuzzleState>();

		NinePuzzleState start = new NinePuzzleState(initial, levelCounter, null);
		//check if it's already solved
		if (start.currentConfig.equals(goalConfig)){
			System.out.println("Already solved.");
			System.out.println(start.currentConfig);
		}

		String[] moves = start.getMoves();
		//start adding to queue
		int currentCount = 0;
		for (String a : moves) {
			if (a!= null) {
				//System.out.println("Level 1: " + a);
				states.add(new NinePuzzleState(a,levelCounter,start)); //create new PuzzleStates from list of moves
				currentCount++;
			}
		}
		//end adding to queue
		boolean doneZO = false;
		boolean doneZOMO = false;
		int futureCount = 0;
		while(levelCounter < 32 && !doneZO){
			levelCounter+=1;
			for (int i = 0; i < currentCount && !doneZOMO;i++){
				NinePuzzleState temp = states.remove();
				String[] moves2 = temp.getMoves(); //this holds moves of first child
				for (String a : moves2){
					//System.out.println("Moves: " + a);
				}
				for (String a : moves2){
					if (!(a == null) && !(a.equals(goalConfig)) && !(checkedConfigs.contains(a))){
						checkedConfigs.add(a);
						//System.out.println("Level " + levelCounter + ": " + a);
						futureCount+=1;
						states.add(new NinePuzzleState(a,levelCounter,temp));
					}
					else if ( !(a== null) && a.equals(goalConfig)){
						//System.out.println("HOORAH: Answer is " + a);
						Stack stck = new Stack();
						stck.push(a);
						stck.push(temp.currentConfig);
						//System.out.println(temp.currentConfig);
						while (temp.previousConfig != null){
							//System.out.println(temp.previousConfig.currentConfig);
							stck.push(temp.previousConfig.currentConfig);
							temp = temp.previousConfig;
						}
						while (!(stck.isEmpty())){
							System.out.println(stck.pop()); //skwad
						}
						doneZO = true;
						doneZOMO = true;
						break;
					}
				}
			}
			currentCount=futureCount;
		}
		if (levelCounter == 32){
			System.out.println("-1");
		}
	}

}

