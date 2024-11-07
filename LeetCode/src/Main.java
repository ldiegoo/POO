public class Main {
    public static void main(String[] args) {
        int n=10,m=3;
        int sumaNoDivisible=0;
        for(int i=1; i<=n; i++){
            int resto=i%m;
            if(resto!=0){
                sumaNoDivisible+=i;
            }
        }
        int sumaDivisible=0;
        for(int i=1; i<=n; i++){
            int resto=i%m;
            if(resto==0){
                sumaDivisible+=i;
            }
        }
        int resultado= sumaNoDivisible-sumaDivisible;

        System.out.println(sumaDivisible);
        System.out.println(sumaNoDivisible);
        System.out.println(resultado);
    }
    }
