class Question{
  private String que;
  private String[] PossibleAnswers;
  private int CorrectAnswer;
  public Question(String ques, String[] Anss, int Cor){
    que=ques;
    PossibleAnswers=Anss;
    CorrectAnswer=Cor;
  }
  public String quest(){
    return que;
  }
  public String[] answ(){
    return PossibleAnswers;
  }
  public int corans(){
    return CorrectAnswer;
  }
}