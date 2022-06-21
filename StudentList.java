import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {

//		Check arguments
        AllString allString = new AllString() ;
        if (args[0].equals(allString.argumentForPrintingStudentList)) {

            System.out.println(allString.printingDataLoaded);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(allString.fileNameOfStudentNamesList)));
                String lineOfStudentNames = bufferedReader.readLine();
                String splitStudentName[] = lineOfStudentNames.split(allString.commaCharacter);
                for (String studentName : splitStudentName) {
                    System.out.println(studentName);
                }
            } catch (Exception e) {
            }
            System.out.println(allString.printingDataLoaded);
        } else if (args[0].equals(allString.argumentForPrintingRandomStudentName)) {
            System.out.println(allString.printingDataLoaded);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(allString.fileNameOfStudentNamesList)));
                String lineOfStudentNames = bufferedReader.readLine();
                String splitStudentName[] = lineOfStudentNames.split(allString.commaCharacter);
                Random random = new Random();
                int randomValue = random.nextInt(splitStudentName.length) ;
                System.out.println(splitStudentName[randomValue]);
            } catch (Exception e) {
            }
            System.out.println(allString.printingDataLoaded);
        } else if (args[0].contains(allString.argumentForInsertStudent)) {
            System.out.println(allString.printingDataLoaded);
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(allString.fileNameOfStudentNamesList, true));
                String studentName = args[0].substring(1);
                Date date = new Date();
                String dateFormat = allString.dateFormat;
                DateFormat convertDateFormat = new SimpleDateFormat(dateFormat);
                String fd = dateFormat.format(dateFormat);
                bufferedWriter.write(allString.getCommaCharacterWithSpace + studentName + allString.printUpdate + fd);
                bufferedWriter.close();
            } catch (Exception e) {

            }
            System.out.println(allString.printingDataLoaded);
        } else if (args[0].contains(allString.argumentForFindingStudentName)) {
            System.out.println(allString.printingDataLoaded);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
                String lineOfStudentNames = bufferedReader.readLine();
                String splitStudentName[] = lineOfStudentNames.split(allString.commaCharacter);
                boolean done = false;
                String findName = args[0].substring(1);
                findName = allString.printSpace + findName ;
                System.out.println(findName);
                for (int idex = 0; idex < splitStudentName.length && !done; idex++) {
                    if (splitStudentName[idex].equals(findName)) {
                        System.out.println(allString.printWeFoundIt);
                        done = true;
                    }
                }
            } catch (Exception e) {

            }
            System.out.println(allString.printingDataLoaded);
        } else if (args[0].contains(allString.argumentForCountingStudentName)) {
            System.out.println(allString.printingDataLoaded);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(allString.fileNameOfStudentNamesList)));
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
                System.out.println(totalWord + allString.printWordsFound);
            } catch (Exception e) {
            }
        }else{
             System.out.println(allString.printWrongArgument);
        }
    }
}