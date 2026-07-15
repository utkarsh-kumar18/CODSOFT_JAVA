import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==== Welcome to the Student Grade Calculator! ====");

        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();

        int total = 0;

        for (int i = 1; i <= subjects; i++) {
            System.out.print("Enter marks of subject " + i + " (out of 100) : ");
            int marks = sc.nextInt();

            while (marks < 0 || marks > 100) {
                System.out.println("Invalid marks! Enter again: ");
                marks = sc.nextInt();
            }

            total += marks;
        }

        double average = (double) total / subjects;
        char grade;

        if (average >= 90){
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("\n-------- Result -----");
        System.out.println("Total Marks : " + total);
        System.out.printf("Average Percentage : %.2f%%\n" , average);
        System.out.println("Grade  : " + grade);

        sc.close();
    }
}