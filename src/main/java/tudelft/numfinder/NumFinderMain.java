package tudelft.numfinder;

public class NumFinderMain {

    public static void main (String[] args) {
        NumFinder nf = new NumFinder();

        // this works
        // nf.find(new int[] {4, 25, 7, 9});

        // this crashes
        //nf.find(new int[] {4, 3, 2, 1});

        nf.find(new int[] {(int)1.25 * 8, 40000, 30000, (int)-1.45, Integer.MAX_VALUE*2, Integer.MIN_VALUE/14});

        System.out.println(nf.getLargest());
        System.out.println(nf.getSmallest());
    }
}
