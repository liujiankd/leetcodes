/* Every time you can climb 1 or 2 steps. Solution of fibonacci */
public class ClimbingStairs {
    public int climbStairs(int n) {
	if(n < 2) {
	    return n;
	}
	int step = 2;
	int fm1 = 1;
	int fm2 = 1;
	for(int index = 2; index <= n; index++) {
	    step = fm1 + fm2;
	    fm2 = fm1;
	    fm1 = step;
	}
	return step;
    }
}
