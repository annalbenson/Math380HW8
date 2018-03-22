public class MonteCarloApprox {

    public static void main(String [] args){

        // Note:

        /*
        System.out.println("Problem Three, n = 100, pi = " + ProblemThree(100));
        System.out.println("Problem Three, n = 200, pi = " + ProblemThree(200));
        System.out.println("Problem Three, n = 300, pi = " + ProblemThree(300));
        System.out.println("Problem Three, n = 1000, pi = " + ProblemThree(1000));
        */

        /*
        System.out.println("Problem Five, n = 100, area = " + ProblemFive(100));
        System.out.println("Problem Five, n = 200, area = " + ProblemFive(200));
        System.out.println("Problem Five, n = 10000, area = " + ProblemFive(10000));
        */

        /*
        System.out.println("Problem Seven, n = 100, volume = " + ProblemSeven(100));
        System.out.println("Problem Seven, n = 200, volume = " + ProblemSeven(200));
        System.out.println("Problem Seven, n = 10000, volume = " + ProblemSeven(10000));
        */

        /*
        //System.out.println("Problem One B, seed = 653217 : ");
        //ProblemOneB(20, 653217);
        */

        /*
        System.out.println("Problem Two C, seed = 7 : ");
        ProblemTwoC(20, 7, 5,3,16);
        */

        /*
        System.out.println("Problem 2, n = 100, c = 5, h = 3 : prob = " + ProblemTwo(100,5,3));
        System.out.println("Problem 2, n = 200, c = 5, h = 3 : prob = " + ProblemTwo(200,5,3));
        System.out.println("Problem 2, n = 1000, c = 5, h = 3 : prob = " + ProblemTwo(1000,5,3));
        System.out.println("Problem 2, n = 2000, c = 5, h = 3 : prob = " + ProblemTwo(2000,5,3));
        */
    }
    public static double ProblemThree(int n){
        // quarter circle in quadrant one

        int count = 0;
        double area;

        for(int i = 0; i < n; i ++){
            double x = Math.random();// will be between 0 and 1
            double y = Math.random();
            double f_of_x = Math.sqrt(1- x*x);
            if( y <= f_of_x){
                count++;
            }
        }
        area = (double) count / n;
        area *= 4;
        return area;
    }

    public static double ProblemFive(int n){
        int count = 0;
        double area;

        for(int i = 0; i < n; i ++){
            double x = randomWithRange(0,2); // 0 <= x <= 2
            double y = randomWithRange(0,6); // 0 <= y <= 6
            double f1_of_x = x*x;
            double f2_of_x = 6 - x;
            if( y >= f1_of_x && y <= f2_of_x ){
                count++;
            }
        }
        area = (double) (12 * count) / n;
        return area;
    }

    public static double ProblemSeven(int n){
        //// ????
        int count = 0;
        double volume;

        for(int i = 0; i < n; i ++){
            double x = randomWithRange(-2,2); // -2 <= x <= 2
            double y = randomWithRange(- Math.sqrt(2),Math.sqrt(2)); // - sqrt 2 <= y <= sqrt 2
            double z = randomWithRange(0,4); // 0 <= y <= 4

            double f1_of_xy = 8 - Math.pow(x,2) - Math.pow(y,2);
            double f2_of_xy =  Math.pow(x,2) + 3*Math.pow(y,2);
            if(z <= f1_of_xy && z >= f2_of_xy ){
                count++;
            }
        }
        volume = (32*Math.sqrt(2)*count) / (double) n;
        return volume;
    }

    public static double randomWithRange(double min, double max){
        double range = (max - min);
        double rand = Math.random() * range + min;
        //System.out.println(rand);
        return rand;
    }

    public static void ProblemOneB(int n, int seed){

        //int length = 6;
        for(int i = 0; i < n; i++) {

            //String s = Integer.toString(seed);
            double squared = Math.pow(seed,2);
            //System.out.println("squared : " + squared);
            String padded = String.format("%012.0f", squared);
            //System.out.println("padded : " + padded);
            int middle = Integer.parseInt(padded.substring(3, 9));
            System.out.print(middle + "\t");
            seed = middle;

            //abcdefgh123456
            // want middle 6 of 12 length string
            // minus three from either side
        }
    }

    public static void ProblemTwoC(int n, int seed, int a, int b, int c){

        for(int i = 0; i < n; i ++){
            int temp = (a * seed + b) % c;
            System.out.print(seed + "\t");
            seed = temp;
        }
    }

    public static double ProblemTwo(int n, int c, int h){
        // 5.3 problem 2; probability of three heads in five fair coin flips
        int counterThreeHeads = 0; int counterHeads = 0;
        for(int i = 0; i < n; i ++){
            counterHeads = 0;
            for (int j = 0; j < c; j++){
                double x = randomWithRange(0,1);
                if( 0 <= x && x <= .5 ){
                    counterHeads ++;
                }
            }
            if (counterHeads == h){
                counterThreeHeads++;
            }
        }
        return (double) counterThreeHeads / n;
    }
}
