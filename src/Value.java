public enum Value
{
  TWO("TWO"), THREE("THREE"), FOUR("FOUR"), FIVE("FIVE"), SIX("SIX"), SEVEN("SEVEN"), EIGHT("EIGHT"), NINE("NINE"), TEN("TEN"), JACK("JACK"), QUEEN("QUEEN"), KING("KING"), ACE("ACE");
    private String value;

  Value(String value){
    this.value = value;
  }//returns the value as a string instead of an enum value
}//end of enum value
