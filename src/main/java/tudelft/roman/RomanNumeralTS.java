package tudelft.roman;

import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class RomanNumeralTS {
    private static Map<Character, Integer> map;
    private static HashSet<String> illegals;

    static {
        map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        illegals = new HashSet<>();
        illegals.add("DM");
        illegals.add("DD");
        illegals.add("LC");
        illegals.add("LM");
        illegals.add("LL");
        illegals.add("VV");
        illegals.add("CCCC");
        illegals.add("IIII");
        illegals.add("XXXX");
    }


    public int convert(String romnum) throws Exception {
        int sum = 0;
        int[] nums = new int[romnum.length()];
        int v0, v1, v2;
        int idx;

        for (idx=0; idx < romnum.length(); idx++) {
            char c = romnum.charAt(idx);
            Integer val = map.get(c);
            if (val == null) {
                throw new Exception(String.format("Roman numeral %1$s contains illegal character %2$s", romnum, c));
            }
            else {
                nums[idx] = val;
            }
        }

        for (String illegal : illegals) {
            if (romnum.contains(illegal)) {
                throw new Exception(String.format("Roman numeral %1$s contains illegal sequence %2$s", romnum, illegal));
            }
        }

        boolean done = false;
        idx = romnum.length() - 1;

        while (idx >= 0) {
            v0 = nums[idx];

            if (idx == 0) {
                sum += v0;
                break;
            }
            v1 = nums[idx - 1];

            if (v1 <= v0) {
                if (idx > 1) {
                    v2 = nums[idx - 2];
                    if (v2 < v0) {
                        throw new Exception(String.format("Roman numeral %1$s contains illegal sequence", romnum));
                    }
                }
                sum += v0 + v1 * (v1 < v0 ? -1 : 1);
                idx -= 2;
            }
            else {
                sum += v0;
                idx--;
            }
        }

        return sum;
    }


}
