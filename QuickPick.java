import java.util.*;
public class QuickPick {
	QuickPick(){}
	
	public void executeQuickPick()
	{
		List<Integer> lotteryNumber;
		List<Integer> myLottery;
		boolean playerWin;
		int counter = 0;
		int MEGA = 0;
		
		lotteryNumber = createMegaMillion();
		
		Iterator<Integer> displayNumber = lotteryNumber.iterator();
		
		System.out.print("Winning Number: ");
		while(displayNumber.hasNext())
		{
			MEGA++;
			if(MEGA == 6)
				System.out.print("MEGA: " + displayNumber.next());
			else
				System.out.print(displayNumber.next() + " ");
		}
		
		do
		{
			myLottery = createMegaMillion();
			playerWin = checkingWin(lotteryNumber,myLottery);
			counter++;
		}while(!playerWin);
		
		System.out.print("\nTickets you have to buy to win(Easy Pick or Quick Pick): " + counter);
	}

	private List<Integer> createMegaMillion()
	{
		List<Integer> lotterySet = new ArrayList<Integer>();
		int index = 0;
		int holdNumber;
		
		while(index <  5)
		{
			holdNumber = (int)(Math.random()*70 + 1);
			if(lotterySet.isEmpty())
			{
				lotterySet.add(holdNumber);
				index++;
			}
			else if(!lotterySet.contains(holdNumber))
			{
				lotterySet.add(holdNumber);
				index++;
			}	
		}
		
		Collections.sort(lotterySet);
		lotterySet.add((int)(Math.random()*25 + 1));

		return lotterySet;
	}
	
	private boolean checkingWin(List<Integer> winningLottery, List<Integer> myLottery)
	{
		for(int index = 0; index < winningLottery.size() && index < myLottery.size(); index++)
		{
			if(winningLottery.get(index) != myLottery.get(index))
			{
				return false;
			}
		}
		return true;
	}
}
