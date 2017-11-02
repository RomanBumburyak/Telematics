
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TelematicsService {

    public void report(VehicleInfo vehicleInfo) {
        createCar(vehicleInfo);
        createInformation(vehicleInfo);
    }




    public void createCar(VehicleInfo vehicleInfo) {
        try {
            System.out.println(vehicleInfo);
            String fileName = vehicleInfo.getVin() + ".json";
            File newFile = new File(fileName);
            FileWriter fileWriter = new FileWriter(newFile);
            System.out.println(fileName);

            ObjectMapper mapper = new ObjectMapper();              //serialization of Java Object into JSON, aka Java -> JSON
            String json = mapper.writeValueAsString(vehicleInfo);

            fileWriter.write(json);
            fileWriter.close();

        } catch (IOException e) {         //Basic exception
            System.out.println(e);
        }
    }


    //    fix the values in the HTML
    public void createInformation(VehicleInfo vehicleInfo) {

        try {
            VehicleInfo vehicleData = new VehicleInfo();
            String htmlFile = "";
            int amountOfCars = 0;

            ObjectMapper mapper = new ObjectMapper();
            File file = new File(".");
            for (File f : file.listFiles()) {
                if (f.getName().endsWith(".json")) {
                    amountOfCars++;
                    VehicleInfo vi = mapper.readValue(f, VehicleInfo.class);

                    vehicleData.setOdometer((vehicleData.getOdometer() + vi.getOdometer()));
                    vehicleData.setConsumption((vehicleData.getConsumption() + vi.getConsumption()));
                    vehicleData.setOilChange((vehicleData.getOilChange() + vi.getOilChange()));
                    vehicleData.setEngineSize((vehicleData.getEngineSize() + vi.getEngineSize()));

                    htmlFile += "        <tr>\n" +
                            "            <td align=\"center\">" + vi.getVin() + "</td><td align=\"center\">"+ vi.getOdometer() +"</td><td align=\"center\">"+ vi.getConsumption() +"</td><td align=\"center\">"+ vi.getOilChange() +"</td align=\"center\"><td align=\"center\">"+ vi.getEngineSize() +"</td>\n" +
                            "        </tr>\n";

                    // Now you have a File object named "f".
                    // You can use this to create a new instance of Scanner
                }
            }

            vehicleData.setOdometer((vehicleData.getOdometer() / amountOfCars));
            vehicleData.setConsumption((vehicleData.getConsumption() / amountOfCars));
            vehicleData.setOilChange((vehicleData.getOilChange() / amountOfCars));
            vehicleData.setEngineSize((vehicleData.getEngineSize() / amountOfCars));


            File dashboard = new File("dashboard.html");
            FileWriter dashboardInfo = new FileWriter(dashboard);
            String content = "<html>\n" +
                    "  <title>Vehicle Telematics Dashboard</title>\n" +
                    "  <body>\n" +
                    "    <h1 align=\"center\">Averages for "+ amountOfCars +" vehicles</h1>\n" +
                    "    <table align=\"center\">\n" +
                    "        <tr>\n" +
                    "            <th>Odometer (miles) |</th><th>Consumption (gallons) |</th><th>Last Oil Change |</th><th>Engine Size (liters)</th>\n" +
                    "        </tr>\n" +
                    "        <tr>\n" +
                    "            <td align=\"center\">"+ Math.round(vehicleData.getOdometer()) +"</td><td align=\"center\">"+ Math.round(vehicleData.getConsumption()) +"</td><td align=\"center\">"+ Math.round(vehicleData.getOilChange()) +"</td align=\"center\"><td align=\"center\">"+ Math.round(vehicleData.getEngineSize()) +"</td>\n" +
                    "        </tr>\n" +
                    "    </table>\n" +
                    "    <h1 align=\"center\">History</h1>\n" +
                    "    <table align=\"center\" border=\"1\">\n" +
                    "        <tr>\n" +
                    "            <th>VIN</th><th>Odometer (miles)</th><th>Consumption (gallons)</th><th>Last Oil Change</th><th>Engine Size (liters)</th>\n" +
                    "        </tr>\n" +
                    htmlFile +
                    "    </table>\n" +
                    "  </body>\n" +
                    "</html>\n";


            dashboardInfo.write(content);
            dashboardInfo.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

























