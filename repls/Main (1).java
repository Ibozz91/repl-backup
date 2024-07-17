class Main {
  public static void main(String[] args) {
    int[] p={9};
    for(int i: nStoogeSort(p)){
      System.out.println(i);
    }
  }
  public static int[] nStoogeSort(int[] Array){
    if(Array.length==1){
      return Array;
    }
    else if(Array.length==2){
      if(Array[0]>Array[1]){
        int Temp=Array[1];
        Array[1]=Array[0];
        Array[0]=Temp;
      }
      return Array;
    }
    else{
      int[] part1=new int[Array.length-1];
      for(int i=0; i<Array.length-1; i++){
        part1[i]=Array[i];
      }
      part1=nStoogeSort(part1);
      for(int i=0; i<Array.length-1; i++){
        Array[i]=part1[i];
      }
      int[] part2=new int[Array.length-1];
      for(int i=0; i<Array.length-1; i++){
        part2[i]=Array[i+1];
      }
      part2=nStoogeSort(part2);
      for(int i=0; i<Array.length-1; i++){
        Array[i+1]=part2[i];
      }
      int[] part3=new int[Array.length-1];
      for(int i=0; i<Array.length-1; i++){
        part3[i]=Array[i];
      }
      part3=nStoogeSort(part3);
      for(int i=0; i<Array.length-1; i++){
        Array[i]=part3[i];
      }
      return Array;
    }
  }
}