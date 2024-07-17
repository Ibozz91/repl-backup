import java.util.Random;
class Main {
  public static void main(String[] args) {
    int[] tosort={6, 9, 4, 2, 0, 1, 3, 3, 7};
    for(int i:tosort){
      System.out.println(i);
    }
    System.out.println("");
    for(int i:BogoMergeSort(tosort)){
      System.out.println(i);
    }
  }
  public static void shuffle(int[] list){
    Random ran=new Random();
    for(int i=0; i<list.length; i++){
      swap(list, i, ran.nextInt(list.length));
    }
  }
  public static boolean issorted(int[] list){
    for(int i=0; i<list.length-1; i++){
      if(list[i]>list[i+1]){
        return false;
      }
    }
    return true;
  }
  public static void swap(int[] list, int a, int b){
    int temp=list[a];
    list[a]=list[b];
    list[b]=temp;
  }
	public static int[] BogoMergeSort(int [] list) {
		if(list.length==1){
			return list;
		}
		else {
			while(true){
        int[] merge1=new int[list.length/2];
        int[] merge2=new int[list.length-(list.length/2)];
        for(int eee=0; eee<list.length/2; eee++) {
          merge1[eee] = list[eee];
        }
        for(int eee2=0; eee2<list.length-(list.length/2); eee2++) {
          merge2[eee2] = list[eee2+list.length/2];
        }
        merge1 = BogoMergeSort(merge1);
        merge2 = BogoMergeSort(merge2);
        shuffle(list);
        if(issorted(list)){
          return list;
        }
      }
		}
  }
}