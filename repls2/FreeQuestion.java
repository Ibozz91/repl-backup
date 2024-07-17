class FreeQuestion{
  private String question;
  private String answer;
  public FreeQuestion(String q, String a){
    question=q;
    answer=a;
  }
  public String gq(){
    return question;
  }
  public String ga(){
    return answer;
  }
}