package recursion;

public class PowOfXN {

    public double myPow(double x, int n) {
        if(n >= 0){
            return positive(x, n);
        }else{
            return negative(x,n);
        }
    }

    public double positive(double x, int n){
        if(n == 0){
            return 1;
        }
        double smallAns = myPow(x, n/2);
        if(n % 2 == 0){
            return smallAns * smallAns;
        }else{
            return x * smallAns * smallAns;
        }
    }
    public double negative(double x, int n){
        if(n == -1){
            return 1/x;
        }
        double smallAns = myPow(x, n/2);
        if(n % 2 == 0){
            return smallAns * smallAns;
        }else{
            return (1/x) * smallAns * smallAns;
        }
    }
}
