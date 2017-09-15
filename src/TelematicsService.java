
public class TelematicsService {

    public static void report(VehicleInfo vehicleInfo){               //method, this is where you will add the
            


        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(vehicleInfo);


            File file = new File("greetings.txt");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("Hello World!\n"); //Very simple!
            fileWriter.write("File IO is cool and not scary!");
            fileWriter.close(); //close() cleans up and commits changes

        }

        } catch {




        }



}

