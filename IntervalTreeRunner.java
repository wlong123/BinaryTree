public class IntervalTreeRunner{
	
	public static void main(String [] args)
	{
		Integer[] i = new Integer[2];
		i[0] = 1;
		i[1] = 10;
		Integer[] x = new Integer[2];
		x[0] = 5;
		x[1] = 20;
		IntervalTree<Integer> left = new IntervalTree<Integer>(x);
		IntervalTree<Integer> tree = new IntervalTree<Integer>(i);
		tree.setLeft(left);
		System.out.println(tree);
		System.out.println(tree.maxValue());
	}

}