class Board{
  private String state;
  private String[][] boar;
  public Board(){
    state="_";
    boar = new String[3][3];
    for(int i = 0; i < 3; i++){
      for(int n = 0; n < 3; n++){
        boar[i][n]="_";
      }
    }
  }
  private String gamestate(){
    return state;
  }
  private String[][] boardd(){
    return boar;
  }
  private void place(int row, int column, String turn){
    if(!(row<0 || row>2 || column<0 || column>2 || (!boar[row][column].equals("_")))){
      boar[row][column]=turn;
    }
  }
  
}