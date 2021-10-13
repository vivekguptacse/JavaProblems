package interview.visa;

/**
 * @author : Vivek Kumar Gupta
 * @since : 13/10/21
 */
public class MinFountain {

    public static void main(String[] args) {
        int size = 9;
        int [] range = new int[size];

        for(int i =0 ; i < size ; i++) {
            range[i] = 1;
        }

        int min= 0;
        int max = 0;
        int count = 0;

        while(max < size-1) {
            for (int i = 0; i < range.length ; i++) {
                if (i - range[i] <=min && i+range[i] > max) {
                    max = i+ range[i];
                }
            }
            if(min == max){
                System.out.println(" -1");
                return;
            }
            min = max;
            count++;
        }

        System.out.println(count);
    }

}
