package lab12;

public enum States {

  NA(""), AL("Alabama"), AK("Alaska"), AZ("Arizona"), AR("Arkansas"), CA(
      "California"), CO("Colorado"), CT("Connecticut"), DC(
      "District Of Columbia"), DE("Delaware"), FL("Florida"), GA("Georgia"),
  HI("Hawaii"), ID("Idaho"), IL("Illinois"), IN("Indiana"), IA("Iowa"), KS(
      "Kansas"), KY("Kentucky"), LA("Louisiana"), ME("Maine"), MD("Maryland"),
  MA("Massachusetts"), MI("Michigan"), MN("Minnesota"), MS("Mississippi"), MO(
      "Missouri"), MT("Montana"), NE("Nebraska"), NV("Nevada"), NH(
      "New Hampshire"), NJ("New Jersey"), NM("New Mexico"), NY("New York"),
  NC("North Carolina"), ND("North Dakota"), OH("Ohio"), OK("Oklahoma"), OR(
      "Oregon"), PA("Pennsylvania"), RI("Rhode Island"), SC("South Carolina"),
  SD("South Dakota"), TN("Tennessee"), TX("Texas"), UT("Utah"), VT("Vermont"),
  VA("Virginia"), WA("Washington"), WV("West Virginia"), WI("Wisconsin"), WY(
      "Wyoming");

  public static final int ELEMENTS = 52;
  private String displayName;
  private static States[] statesArray = States.values();

  States(final String displayName) {
    this.displayName = displayName;
  }

  public String displayName() {
    return displayName;
  }

  public String toString() {
    return displayName;
  }

  public static States[] getStatesArray() {
    return statesArray;
  }
}
