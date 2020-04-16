package lab4;

import org.junit.Test;
import org.junit.Assert;
public class TestBubbleSort {

	@Test
	public void te() {
		int expected[] = {1,2,2,5,6};
		int par[] = {2,5,6,2,1};
		Assert.assertArrayEquals(expected, BubbleSort.BubbleSort(par));
	}
}


