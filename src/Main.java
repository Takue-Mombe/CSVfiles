import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        List<Student> students = generateRandomStudents(20); // Generate 20 random students

        String csvFile = "student.csv";
        FileWriter writer = null;

        try {
            writer = new FileWriter(csvFile);

            // Writing headers
            writer.append("hitmail,password,yearEnrolled,firstName,Status,lastName,programme,department,dateOfBirth,phoneNumber,email,nextOfKin,GuardianNumber,Address\n");

            // Writing data
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            for (Student student : students) {
                writer.append(student.getHitmail()).append(",");
                writer.append(student.getPassword()).append(",");
                writer.append(String.valueOf(student.getYearEnrolled())).append(",");
                writer.append(student.getFirstName()).append(",");
                writer.append(student.getStatus().toString()).append(",");
                writer.append(student.getLastName()).append(",");
                writer.append(student.getProgramme()).append(",");
                writer.append(student.getDepartment()).append(",");
                writer.append(dateFormat.format(student.getDateOfBirth())).append(",");
                writer.append(String.valueOf(student.getPhoneNumber())).append(",");
                writer.append(student.getEmail()).append(",");
                writer.append(student.getNextOfKin()).append(",");
                writer.append(student.getGuardianNumber()).append(",");
                writer.append(student.getAddress()).append("\n");
            }

            System.out.println("CSV file has been created successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.flush();
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to generate random students
    private static List<Student> generateRandomStudents(int count) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            students.add(createRandomStudent());
        }
        return students;
    }

    // Method to create a random student
    private static Student createRandomStudent() {
        Random random = new Random();
        int yearEnrolled = 2000 + random.nextInt(23); // Assuming current year is 2023
        String hitmail = generateHitmail(yearEnrolled);
        String password = generateRandomString(8); // Generating random password
        String firstName = generateRandomFirstName();
        Status status = random.nextBoolean() ? Status.ACTIVE : Status.INACTIVE; // Randomly assigning status
        String lastName = generateRandomLastName();
        String programme = "Computer Science"; // Assuming all students belong to Computer Science program
        String department = "Engineering"; // Assuming all students belong to Engineering department
        Date dateOfBirth = generateRandomDateOfBirth();
        Long phoneNumber = generateRandomPhoneNumber();
        String email = hitmail + "@example.com"; // Generating email based on hitmail
        String nextOfKin = generateRandomFirstName() + " " + generateRandomLastName(); // Generating random next of kin
        String guardianNumber = String.valueOf(1000000000L + random.nextInt(900000000)); // Generating random guardian number
        String address = generateRandomAddress();

        return new Student(hitmail, password, yearEnrolled, firstName, status, lastName, programme, department, dateOfBirth, phoneNumber, email, nextOfKin, guardianNumber, address);
    }

    // Method to generate hitmail
    private static String generateHitmail(int yearEnrolled) {
        Random random = new Random();
        return "H" + (yearEnrolled % 100) + "0" + String.format("%03d", random.nextInt(1000)) + (char) (random.nextInt(26) + 'a');
    }

    // Method to generate random string of given length
    private static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }

    // Method to generate random first name
    private static String generateRandomFirstName() {
        String[] firstNames = {"John", "Michael", "Emma", "Emily", "Daniel", "Sophia", "David", "Olivia", "Matthew", "Isabella"};
        Random random = new Random();
        return firstNames[random.nextInt(firstNames.length)];
    }

    // Method to generate random last name
    private static String generateRandomLastName() {
        String[] lastNames = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"};
        Random random = new Random();
        return lastNames[random.nextInt(lastNames.length)];
    }

    // Method to generate random date of birth between 18 and 30 years ago
    private static Date generateRandomDateOfBirth() {
        Random random = new Random();
        int year = 2023 - random.nextInt(30 - 18 + 1) - 18;
        int month = random.nextInt(12) + 1;
        int day = random.nextInt(28) + 1; // Assuming all months have maximum of 28 days for simplicity
        return new Date(year - 1900, month - 1, day);
    }

    // Method to generate random phone number
    private static Long generateRandomPhoneNumber() {
        Random random = new Random();
        return 1000000000L + random.nextInt(900000000); // Generating 10-digit phone number
    }

    // Method to generate random address
    private static String generateRandomAddress() {
        String[] addresses = {"123 Main St", "456 Oak Ave", "789 Elm St", "101 Pine St", "202 Maple Ave", "303 Cedar St", "404 Birch Ave"};
        Random random = new Random();
        return addresses[random.nextInt(addresses.length)];
    }
    }