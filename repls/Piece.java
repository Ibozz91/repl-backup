public abstract class Piece{
  private boolean color;
  private int coordinate;
  private Piece[] board;
  public Piece(boolean color, int coordinate, Piece[] board){
    this.color=color;
    this.coordinate=coordinate;
    this.board=board;
  }
  public abstract void Move(int moveto);
  public abstract boolean CheckMove();
  
}