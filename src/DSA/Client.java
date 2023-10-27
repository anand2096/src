package DSA;

public class Client {

    public static void main(String[] args) {
        Person p1=new Person();
        p1.age=10;
        p1.name="ABC";
        Person p2=new Person();
        p2.age=20;
        p2.name="DEF";
        fun(p1,p2);
        System.out.println(p1.age+" "+p1.name);
        System.out.println(p2.age+" "+p2.name);

    }
    static void fun(Person p1dash,Person p2dash){
        Person temp=p1dash;
        p1dash=p2dash;
        p2dash=temp;
    }
}
