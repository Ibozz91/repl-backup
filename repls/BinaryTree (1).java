import java.util.ArrayList;
class BinaryTree{
  private Node headNode;
  public BinaryTree(Node nodetoset){
    headNode = nodetoset;
  }
  public void addNode(int value){
    addNode(value, headNode);
  }
  public void addNode(int value, Node node){
    if(value < node.getValue()){
      if(node.leftNode() == null){
        node.setleftNode(new Node(value));
      }
      else{
        addNode(value, node.leftNode());
      }
    }
    else{
      if(node.rightNode() == null){
        node.setrightNode(new Node(value));
      }
      else{
        addNode(value, node.rightNode());
      }
    }
  }
  public Node headNode(){
    return headNode;
  }
  public int depth(Node node){
    if(node==null){
      return 0;
    }
    int a = depth(node.leftNode());
    int b = depth(node.rightNode());
    if(b>a){
      return b+1;
    }
    else{
      return a+1;
    }
  }
  public int depth(){
    return depth(headNode);
  }
  public String path(int value, Node node){
    if(value > node.getValue()){
      return Integer.toString(node.getValue())+"-"+path(value, node.rightNode());
    }
    else if(value < node.getValue()){
      return Integer.toString(node.getValue())+"-"+path(value, node.leftNode());
    }
    else{
      return Integer.toString(node.getValue());
    }
  }
  public String path(int value){
    return path(value, headNode);
  }
  public boolean isBalanced(Node node){
    if(node.leftNode()==null){
      return depth(node.rightNode())<2;
    }
    else if(node.rightNode()==null){
      return depth(node.leftNode())<2;
    }
    else{
      if(Math.abs(depth(node.rightNode())-depth(node.leftNode()))<2){
        if(isBalanced(node.leftNode()) && isBalanced(node.rightNode())){
          return true;
        }
        else{
          return false;
        }
      }
      else{
        return false;
      }
    }
  }
  public boolean isBalanced(){
    return isBalanced(headNode);
  }
  public ArrayList<Integer> allnodes(Node node){
    if(node==null){
      return new ArrayList<Integer>();
    }
    ArrayList<Integer> thenodes = new ArrayList<Integer>();
    thenodes.addAll(allnodes(node.leftNode()));
    thenodes.add(node.getValue());
    thenodes.addAll(allnodes(node.rightNode()));
    return thenodes;
  }
  public ArrayList<Integer> allnodes(){
    return allnodes(headNode);
  }
  public int median(ArrayList<Integer> thestuffs){
    return thestuffs.size()/2;
  }
  public Node thebalance(ArrayList<Integer> themoststuff){
    if(themoststuff.size() == 0){
      return null;
    }
    int medindex = median(themoststuff);
    Node thenoodle = new Node(themoststuff.get(medindex));
    ArrayList<Integer> totheleft = new ArrayList<Integer>();
    for(int i = 0; i < medindex; i++){
      totheleft.add(themoststuff.get(i));
    }
    ArrayList<Integer> totheright = new ArrayList<Integer>();
    for(int i = medindex+1; i < themoststuff.size(); i++){
      totheright.add(themoststuff.get(i));
    }
    thenoodle.setleftNode(thebalance(totheleft));
    thenoodle.setrightNode(thebalance(totheright));
    return thenoodle;
  }
  public void balance(){
    headNode = thebalance(allnodes());
  }
  public String toString(){
    int depth = depth(headNode);
    String printout = "";
    ArrayList<Node> nodes = new ArrayList<Node>();
    nodes.add(headNode);
    for(int i = 0; i < depth; i++){
      String[] line = new String[(int)(Math.pow(2,depth))-1];
      for(int j = 0; j < line.length; j++){
        line[j] = " ";
      }
      int divide = (int)(Math.pow(2,i))+1;
      for(int j = 1; j < nodes.size()+1; j++){
        if(nodes.get(j-1).getValue()!=-1){
          line[Math.round((int)(((j*line.length)/divide)*(1.0)))] = nodes.get(j-1).toString();
        }
      }
      for(String s: line){
        printout += s;
      }
      printout += "\n";
      ArrayList<Node> nodes2 = new ArrayList<Node>();
      for(int j = 0; j < nodes.size(); j++){
        if(nodes.get(j).leftNode()!=null){
          nodes2.add(nodes.get(j).leftNode());
        }
        else{
          nodes2.add(new Node(-1));
        }
        if(nodes.get(j).rightNode()!=null){
          nodes2.add(nodes.get(j).rightNode());
        }
        else{
          nodes2.add(new Node(-1));
        }
      }
      nodes.removeAll(nodes);
      nodes.addAll(nodes2);
    }
    return printout;
  }
}