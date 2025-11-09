import java.util.Arrays;
import java.util.Comparator;

public class FractionalKanpsack {
    public static void main(String[] args) {
        int val[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };

        double ratio[][] = new double[val.length][2];

        for (int i = 0; i < ratio.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        double finvalue = 0;
        int capacity = 50;
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= weight[idx]) {
                finvalue += val[idx];
                capacity -= weight[idx];
            } else {
                finvalue += ratio[i][1] * capacity;
            }
        }
        System.out.println("final value is : " + finvalue);
    }

}
