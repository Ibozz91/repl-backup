import java.lang.Math;
class Main {
  public static void main(String[] args) {
    int[] answer = Goldbach(133769420);
    System.out.println(answer[0]);
    System.out.println(answer[1]);
  }
  public static boolean isPrime(int numb){
    for(int i = 2; i<=Math.sqrt(numb); i++){
      if(numb % i == 0){
        return false;
      }
    }
    return true;
  }
  public static int[] Goldbach(int n){
    int[] answer = {-1, -1};
    for(int i = 2; i < n-1; i++){
      if(isPrime(i) && isPrime(n-i)){
        answer[0]=i;
        answer[1]=n-i;
      }
    }
    return answer;
  }
}