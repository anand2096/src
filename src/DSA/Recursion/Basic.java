package DSA.Recursion;

public class Basic {


    public static void main(String[] args) {
        int n=3;
        new Basic().printM(1,n);
    }
                            //3 , 3
    private  void printM(int i, int n) {

        if(i>n)
            return;
        //3/2/1
        printM(i+1,n);
        System.out.println(i);

    }
}
