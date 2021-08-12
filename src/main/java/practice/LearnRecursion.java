package practice;

public class LearnRecursion {
    public int sumNumber(int k) {
        if (k > 0) {
            return k + sumNumber(k-1);


        } else {
            return 0;
        }
    }
}
