//https://www.youtube.com/watch?v=v5CVGLpa5VU
public class BinaryTree {
  //https://www.youtube.com/watch?v=bzIBj90D3YA
  private Node MainNode;
  private Node LeftNode;
  private Node RightNode;
	public BinaryTree(int number) {
		
	}
	public void BuildANodeWorkshopLeft(int y) {
		Node leftnode=new Node(y);
	}
	public void BuildANodeWorkshopRight(int x) {
		Node rightnode=new Node(x);
	}
	//bi.totheleft().thenumber()
	public BinaryTree totheleft() {
		return leftnode;
	}
	public BinaryTree totheright() {
		return rightnode;
	}
	public int thenumber() {
		return thenumberrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr;
	}
	public void insertion(int num) {
		if(num<=thenumberrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr) {
			if(!lo) {
				BuildANodeWorkshopLeft(num);
			}
			else {
				totheleft().insertion(num);
			}
		}
		else {
			if(!lo) {
				BuildANodeWorkshopLeft(num);
			}
			else {
				totheright().insertion(num);
			}
		}
	}
}