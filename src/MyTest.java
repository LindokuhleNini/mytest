import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MyTest {

    public static void main(String[] args) {
        GregorianCalendar gc = new GregorianCalendar();
        Scanner kbd = new Scanner(System.in);

        String names[] = {"Adam", "Alex", "Aaron", "Ben", "Carl", "Dan", "David", "Edward", "Fred", "Frank", "George", "Hal", "Hank", "Ike", "John", "Jack", "Joe", "Larry", "Monte", "Matthew"};
        String surnames[] = {"Anderson", "Ashwoon", "Aikin", "Bateman", "Bongard", "Bowers", "Boyd", "Cannon", "Cast", "Deitz", "Dewalt", "Ebner", "Frick", "Hancock", "Haworth", "Hesch", "Hoffman", "Kassing", "Knutson", "Lawless", "Bernad"};
        List<String> nameList = new ArrayList<>();
        List<String> surnameList = new ArrayList<>();
        List<String[]> records = new ArrayList<>();

        int id = 1;
        char initials;
        int age;
        int year;
        int dayOfYear;
        String dob;
        int input;

        System.out.println("How many records?");
        input = kbd.nextInt();

        while (records.size() < input) {

            for (int i = 0; i < names.length - 1; i++) {
                for (int x = 0; x < names.length - 1; x++) {

                    //Concatenate two names
                    String twoNames = names[i] + " " + names[x + 1];

                    //Concatenate two surnames
                    String twoSurnames = surnames[i] + " " + surnames[x + 1];

                    //Generate random number from the length of the concatenated strings
                    int randomNum = (int) (Math.random() * twoNames.length()) + 1;
                    int randomNum2 = (int) (Math.random() * twoSurnames.length()) + 1;

                    //Use the random numbers to generate random substrings
                    String newName = twoNames.substring(0, 1).toUpperCase() + twoNames.substring(randomNum);
                    String newSurname = twoSurnames.substring(0, 1).toUpperCase() + twoSurnames.substring(randomNum2);

                    //Number of records must not be more than specified input
                    if (records.size() < input) {

                        //Name & surname should be > than 5
                        if (newName.length() > 5 && newSurname.length() > 5) {

                            //Check if name and surname are unique
                            if (!nameList.contains(newName) && !surnameList.contains(newSurname)) {
                                nameList.add(newName);
                                surnameList.add(newSurname);

                                initials = Character.toUpperCase(newName.charAt(0));

                                year = dateBetween(1900, 2010);
                                gc.set(gc.YEAR, year);
                                dayOfYear = dateBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
                                gc.set(gc.DAY_OF_YEAR, dayOfYear);
                                dob = gc.get(gc.DAY_OF_MONTH) + "/" + (gc.get(gc.MONTH) + 1) + "/" +gc.get(gc.YEAR);
                                age = 2022 - year;

                                records.add(new String[] {String.valueOf(id), newName, newSurname, String.valueOf(initials), String.valueOf(age), dob});

                                //System.out.println(id + ", " + newName.trim() + ", " + newSurname+", "+initials+", "+age+", "+dob);
                                writeDataToCsvFile(records);
                                id++;
                            }

                        }
                        System.out.println("done");
                    }


                }

            }

        }
    }

    public static void writeDataToCsvFile(List<String[]> records)
    {

        // first create file object for file placed at location
        // specified by filepath
        File file = new File("output.csv");

        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // create a List which contains String array
            List<String[]> data = new ArrayList<String[]>();
            data.add(new String[] { "ID", "Name", "Surname", "Initials", "Age", "DateOfBirth" });
            writer.writeAll(data);
            writer.writeAll(records);

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static int dateBetween(int start, int end){
        return start + (int)Math.round(Math.random() * (end - start));
    }
}
