import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Main stepA = new Main();
        stepA.a01();
    }

    void a01() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a birth year > ");
        int birthyear = s.nextInt();
        int age = 2022 - birthyear; 
        System.out.println("You are " + age + " years old.");
    }
}