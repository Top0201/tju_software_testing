package lab4;

import org.junit.Assert;
import org.junit.Test;

public class TestBackPack {

	@Test
	public void test2() {
		int m = 9;
		int n = 4;
		int w[] = {2,4,5,6};
		int p[] = {7,8,9,11};
		int a[][] = {{0,0,0,0,0,0,0,0,0,0},
				{0,0,7,7,7,7,7,7,7,7},
				{0,0,7,7,8,8,15,15,15,15},
				{0,0,7,7,8,9,15,16,16,17},
				{0,0,7,7,8,9,15,16,18,18}};
		Assert.assertArrayEquals(a, BackPack.BackPack_Solution(m, n, w, p));
				
				
	}
}
