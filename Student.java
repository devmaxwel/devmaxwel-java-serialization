import java.io.*;

class Student implements Serializable {

//    serialVersionUID acts as security to avoid someone changing the consumer expected application results over the telephone line;

    public static final long serialVersionUID= 1L;

    private String name;
    private int age;
    private String address;

//    transient variable does not get deserialized
transient  int y;


// Class constructor
    public Student(String name, int age, String address){
        this.name = name;
        this.age = age;
        this.address = address;
    }
//     Setters
    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age=age;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setY(int y){
        this.y = y;
    }

//    Getters

    public String getName(){

        return name;
    }

    public  int getAge(){

        return age;
    }

    public String getAddress(){

        return address;
    }

    public  int getY(){

        return  y;
    }

    @Override
    public String toString(){
        return ("Student Name is: " +this.getName() + " Student age is: " + this.getAge() +
                " Student Address is: " + this.getAddress() + "Value of y: " + this.getY());

    }

    public static <fileInputStream, objectInputStream> void main(String[] args) {
        Student student1 = new Student("Maxwell", 20,"Lucky-Summer");
        student1.setY(10);

        String filename = "Desktop:\\Gads_2021\\java.txt";
        FileOutputStream fileOut = null;
        ObjectOutputStream objOut = null;

//   Serialization begins;
        try{
            fileOut = new FileOutputStream(filename);
            objOut = new ObjectOutputStream(fileOut);

            objOut.writeObject(student1);

            objOut.close();
            fileOut.close();

            System.out.println("The serialized object is:\n\n"+ student1);
            System.out.println("the serialized x is: " +student1.getY());
        }

        catch (IOException ex){
            System.out.println("IOException is caught");


        }

//        Deserialization
        FileInputStream fileIn = null;
        ObjectInputStream objIn = null;
        try{
            fileIn = new FileInputStream(filename);

            objIn = new ObjectInputStream(fileIn);

            Student object = (Student) objIn.readObject();

            System.out.println("The Deserialized object is:\n" +object);
            System.out.println("the deserialized x is: " +object.getY());

            objIn.close();
            fileIn.close();
        }
        catch (IOException ex){
            System.out.println("IOException is caught");
        }

        catch (ClassNotFoundException ex){
            System.out.println("ClassNotFound"+ "is caught");
        }

    }

}
