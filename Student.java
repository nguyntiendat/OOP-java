import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Student {
    private static int count = 0;
    private final int ID = ++count;
    private String name;
    private final Date birthday;
    private String homeTown;
    private double subject1, subject2, subject3;
    public Student(String name, Date birthday, String homeTown) {
        this.name = name;
        this.birthday = birthday;
        this.homeTown = homeTown;
        subject1 = 0;
        subject2 = 0;
        subject3 = 0;
    }
    public int getID(){
        return ID;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setHomeTown(String homeTown){
        this.homeTown = homeTown;
    }
    public String getHomeTown(){
        return homeTown;
    }
    public Date getDayOfBirth(){
        return birthday;
    }
    public void setSubject1(double grade){ // grade: Diem so
        subject1 = grade;
    }
    public double getSubject1(){
        return subject1;
    }
    public void setSubject2(double grade){
        subject2 = grade;
    }
    public double getSubject2(){
        return subject2;
    }
    public void setSubject3(double grade){
        subject3 = grade;
    }
    public double getSubject3(){
        return subject3;
    }
//    public static void inputStudentInformation(ArrayList<Student> students, String name, String homeTown, String dayOfBirth) throws Exception {
//
//
//        SimpleDateFormat dobFormat = new SimpleDateFormat("dd/MM/yyyy");
//        dobFormat.setLenient(false);
//        Date dob = new Date();
//        try {
//            dob = dobFormat.parse(dayOfBirth);
//            Student student = new Student(name, dob, homeTown);
//            students.add(student);
//            System.out.println("Addition successful!");
//        } catch (ParseException e) {
//            System.out.println("Invalid date format! Student not added.");
//            e.printStackTrace();
//        }
//    }
    public int getAge(){
        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear();
        int month = currentDate.getMonthValue();
        int day = currentDate.getDayOfMonth();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthday);
        int sYear = calendar.get(Calendar.YEAR);
        int sMonth = calendar.get(Calendar.MONTH) + 1;
        int sDay = calendar.get(Calendar.DAY_OF_MONTH);
        int ageYear = year - sYear;
        if (month-sMonth < 0 || (month - sMonth == 0 && day - sDay < 0)){
            return ageYear-1;
        }
        return ageYear;
    }
    public static void printStudent(Student student) {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        System.out.printf(" %d        |   %s   |   %s   |  %s  | %.2f | %.2f | %.2f |\n",
                student.ID,
                student.name,
                student.homeTown,
                f.format(student.getDayOfBirth()),
                student.subject1, student.subject2,student.subject3);
    }
//    public static void printStudentList(ArrayList<Student> students) {
//        System.out.println("Student ID|        Name        |  Home town   |      DoB    | Sub1 | Sub2 | Sub3 |" );
//        for (Student student : students) {
//            printStudent(student);
//        }
//    }
//    public static void readFromFile(ArrayList<Student> students) throws FileNotFoundException {
//        File readfile = new File("student.txt");
//        try (Scanner scan = new Scanner(readfile)){
//            while (scan.hasNextLine()){
//                String name = scan.nextLine();
//                String homeTown = scan.nextLine();
//                String dayOfBirth = scan.nextLine();
//
//
//                SimpleDateFormat dobFormat = new SimpleDateFormat("dd/MM/yyyy");
//                dobFormat.setLenient(false);
//                Date dob = new Date();
//                try {
//                    dob = dobFormat.parse(dayOfBirth);
//                    Student student = new Student(name, dob, homeTown);
//                    students.add(student);
//
//                } catch (ParseException e) {
//                    System.out.println("Invalid date format! Student not added.");
//                    e.printStackTrace();
//                }
//            }
//            System.out.println("Addition successful!");
//        }
//    }
    public void inputGrade(Student student){
        Scanner scan = new Scanner(System.in);
        System.out.println("Student ID: " + student.getID());
        System.out.print("Subject 1: ");
        double gradeSub1 = scan.nextDouble();
        System.out.print("Subject 2: ");
        double gradeSub2 = scan.nextDouble();
        System.out.print("Subject 3: ");
        double gradeSub3 = scan.nextDouble();
        student.subject1 = gradeSub1;
        student.subject2 = gradeSub2;
        student.subject3 = gradeSub3;

    }
//    public static void searchID(int ID, ArrayList<Student> students){
//        ArrayList<Student> filterID = students.stream().
//                filter(student -> student.getID() == ID).collect(Collectors.toCollection(ArrayList::new));
//        System.out.println("Student ID|        Name        |  Home town   |      DoB    | Sub1 | Sub2 | Sub3 |" );
//        filterID.forEach(Student::printStudent);
//    }
//    public static void searchName(String name, ArrayList<Student> students){
//        boolean invalidName = students.stream().anyMatch(student -> student.getName().contains(name));
//        if (invalidName){
//            ArrayList<Student> filterName = students.stream().filter(student -> student.getName().contains(name))
//                            .collect(Collectors.toCollection(ArrayList::new));
//            System.out.println("Student ID|        Name        |  Home town   |      DoB    | Sub1 | Sub2 | Sub3 |" );
//            filterName.forEach(Student::printStudent);
//        }
//        else{
//            System.out.println("No result!");
//        }
//    }
//    public ArrayList<Student> hasScholarship(ArrayList<Student> students, ArrayList<Student> studentScholarships) {
//        for (Student student : students) {
//            if(subject1 > 5.0 && subject2 > 5.0 &&subject3 > 5.0 && ((subject1+subject2+subject3)/3) >= 8.0){
//                studentScholarships.add(student);
//            }
//        }
//        return studentScholarships;
//
//    }
//    public static void main(String[] args) throws Exception {
//        Scanner scan = new Scanner(System.in);
//        ArrayList<Student> studentArrayList = new ArrayList<>();
//
//        do {
//            System.out.print("\n1. input by hand\n" +
//                    "2. input from file\n" +
//                    "3. input grade\n" +
//                    "4. print student list\n" +
//                    "5. search by name\n" +
//                    "6. search by ID\n" +
//                    "7. search by hometown\n" +
//                    "8. Scholarship list\n" +
//                    "---------------------------\n" +
//                    " Choice: ");
//            int choice = scan.nextInt();
//            switch (choice){
//                case 1:
//                    char exit;
//                    //scan.nextLine();
//                    do{
//                        scan.nextLine();
//                        System.out.print("Enter name: ");
//                        String name = scan.nextLine();
//                        System.out.print("Enter home town: ");
//                        String homeTown = scan.nextLine();
//                        System.out.print("Enter day of birth(dd/MM/yyyy): ");
//                        String dayOfBirth = scan.nextLine();
//                        inputStudentInformation(studentArrayList, name, homeTown, dayOfBirth);
//                        System.out.print("Enter '0' to add students: ");
//                        exit = scan.next().charAt(0);
//
//                    }while (exit == '0');
//                    break;
//                case 2:
//                    readFromFile(studentArrayList);
//                    break;
//                case 3:
//                    for (Student student: studentArrayList){
//                        student.inputGrade(student);
//                    }
//                    break;
//                case 4:
//                    System.out.print("\n Student List\n");
//                    printStudentList(studentArrayList);
//                    break;
//                case 5:
//                    scan.nextLine();
//                    System.out.print("Enter name: ");
//                    String search = scan.nextLine();
//                    searchName(search, studentArrayList);
//                    break;
//                case 6:
//                    scan.nextLine();
//                    System.out.print("Enter name: ");
//                    int id = scan.nextInt();
//                    searchID(id, studentArrayList);
//                    break;
//                case 7:
//                    break;
//                case 8:
//                    System.out.println("Scholarship list");
//
//
//            }
//        } while (true);
//
//    }
}
