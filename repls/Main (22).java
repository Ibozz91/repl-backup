import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.io.BufferedWriter;
class Main {
  public static void main(String[] args) throws FileNotFoundException {
    int weight = 0;
    ArrayList<Ballot> VoteData = new ArrayList<Ballot>();
    System.out.println("Searching .txt files...");
    File Ballots = new File("ballots.txt");
    Scanner BallotReader = new Scanner(Ballots);
    File cndts = new File("candidates.txt");
    Scanner CandReader = new Scanner(cndts);
    Scanner scan = new Scanner(System.in);
    String candlist = CandReader.nextLine();
    ArrayList<String> candidates = new ArrayList<>(Arrays.asList(candlist.split(";")));
    for (int i = 0; i < candidates.size(); i++) {
      candidates.set(i, candidates.get(i).trim());
      if (candidates.get(i).length() == 0) {
        candidates.remove(i);
        i--;
      }
      if (Collections.frequency(candidates, candidates.get(i)) > 1) {
        throw new IllegalStateException(
            "Error on line 1: No duplicates! (The duplicate is " + candidates.get(i) + ").");
      }
      if (candidates.get(i).contains("=") || candidates.get(i).contains(">") || candidates.get(i).contains(":")) {
        throw new IllegalStateException("Error on line 1: " + candidates.get(i) + " contains an invalid character!");
      }
    }
    System.out.println("There are " + candidates.size() + " candidates:");
    for (int i = 0; i < candidates.size(); i++) {
      System.out.println(candidates.get(i));
    }
    if (candidates.size() == 0) {
      throw new IllegalStateException("But no candidate came.");
    }
    int[][] PairMatrix = new int[candidates.size()][candidates.size()];
    BufferedReader reader = new BufferedReader(new FileReader("ballots.txt"));
    int lines = 0;
    try {
      while (reader.readLine() != null)
        lines++;
      reader.close();
    } catch (IOException e) {

    }
    System.out.println("There are " + lines + " lines");
    for (int i = 0; i < lines; i++) {
      String line = BallotReader.nextLine();
      String[] splif = line.split(":");
      if (splif.length > 2) {
        throw new IllegalStateException("Error on line " + i + ": There should not be more than two colons.");
      } else if (splif.length == 1) {
        weight = 1;
      } else {
        weight = Integer.parseInt(splif[0].trim());
      }
      String[] SplitCand = splif[splif.length - 1].split(">");
      HashMap<String, Integer> Rankings = new HashMap<String, Integer>();
      for (int ii = 0; ii < SplitCand.length; ii++) {
        String[] SplitMoreCand = SplitCand[ii].split("=");
        for (String iii : SplitMoreCand) {
          if (!candidates.contains(iii.trim())) {
            throw new IllegalStateException(
                "Error on line " + i + ": \"" + iii.trim() + "\" was not found to be a candidate.");
          }
          if (!Rankings.containsKey(iii)) {
            Rankings.put(iii.trim(), ii + 1);
          }
        }
      }
      for (String iv : candidates) {
        if (!Rankings.containsKey(iv)) {
          Rankings.put(iv, SplitCand.length + 1);
        }
      }
      System.out.println(weight + " Ballots:\n" + Rankings);
      for (int v = 0; v < weight; v++) {
        VoteData.add(new Ballot(Rankings));
      }
    }
    boolean h = true;
    while (h) {
      System.out.println(
          "What mode do you want?\n(1) Simple: Tells you who won.\n(2) Verbose: Tells you every candidate's margin.\n(3) Super Verbose: Tells every single process made by Stable Voting");
      int mode = scan.nextInt();
      if (mode < 4 && mode > 0) {
        h = false;
      }
    }
    for (int vi = 0; vi < candidates.size(); vi++) {
      for (int vii = 0; vii < candidates.size(); vii++) {
        if (vi == vii) {
          PairMatrix[vi][vii] = 0;
        } else {
          int Margin = 0;
          for (int viii = 0; viii < VoteData.size(); viii++) {
            Margin += VoteData.get(viii).Pairwise(candidates.get(vi), candidates.get(vii));
          }
          PairMatrix[vi][vii] = Margin;
        }
      }
    }
    for (int[] x : PairMatrix) {
      for (int xi : x) {
        System.out.print(xi + ",");
      }
      System.out.println();
    }
    for (boolean[] xi : DefeatSet) {
      for (boolean xii : xi) {
        System.out.print(xii + ",");
      }
      System.out.println();
    }
    System.out.println(Smith(PairMatrix));
  }
  public static int StableVoting(int[][] PMatrix, ArrayList<Integer> ImpCand, ArrayList<String> Cand, int mode, ArrayList<Integer[]> Memory, BufferedWriter qazwsx) throws IOException{
    if(ImpCand.size()==1){
      return ImpCand.get(0);
    }
    int ind = -1;
    for(int gh = 0; gh<Memory.size(); gh++){
      if(Arrays.asList(Memory.get(gh)).containsAll(ImpCand) && ImpCand.containsAll(Arrays.asList(Memory.get(gh)))){
        ind=gh;
      }
    }
    if(ind>-1){
      qazwsx.write("This scenario has already happened. The winner is "+Cand.get(Memory.get(Memory.indexOf(ImpCand))[0]));
      return Memory.get(Memory.indexOf(ImpCand))[0];
    }
    boolean[] cw = new boolean[Cand.size()];
    for(int ils=0; ils<cw.length; ils++){
      cw[ils]=true;
    }
    if(mode>1){
      qazwsx.write("All candidate Margins:");
    }
    for(int qrs=0; qrs<PMatrix.length; qrs++){
      for(int tuv=0; tuv<PMatrix.length; tuv++){
        if(mode>=2 && ImpCand.contains(qrs) && ImpCand.contains(tuv)){
          qazwsx.write(Cand.get(qrs)+" vs. "+Cand.get(tuv)+": "+PMatrix[qrs][tuv]);
        }
        if(qrs!=tuv && PMatrix[qrs][tuv]>0){
          cw[tuv]=false;
        }
      }
    }
    for(int igiveup=0;igiveup<cw.length;igiveup++){
      if(cw[igiveup]){
        if(mode==3){
          qazwsx.write(Cand.get(igiveup)+" wins this recursion due to being a Condorcet winner!");
        }
        Collections.swap(ImpCand,0,ImpCand.indexOf(igiveup));
        Memory.add((Integer[])ImpCand.toArray());
        return igiveup;
      }
    }
    int[][] limPMatrix = new int[ImpCand.size()][ImpCand.size()];
    for(int wert=0; wert<ImpCand.size(); wert++){
      for(int erty=0; erty<ImpCand.size(); erty++){
        limPMatrix[wert][erty]=PMatrix[ImpCand.get(wert)][ImpCand.get(erty)];
      }
    }
    ArrayList<Integer> smth = Smith(limPMatrix);
    ArrayList<Integer> Smith2 = new ArrayList<Integer>();
    for(int edcrfv = 0; edcrfv < smth.size(); edcrfv++){
      Smith2.add(ImpCand.get(smth.get(edcrfv)));
    }
    if(mode==3){
      if(Smith2.containsAll(ImpCand)){
        qazwsx.write("The smith set contains every candidate.");
      } else{
        qazwsx.write("Smith set candidates:");
        for(int ow=0; ow<Smith2.size(); ow++){
          qazwsx.write(Cand.get(Smith2.get(ow)));
        }
      }
    }
    if(!Smith2.containsAll(ImpCand)){
      int t = StableVoting(PMatrix, Smith2, Cand, mode, Memory, qazwsx);
      Collections.swap(Smith2,0,Smith2.indexOf(t));
      Memory.add((Integer[])Smith2.toArray());
      return t;
    }
    boolean[][] DefeatSet = new boolean[ImpCand.size()][ImpCand.size()];
    for (int viii = 0; viii < ImpCand.size(); viii++) {
      for (int ix = 0; ix < ImpCand.size(); ix++) {
        if (viii != ix) {
          DefeatSet[viii][ix] = def(limPMatrix, viii, ix);
        }
        else{
          DefeatSet[viii][ix] = true;
        }
      }
    }
    for(int pqowei = 0; pqowei<ImpCand.size(); pqowei++){
      boolean b = true;
      for(int uahsd = 0; uahsd<ImpCand.size(); uahsd++){
        if(!DefeatSet[pqowei][uahsd]){
          b=false;
        }
      }
      if(b){
        return pqowei;
      }
    }
    ArrayList
  }
  public static int StableVoting(int[][] PMatrix, ArrayList<String> Cand, int mode) throws IOException{
    BufferedWriter poiop = new BufferedWriter(new FileWriter(new File("results.txt")));
    ArrayList<Integer> ImpCand = new ArrayList<Integer>();
    for(int pl = 0; pl<Cand.size(); pl++){
      ImpCand.add(pl);
    }
    return StableVoting(PMatrix, ImpCand, Cand, mode, new ArrayList<Integer[]>(), poiop);
  }
  public static boolean DoesAdefeatB(int[][] PMatrix, int A, int B, ArrayList<Integer> Nums, int rectest) {
    if (PMatrix[B][A] >= 0) {
      return false;
    }
    ArrayList<Integer> Num2 = (ArrayList<Integer>) Nums.clone();
    for (int i = 0; i < Nums.size(); i++) {
      if (PMatrix[B][Nums.get(i)] >= -PMatrix[B][A]) {
        Num2.remove(Nums.get(i));
        if (!(DoesAdefeatB(PMatrix, A, Nums.get(i), Num2, rectest + 1))) {
          return false;
        }
        Num2.add(Nums.get(i));
      }
    }
    return true;
  }
  public static boolean def(int[][] PMatrix, int A, int B) {
    ArrayList<Integer> N = new ArrayList<Integer>();
    for (int x = 0; x < PMatrix.length; x++) {
      if (x != A && x != B) {
        N.add(x);
      }
    }
    System.out.println(N);
    return DoesAdefeatB(PMatrix, A, B, N, 0);
  }
  public static ArrayList<Integer> Smith(int[][] PMatrix){
    boolean b=true;
    ArrayList<Integer> Set = new ArrayList<Integer>();
    int[] wins = new int[PMatrix.length];
    for(int xiii = 0; xiii<PMatrix.length; xiii++){
      for(int xiv = 0; xiv<PMatrix.length; xiv++){
        if(PMatrix[xiii][xiv]>0){
          wins[xiii]++;
        }
      }
    }
    for(int i:wins){
      System.out.println(i);
    }
    int max = 0;
    for(int i:wins){
      if(i>max){
        max=i;
      }
    }
    while(true){
      for(int y = 0; y < PMatrix.length; y++){
        if(wins[y]>=max && !Set.contains(y)){
          Set.add(y);
        }
      }
      b=true;
      if(Set.size()==PMatrix.length){
        return Set;
      }
      else{
        for(int pl = 0; pl<Set.size(); pl++){
          for(int pl2 = 0; pl2<PMatrix.length; pl2++){
            if((!Set.contains(pl2)) && PMatrix[Set.get(pl)][pl2]<1){
              b=false; //No smith set? :(
            }
          }
        }
      }
      if(b){
        return Set;
      }
      max--;
    }
  }
}