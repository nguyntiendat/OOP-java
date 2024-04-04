import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentList {
    private final ArrayList<Student> studentArrayList;
    public StudentList(){
        studentArrayList = new ArrayList<>();
    }
    public ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }
    public static void inputStudentInformation(ArrayList<Student> students, String name, String homeTown, String dayOfBirth) throws Exception {


        SimpleDateFormat dobFormat = new SimpleDateFormat("dd/MM/yyyy");
        dobFormat.setLenient(false);
        Date dob = new Date();
        try {
            dob = dobFormat.parse(dayOfBirth);
            Student student = new Student(name, dob, homeTown);
            students.add(student);
            System.out.println("Addition successful!");
        } catch (ParseException e) {
            System.out.println("Invalid date format! Student not added.");
            e.printStackTrace();
        }
    }

    public void printStudentList(ArrayList<Student> students) {
        System.out.println("Student ID|        Name        |  Home town   |      DoB    | Sub1 | Sub2 | Sub3 |" );
        for (Student student : students) {
            Student.printStudent(student);
        }
    }
    public static void readFromFile(ArrayList<Student> students) throws FileNotFoundException {
        File readfile = new File("student.txt");
        try (Scanner scan = new Scanner(readfile)){
            while (scan.hasNextLine()){
                String name = scan.nextLine();
                String homeTown = scan.nextLine();
                String dayOfBirth = scan.nextLine();


                SimpleDateFormat dobFormat = new SimpleDateFormat("dd/MM/yyyy");
                dobFormat.setLenient(false);
                Date dob = new Date();
                try {
                    dob = dobFormat.parse(dayOfBirth);
                    Student student = new Student(name, dob, homeTown);
                    students.add(student);

                } catch (ParseException e) {
                    System.out.println("Invalid date format! Student not added.");
                    e.printStackTrace();
                }
            }
            System.out.println("Addition successful!");
        }
    }
    public void writeToFile(ArrayList<Student> students){
        File writefile = new File("scholarShipList.txt");
        try (PrintWriter writer = new PrintWriter(writefile)) {
            for (Student student : students){
                writer.print(student.getID());
                writer.print("-"+student.getName()+"-");
                double avg = (student.getSubject1()+ student.getSubject2()+ student.getSubject3())/3;
                writer.println(avg);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void searchID(int ID, ArrayList<Student> students){
        ArrayList<Student> filterID = students.stream().
                filter(student -> student.getID() == ID).collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Student ID|        Name        |  Home town   |      DoB    | Sub1 | Sub2 | Sub3 |" );
        filterID.forEach(Student::printStudent);
    }

    public void ageStatistics(ArrayList<Student> students){
        long notYet18yrs = students.stream()
                .filter(student -> student.getAge() < 18).count();
        long age18To24yrs = students.stream()
                .filter(student -> student.getAge() >= 18 && student.getAge() <= 24).count();
        long olderThan24yrs = students.stream()
                .filter(student -> student.getAge() > 24).count();
        System.out.println("Not yet 18: " + notYet18yrs);
        System.out.println("From 18 to 24: " + age18To24yrs);
        System.out.println("Older than 24: " + olderThan24yrs);

    }
    public static void searchName(String name, ArrayList<Student> students){
        boolean invalidName = students.stream().anyMatch(student -> student.getName().contains(name));
        if (invalidName){
            ArrayList<Student> filterName = students.stream().filter(student -> student.getName().contains(name))
                    .collect(Collectors.toCollection(ArrayList::new));
            System.out.println("Student ID|        Name        |  Home town   |      DoB    | Sub1 | Sub2 | Sub3 |" );
            filterName.forEach(Student::printStudent);
        }
        else{
            System.out.println("No result!");
        }
    }
    public static void searchHometown(String hometown, ArrayList<Student> students){
        boolean invalidHometown = students.stream().anyMatch(student -> student.getHomeTown().contains(hometown));
        if (invalidHometown){
            ArrayList<Student> filterName = students.stream().filter(student -> student.getHomeTown().contains(hometown))
                    .collect(Collectors.toCollection(ArrayList::new));
            System.out.println("Student ID|        Name        |  Home town   |      DoB    | Sub1 | Sub2 | Sub3 |" );
            filterName.forEach(Student::printStudent);
        }
        else{
            System.out.println("No result!");
        }
    }

    public ArrayList<Student> hasScholarship(ArrayList<Student> students, ArrayList<Student> studentScholarships) {

        for (Student student : students) {
            if(student.getSubject1() > 5.0 && student.getSubject2() > 5.0 && student.getSubject3() > 5.0
                    && ((student.getSubject1()+student.getSubject2()+student.getSubject3())/3) >= 8.0){
                studentScholarships.add(student);
            }
        }
        return studentScholarships;

    }
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        StudentList studentArrayList = new StudentList();
        do {
            System.out.print("\n1. input by hand\n" +
                    "2. input from file\n" +
                    "3. input grade\n" +
                    "4. print student list\n" +
                    "5. search by name\n" +
                    "6. search by ID\n" +
                    "7. search by hometown\n" +
                    "8. Scholarship list\n" +
                    "9. Age statistics\n" +
                    "---------------------------\n" +
                    " Choice: ");
            int choice = scan.nextInt();
            switch (choice){
                case 1:
                    char exit;
                    //scan.nextLine();
                    do{
                        scan.nextLine();
                        System.out.print("Enter name: ");
                        String name = scan.nextLine();
                        System.out.print("Enter home town: ");
                        String homeTown = scan.nextLine();
                        System.out.print("Enter day of birth(dd/MM/yyyy): ");
                        String dayOfBirth = scan.nextLine();
                        inputStudentInformation(studentArrayList.getStudentArrayList(), name, homeTown, dayOfBirth);
                        System.out.print("Enter '0' to add students: ");
                        exit = scan.next().charAt(0);

                    }while (exit == '0');
                    break;
                case 2:
                    readFromFile(studentArrayList.getStudentArrayList());
                    break;
                case 3:
                    for (Student student: studentArrayList.getStudentArrayList()){
                        student.inputGrade(student);
                    }
                    break;
                case 4:
                    System.out.print("\n Student List\n");
                    studentArrayList.printStudentList(studentArrayList.getStudentArrayList());
                    break;
                case 5:
                    scan.nextLine();
                    System.out.print("Enter ID: ");
                    int id = scan.nextInt();
                    searchID(id, studentArrayList.getStudentArrayList());
                    break;
                case 6:
                    scan.nextLine();
                    System.out.print("Enter name: ");
                    String search = scan.nextLine();
                    searchName(search, studentArrayList.getStudentArrayList());
                    break;
                case 7:
                    scan.nextLine();
                    System.out.print("Enter hometown: ");
                    String hometown = scan.nextLine();
                    searchHometown(hometown, studentArrayList.getStudentArrayList());
                    break;
                case 8:
                    System.out.println("Scholarship list");
                    ArrayList<Student> studentScholarships = new ArrayList<>();
                    studentArrayList.printStudentList(studentArrayList.hasScholarship(studentArrayList.getStudentArrayList(), studentScholarships));
                    System.out.println("Print to file?\n 'y' or press any key to exit ");
                    char y = scan.next().charAt(0);
                    if(y == 'y'){
                        studentArrayList.writeToFile(studentScholarships);
                    }
                    else break;
                case 9:
                    System.out.println("Age statistics");
                    studentArrayList.ageStatistics(studentArrayList.getStudentArrayList());
            }
        } while (true);

    }
}
