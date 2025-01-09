import java.util.Random;

public class MonteCarlo {

    //Exam paper January 2023
    /*
    Write a Java program which uses a Monte Carlo simulation to
    compute the average number of rolls of a dice that are needed
    to see all 6 numbers come up (i.e. 1, 2, 3, 4, 5, 6)
     */
    public static void Test(int iterations) {
        Random rand = new Random();
        float result=0;

        for(int i=0; i<iterations; i++) {
            long total = 0;
            int[] seen = new int[6];
            while((seen[0]==0 || seen[1]==0 || seen[2]==0 || seen[3]==0 || seen[4]==0 || seen[5]==0)) {
                seen[rand.nextInt(6)]=1;
                total+=1;
            }
            result+=(total/(float)iterations);
        }

        System.out.println("Average throws to see all 6 numbers:" + result);
    }
}
