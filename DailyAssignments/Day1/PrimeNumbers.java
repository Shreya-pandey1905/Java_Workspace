
class PrimeNumbers {
    public static void main(String[] args) {
    int n = 100;

    Boolean isPrime =true;

  if (n==1||n==0){
      System.out.print(n+"is Not Prime number");

  }else{
        for(int i=2; i<n; i++){
        if (n%i==0){
            isPrime =false;
            break;
        }

    }
      if (isPrime){
        System.out.print(n+"is Prime number");
    }
    else{
          System.out.print(n+"is Not Prime number");
    }
  }

    }
}