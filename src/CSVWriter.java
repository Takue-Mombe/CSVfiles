import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CSVWriter {

    public static void main(String[] args) {
        List<Student> students = generateRandomStudents(20); // Generate 20 random students

        String csvFile = "trial2.csv";
        FileWriter writer = null;

        try {
            writer = new FileWriter(csvFile);

            // Writing headers
            writer.append("hitmail,yearEnrolled,firstName,Status,lastName,programme,department,dateOfBirth,phoneNumber,email,nextOfKin,GuardianNumber,Address\n");

            // Writing data
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            for (Student student : students) {
                writer.append(student.getHitmail()+"ko").append(",");
                writer.append(String.valueOf(student.getYearEnrolled())).append(",");
                writer.append(student.getFirstName()).append(",");
                writer.append(student.getLastName()).append(",");
                writer.append(student.getProgramme()).append(",");
                writer.append(student.getDepartment()).append(",");
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
        int yearEnrolled = 2000 + random.nextInt(23); // Assum
        return new Student(
                "H" + (yearEnrolled % 100) + "0" + String.format("%03d", random.nextInt(1000)) + (char) (random.nextInt(26) + 'a') + "@hit.ac.zw",
               2024,

                getRandomFirstName(),
                getRandomLastName(),
                getRandomProgramme(),
                getRandomDepartment(),
                263700000000L + random.nextInt(99999999),
                "decefemz@gmail.com",
                getRandomNextOfKin(),
                "",
                ""
        );
    }


    // Sample data generation methods (you can replace these with your actual data generation methods)
    private static String getRandomFirstName() {
        String[] firstNames = {"John", "Jane", "Michael", "Emily", "David", "Sarah", "Daniel", "Jessica", "Christopher", "Emma"};
        Random random = new Random();
        return firstNames[random.nextInt(0,firstNames.length)];
    }

    private static String getRandomLastName() {
        String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez"};
        Random random = new Random();
        return lastNames[random.nextInt(0,lastNames.length)];
    }

    private static String getRandomProgramme() {
        String[] programmes = {"Computer Science", "Engineering", "Business Administration", "Biology", "Psychology", "Mathematics", "History", "English", "Art", "Chemistry"};
        Random random = new Random();
        return programmes[random.nextInt(0,programmes.length)];
    }

    private static String getRandomDepartment() {
        String[] departments = {"Information Technology", "Mechanical Engineering", "Marketing", "Biochemistry", "Social Sciences", "Statistics", "Archaeology", "Linguistics", "Fine Arts", "Organic Chemistry"};
        Random random = new Random();
        return departments[random.nextInt(0,departments.length)];
    }


    private static String getRandomNextOfKin() {
        String[] nextOfKin = {"Parent", "Sibling", "Spouse", "Relative", "Friend"};
        Random random = new Random();
        return nextOfKin[random.nextInt(0,nextOfKin.length)];
    }
}



