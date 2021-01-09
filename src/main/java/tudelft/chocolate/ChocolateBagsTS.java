package tudelft.chocolate;

public class ChocolateBagsTS {
    public int smallBarCount(int size, int small, int large) {
        int max_large = size / 5;
        int used_large = Math.min(max_large, large);
        int needed_small = size - used_large * 5;
        return small >= needed_small ? needed_small : -1;
    }
}
