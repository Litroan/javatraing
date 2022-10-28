import java.util.Scanner;

//³]©w¤¶­±
interface Animal{
    public void animalSounds();
    public void sleep();
}

    class Pig implements Animal{
        public void animalSounds(){
            System.out.println("Wee~ Wee~");
        }

        public void sleep(){
            System.out.println("ZZZ");
        }
    }

    class Cat implements Animal{
        public void animalSounds(){
            System.out.println("meow~ meow~");
        }

        public void sleep(){
            System.out.println("zzz");
        }
    }

class inter{
    public static void main(String[] args){
        Scanner animalNames = new Scanner(System.in);
        String name = animalNames.next();
        
    }
}