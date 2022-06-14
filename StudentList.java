import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {

//		Check arguments
        if (args[0].equals("a")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
                String lineOfStudentNames = bufferedReader.readLine();
                String splitStudentName[] = lineOfStudentNames.split(",");
                for (String studentName : splitStudentName) {
                    System.out.println(studentName);
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("r")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
                String lineOfStudentNames = bufferedReader.readLine();
                String splitStudentName[] = lineOfStudentNames.split(",");
                Random random = new Random();
                int randomValue = random.nextInt(splitStudentName.length) ;
                System.out.println(splitStudentName[randomValue]);
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("students.txt", true));
                String studentName = args[0].substring(1);
                Date date = new Date();
                String dateFormat = "dd/mm/yyyy-hh:mm:ss a";
                DateFormat convertDateFormat = new SimpleDateFormat(dateFormat);
                String fd = dateFormat.format(dateFormat);
                bufferedWriter.write(", " + studentName + "\nList last updated on " + fd);
                bufferedWriter.close();
            } catch (Exception e) {

            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
                String lineOfStudentNames = bufferedReader.readLine();
                String splitStudentName[] = lineOfStudentNames.split(",");
                boolean done = false;
                String findName = args[0].substring(1);
                findName = " " + findName ;
                System.out.println(findName);
                for (int idex = 0; idex < splitStudentName.length && !done; idex++) {
                    if (splitStudentName[idex].equals(findName)) {
                        System.out.println("We found it!");
                        done = true;
                    }
                }
            } catch (Exception e) {

            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
                String lineOfStudentName = bufferedReader.readLine();
                char charArray[] = lineOfStudentName.toCharArray();
                boolean in_word = false;
                int spaceCount = 0;
                for (char space : charArray) {
                    if (space == ' ') {
                        spaceCount = spaceCount + 1;
                    }
                }
                int totalWord = spaceCount + 1 ;
                System.out.println(totalWord + " word(s) found ");
            } catch (Exception e) {
            }
        }else{
             System.out.println("Your argument is wrong !");
        }
    }
}