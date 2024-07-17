class LinkedList{
  private Node headNode;
  public LinkedList(Node nodetoset){
    headNode = nodetoset;
  }
  public Node firstNode(){
    return headNode;
  }
  public Node lastNode(){
    Node lastnodewannabe = headNode;
    while(lastnodewannabe.getNextNode()!=null){
      lastnodewannabe = lastnodewannabe.getNextNode();
    }
    return lastnodewannabe;
  }
  public void addNode(int value){
    lastNode().setNode(new Node(value));
  }
  public void addNode(int index, int value){
    if(get(index)!=-1){
      if(index==0){
        Node theNode = new Node(value, headNode);
        headNode = theNode;
      }
      else{
        Node aaaa = getNode(index);
        Node theNode = new Node(value, aaaa);
        getNode(index-1).setNode(theNode);
      }
    }
  }
  public void removeNode(int index){
    if(get(index)!=-1){
      if(index==0){
        headNode = headNode.getNextNode();
      }
      else{
        getNode(index-1).setNode(getNode(index).getNextNode());
      }
    }
  }
  public void removeNode(){
    Node lastnodewannabe = headNode;
    while(lastnodewannabe.getNextNode()!=lastNode()){
      lastnodewannabe = lastnodewannabe.getNextNode();
    }
    lastnodewannabe.setNode(null);
  }
  public int findNode(int value){
    Node theNode = headNode;
    for(int i = 0; theNode!=null; i++){
      if(theNode.getValue() == value){
        return i;
      }
      theNode = theNode.getNextNode();
    }
    return -1;
  }
  public int get(int index){
    Node theNode = headNode;
    for(int i = 0; i < index && theNode!=null; i++){
      theNode = theNode.getNextNode();
    }
    if(theNode==null){
      return -1;
    }
    else{
      return theNode.getValue();
    }
  }
  public Node getNode(int index){
    Node theNode = headNode;
    for(int i = 0; i < index && theNode!=null; i++){
      theNode = theNode.getNextNode();
    }
    return theNode;
  }
}