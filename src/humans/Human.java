package humans;

 abstract class Human {

    private final int id;
    private final String name;
    private int phoneNumber;
    private int age;


    public Human(int id,String name,int phoneNumber,int age){
        this.id=id;
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.age=age;

    }

     public int getAge() {
         return age;
     }
     public int getId() {
         return id;
     }
     public String getName() {
         return name;
     }
     public int getPhoneNumber() {
         return phoneNumber;
     }

     @Override
     public String toString() {
         return "Human{" +
                 "id=" + id +
                 ", name='" + name + '\'' +
                 ", phoneNumber=" + phoneNumber +
                 ", age=" + age +
                 '}';
     }
 }
