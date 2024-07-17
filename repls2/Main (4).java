import java.util.Random;
class Main {
  public static void main(String[] args) {
    int[] tosort={4, 8, 2, 3, 1};
    for(int i:tosort){
      System.out.println(i);
    }
    System.out.println("");
    shuffle(tosort);
    for(int i:tosort){
      System.out.println(i);
    }
  }
  public static void shuffle(int[] list){
    Random ran=new Random();
    for(int i=0; i<list.length; i++){
      swap(list, i, ran.nextInt(list.length));
    }
  }
  public static void swap(int[] list, int a, int b){
    int temp=list[a];
    list[a]=list[b];
    list[b]=temp;
  }
  public static int[] BogoMergeSort(int[] list){
    if(list.length==1){
      return list;
    }
    else{
      int[] list1=new int[list.length/2];
      for(int i=0; i<list.length/2; i++){
        list1[i]=list[i];
      }
      int[] list2=new int[list.length/2];
      for(int i=0; i<list.length/2; i++){
        list2[i]=list[i+(list.length/2)];
      }
      list1=BogoMergeSort(list1);
      list2=BogoMergeSort(list2);
      for(int i=0; i<)
    }
  }
}