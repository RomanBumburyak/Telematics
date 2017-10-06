import com.fasterxml.jackson.databind.ObjectMapper;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TelematicsService {


    static void report(VehicleInfo vehicleInfo) {

        try {
            String file = vehicleInfo.vin + ".json";
            System.out.println(file);
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(file), vehicleInfo);
            String json = mapper.writeValueAsString(vehicleInfo);

        } catch (IOException e){
            e.printStackTrace();
        }
//        JAVA
        VehicleInfo information;

        ArrayList<VehicleInfo> info = new ArrayList<>();
        File newfile = new File(".");
        for (File f : newfile.listFiles()) {
            if (f.getName().endsWith(".json")) {


//
                try {

                    ObjectMapper mapper = new ObjectMapper();
                    information = mapper.readValue(f, VehicleInfo.class);
                    info.add(information);

                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            String htmlVehicleInfo = "";
            int carQuantity = 0;
            double averageOdometerMilesTraveled = 0;
            double averageConsumption = 0;
            double averageOdometerReading = 0;
            double avgEngineSizeInLiters = 0;

            for (VehicleInfo vehicleStatistics: info) {
                averageOdometerMilesTraveled += vehicleStatistics.getOdometerMilesTraveled();
                averageConsumption += vehicleStatistics.getConsumption();
                averageOdometerReading += vehicleStatistics.getOdometerMilesTraveled();
                avgEngineSizeInLiters += vehicleStatistics.getEngineSize();

                htmlVehicleInfo += "        <tr>\n" +
                        "            <td align=\"center\">" + vehicleStatistics.getVin() + "</td><td align=\"center\">"+ vehicleStatistics.getOdometerMilesTraveled() +"</td><td align=\"center\">"+ vehicleStatistics.getConsumption() +"</td><td align=\"center\">"+ vehicleStatistics.getOdometerReading() +"</td align=\"center\"><td align=\"center\">"+ vehicleStatistics.getEngineSize() +"</td>\n" +
                        "        </tr>\n";
            }
            averageOdometerMilesTraveled = averageOdometerMilesTraveled / carQuantity;
            averageConsumption = averageConsumption / carQuantity;
            averageOdometerReading = averageOdometerReading /carQuantity;
            avgEngineSizeInLiters = avgEngineSizeInLiters / carQuantity;



            try {

                File dashboardDisplay = new File ("dashboard.html");
                dashboardDisplay.createNewFile();

                FileWriter filey = new FileWriter(dashboardDisplay);
                String dashboard = "<html>\n" +
                        "  <title>Vehicle Telematics Dashboard</title>\n" +
                        "  <body>\n" +
                        "    <h1 align=\"center\">Averages for " + carQuantity + " vehicles</h1>\n" +
                        "    <table align=\"center\">\n" +
                        "        <tr>\n" +
                        "            <th>Odometer (miles) |</th><th>Consumption (gallons) |</th><th>Last Oil Change |</th><th>Engine Size (liters)</th>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td align=\"center\">" + Math.round(averageOdometerMilesTraveled) + "</td><td align=\"center\">" + Math.round(averageConsumption)+ "</td><td align=\"center\">"+ Math.round(averageOdometerReading) + "</td align=\"center\"><td align=\"center\">"+ Math.round(avgEngineSizeInLiters) +"</td>\n" +
                        "        </tr>\n" +
                        "    </table>\n" +
                        "    <h1 align=\"center\">History</h1>\n" +
                        "    <table align=\"center\" border=\"1\">\n" +
                        "        <tr>\n" +
                        "            <th>VIN</th><th>Odometer (miles)</th><th>Consumption (gallons)</th><th>Last Oil Change</th><th>Engine Size (liters)</th>\n" +
                        "        </tr>\n" +
                        htmlVehicleInfo +
                        "    </table>\n" +
                        "  </body>\n" +
                        "</html>\n";
                filey.write(dashboard);
                filey.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        //// - read 1 file into json
//// - read all files into json[]
//// - convert json into java object (VehicleInfo)
//// - read array of json into array of java object

    }



}



