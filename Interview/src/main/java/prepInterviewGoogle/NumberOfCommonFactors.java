package prepInterviewGoogle;

public class NumberOfCommonFactors {

    public int commonFactors(int a, int b) {

        int maxDiv = Math.min(a, b);

        int counter = 0;
        for (int i = 1; i <= maxDiv; i++){

            if (a%i == 0 && b%i == 0) counter++;
        }

        return counter;
    }
}
