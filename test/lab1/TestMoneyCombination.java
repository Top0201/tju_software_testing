package lab1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestMoneyCombination {
	private int coins[]= {1,5,10,20,50};
	private int num[]= {3,2,1,1,1};
	private int sum;
	private int expected;
	private MoneyCombination money;
	
	public TestMoneyCombination(int expected,int sum) {
		this.sum=sum;
		this.expected=expected;
	}
	
	@Before
	public void setUp() {
		money=new MoneyCombination();
	}
	
	@Parameters
	public static Collection<Object[]> getData(){
		return Arrays.asList(new Object[][] {
			{-1,-1},
			{1,0},
			{1,1},
			{1,2},
			{0,4},
			{1,5},
			{2,10},
			{2,30},
			{0,100}
		});
	}
	
	@Test
	public void test() {
		assertEquals(this.expected,money.moneyCombinination(coins, num, sum));
	}
	
}
