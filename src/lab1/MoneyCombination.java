package lab1;

public class MoneyCombination {
	
	/*
	 * @param coins -- the coin type array
	 * @param num -- the number of each coin type
	 * @param sum -- the given number 
	 */
	
	public long moneyCombinination(int coins[],int num[],int sum) {
		//the invalid input
		if(coins.length!=num.length || sum<0) {
			return -1;
		}
		
		//take 0 as a coin type
		int[][] tables = new int[coins.length+1][sum+1];
		for(int i=0;i<coins.length+1;i++) {
			tables[i][0]=1;
		}
		
		for(int j=0;j<=sum;j++) {
			
			//only use the first coin type to combine the given number
			//be caution: the number of the coin must be enough
			if((j%coins[0]==0) && (j/coins[0] <= num[0])) {
				tables[1][j]=1;
			}
			else {
				tables[1][j]=0;
			}
		}
		
		for(int i=2;i<=coins.length;i++) {
			for(int j=1;j<=sum;j++) {
				for(int k=0;k<=num[i-1];k++) {
					
					if(k*coins[i-1] > j) {
						break;
					}
					
					tables[i][j] += tables[i-1][j - k*coins[i-1]];
				}
			}
		}
		
		return tables[coins.length][sum];
		
	}
}
