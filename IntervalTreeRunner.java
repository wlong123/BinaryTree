public class IntervalTreeRunner{
	
	public static void main(String [] args)
	{
		//creates interval tree containing the x values
		Integer[] a = new Integer[2];
		a[0] = 1;
		a[1] = 8;
		
		Integer[] b = new Integer[2];
		b[0] = -4;
		b[1] = 10;
		
		Integer[] c = new Integer[2];
		c[0] = 5;
		c[1] = 7;
		
		IntervalTree<Integer> xvals = new IntervalTree<Integer>(a);
		IntervalTree<Integer> left = new IntervalTree<Integer>(b);
		IntervalTree<Integer> right = new IntervalTree<Integer>(c);
		xvals.setLeft(left);
		xvals.setRight(right);
		
		System.out.println(xvals);
		
		
		//creates interval tree containing the y values
		Integer[] d = new Integer[2];
		d[0] = -3;
		d[1] = 5;

		Integer[] e = new Integer[2];
		e[0] = 2;
		e[1] = 15;
		
		Integer[] f = new Integer[2];
		f[0] = 5;
		f[1] = 9;
		
		IntervalTree<Integer> yvals = new IntervalTree<Integer>(d);
		IntervalTree<Integer> yleft = new IntervalTree<Integer>(e);
		IntervalTree<Integer> yright = new IntervalTree<Integer>(f);
		yvals.setLeft(yleft);
		yvals.setRight(yright);
		
		System.out.println(yvals);
		
		
	}

}