package IntArray;

/**
 * Created by IntelliJ IDEA.
 * User: lmohan
 * Date: 11/5/13
 * Time: 10:55 AM
 */
public class FindNthElementQuickSelection {
    // uses zero index for search
    public static void main(String[] args){
        int[] i = {5,1, 4, 3, 2}; // 1,2,3,4,5
        //System.out.println(selectKth(i,2));

        i=new int[]{9,4,6,2,7,1,5,7,0,2,100};
        System.out.println(selectKth(i,10));

    }

    public static int selectKth(int[] arr, int k) {
        if (arr == null || arr.length <= k)
            throw new Error();

        int from = 0, to = arr.length - 1;

        // if from == to we reached the kth element
        while (from < to) {
            int r = from, w = to;
            int mid = arr[(r + w) / 2];

            // stop if the reader and writer meets
            while (r < w) {

                if (arr[r] >= mid) { // put the large values at the end
                    int tmp = arr[w];
                    arr[w] = arr[r];
                    arr[r] = tmp;
                    w--;
                } else { // the value is smaller than the pivot, skip
                    r++;
                }
            }

            // if we stepped up (r++) we need to step one down
            if (arr[r] > mid)
                r--;

            // the r pointer is on the end of the first k elements
            if (k <= r) {
                to = r;
            } else {
                from = r + 1;
            }
        }

        return arr[k];
    }
}
