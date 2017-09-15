import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class TelematicsService {

    public static void report(VehicleInfo vehicleInfo) {            //method, this is where you will add the
        System.out.println(vehicleInfo.getVin());


        File file = new File(vehicleInfo.getVin() + ".json" );



        try {
            File file = new File("greetings.txt");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("Hello World!\n"); //Very simple!
            fileWriter.write("File IO is cool and not scary!");
            fileWriter.close(); //close() cleans up and commits changes
        } //If Java doesn't find the file it will create it for us
        catch (IOException ex) { //A general exception that covers many errors
            ex.printStackTrace();
        }


//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            String json = mapper.writeValueAsString(vehicleInfo);
//            File file = new File("greetings.txt");
//            FileWriter fileWriter = new FileWriter(file);
//        } catch (Exception ex) {
//        }
//            try{
//            fileWriter.write("Hello World!\n"); //Very simple!
//            fileWriter.write("File IO is cool and not scary!");
//            fileWriter.close(); //close() cleans up and commits changes
//        }catch (Exception ex) {
//
//            }







    }








    }







