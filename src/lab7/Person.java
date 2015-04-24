package lab7;

public class Person 
{
      private String fName;
      private String lName;
      private Date DOB;

      public Person ()
      {
         fName = "";
         lName = "";   
         DOB = new Date(1,1,1980);
      }

      public Person(String f, String l)
      {
         fName = f;
         lName = l;
      }

      public Person(String f, String l, Date dob)
      {
         fName = f;
         lName = l;
         DOB = new Date(dob);
      }

      public Person(Person theObject)
      {
         fName = theObject.fName;
         lName = theObject.lName;
         DOB = new Date(theObject.getDOB());
      }

      public void setDOB(Date dob){
         DOB = new Date(dob);
      }

      public Date getDOB(){
         return new Date(DOB);
      }

      public String getFirstName()
      {
         return fName;
      }
      public String getLastName()
      {
         return lName;
      }

      public void setName(String f, String l)
      {
         fName = f;
         lName = l;
      }

      public String toString()
      {
         return fName + " " + lName + ", Born: " + DOB;
      }

      public boolean equals(Object other)
      {
        if ( other == null ) {
   	     return false;
         } // end of if ()
         else if ( this.getClass() != other.getClass() ) {
   	     return false;
         } // end of if ()
         else {
   	     Person person = (Person)other;
   	     return (this.toString().equals(person.toString()) && DOB.equals(person.DOB));
         } // end of else
      }

}// Person
