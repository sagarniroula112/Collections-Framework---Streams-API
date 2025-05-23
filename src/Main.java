import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> studentsList = new ArrayList<>();

        studentsList.add(new Student(1, "Rakesh", "Computer Engineering", 24, 99.5));
        studentsList.add(new Student(2, "Priya", "Mechanical Engineering", 22, 76.3));
        studentsList.add(new Student(3, "Ankit", "Electrical Engineering", 23, 88.7));
        studentsList.add(new Student(4, "Megha", "Computer Engineering", 21, 55.4));
        studentsList.add(new Student(5, "Sneha", "Information Technology", 22, 81.2));
        studentsList.add(new Student(6, "Aman", "Mechanical Engineering", 24, 65.0));
        studentsList.add(new Student(7, "Vikas", "Civil Engineering", 25, 59.5));
        studentsList.add(new Student(8, "Kavita", "Electrical Engineering", 23, 92.1));
        studentsList.add(new Student(9, "Tina", "Computer Engineering", 22, 78.9));
        studentsList.add(new Student(10, "Deepak", "Information Technology", 24, 83.0));
        studentsList.add(new Student(11, "Arjun", "Civil Engineering", 21, 45.0));
        studentsList.add(new Student(12, "Ritu", "Computer Engineering", 23, 91.5));
        studentsList.add(new Student(13, "Soham", "Mechanical Engineering", 22, 69.3));
        studentsList.add(new Student(14, "Ayesha", "Electrical Engineering", 23, 74.2));
        studentsList.add(new Student(15, "Rohan", "Information Technology", 22, 88.9));
        studentsList.add(new Student(16, "Simran", "Civil Engineering", 24, 52.0));
        studentsList.add(new Student(17, "Aditya", "Computer Engineering", 23, 97.8));
        studentsList.add(new Student(18, "Pooja", "Mechanical Engineering", 21, 61.1));
        studentsList.add(new Student(19, "Neha", "Electrical Engineering", 25, 90.4));
        studentsList.add(new Student(20, "Ishaan", "Information Technology", 22, 84.7));
        studentsList.add(new Student(21, "Nikhil", "Computer Engineering", 23, 73.2));
        studentsList.add(new Student(22, "Divya", "Mechanical Engineering", 24, 77.0));
        studentsList.add(new Student(23, "Aryan", "Civil Engineering", 21, 68.9));
        studentsList.add(new Student(24, "Kiran", "Information Technology", 23, 95.1));
        studentsList.add(new Student(25, "Rahul", "Computer Engineering", 22, 60.4));
        studentsList.add(new Student(26, "Swati", "Electrical Engineering", 24, 87.5));
        studentsList.add(new Student(27, "Manish", "Civil Engineering", 23, 55.0));
        studentsList.add(new Student(28, "Anjali", "Computer Engineering", 24, 89.6));
        studentsList.add(new Student(29, "Bhavna", "Mechanical Engineering", 22, 82.4));
        studentsList.add(new Student(1, "Dev", "Information Technology", 25, 66.3));

        System.out.println("Sample data loaded: " + studentsList.size() + " students");

        // Removing duplicates qn2
        Set<Student> stdsAfterRemDups = new HashSet<>(studentsList);
        System.out.println(stdsAfterRemDups);

        // Group students by department qn3
        Map<String, List<Student>> stdsByDept = new HashMap<>();


    }
}
