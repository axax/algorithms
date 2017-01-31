package TrappingWater;

public class Main {

    /**
     *
     * Trapping Rain Water (Java)
     *
     * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
     * For example, given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
     *
     * Analysis
     * This problem is similar to Candy. It can be solve by scanning from both sides and then get the total.
     *
     */

    public static void main(String[] args) {
        int[] elevations = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        int result = 0;

        int left[] = new int[elevations.length];
        int right[] = new int[elevations.length];


        // scan from left
        left[0] = elevations[0];
        int max = elevations[0];
        for (int i = 1; i < elevations.length; i++) {
            if (max < elevations[i]) {
                max = elevations[i];
            }
            left[i] = max;
        }


        // scan from right
        right[elevations.length-1] = elevations[elevations.length-1];
        max = elevations[elevations.length-1];
        for (int i = elevations.length-2; i >=0; i--) {
            if (max < elevations[i]) {
                max = elevations[i];
            }
            right[i] = max;
        }

        // calculate total
        for(int i=0; i<elevations.length; i++){
            result+= Math.min(left[i],right[i])-elevations[i];
        }


        System.out.println(result);

    }
}
