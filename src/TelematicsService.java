import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class TelematicsService {

    public static void report(VehicleInfo vehicleInfo) {            //method, this is where you will add the
        System.out.println(vehicleInfo.getVin());


        try {
            File file = new File(vehicleInfo.getVin() + ".json" );
            FileWriter fileWriter = new FileWriter(file);


            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(vehicleInfo);
            fileWriter.write(json);
            fileWriter.close(); //close() cleans up and commits changes , //If Java doesn't find the file it will create it for us.


            File filey = new File(".");
            for (File f : filey.listFiles()) {
                if (f.getName().endsWith(".json")) {
                    // Now you have a File object named "f".
                    // You can use this to create a new instance of Scanner

                    VehicleInfo vi = mapper.readValue(json, VehicleInfo.class);


                   ////////////////////////////////
                    String html = "";

                html += "<html>\n" +
                        "  <title>Vehicle Telematics Dashboard</title>\n" +
                        "  <body>\n" +
                        "    <h1 align=\"center\">Averages for # vehicles</h1>\n" +
                        "    <table align=\"center\">\n" +
                        "        <tr>\n" +
                        "            <th>Odometer (miles) |</th><th>Consumption (gallons) |</th><th>Last Oil Change |</th><th>Engine Size (liters)</th>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td align=\"center\">#</td><td align=\"center\">#</td><td align=\"center\">#</td align=\"center\"><td align=\"center\">#</td>\n" +
                        "        </tr>\n" +
                        "    </table>\n" +
                        "    <h1 align=\"center\">History</h1>\n" +
                        "    <table align=\"center\" border=\"1\">\n" +
                        "        <tr>\n" +
                        "            <th>VIN</th><th>Odometer (miles)</th><th>Consumption (gallons)</th><th>Last Oil Change</th><th>Engine Size (liters)</th>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td align=\"center\">#</td><td align=\"center\">#</td><td align=\"center\">#</td><td align=\"center\">#</td align=\"center\"><td align=\"center\">#</td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td align=\"center\">45435</td><td align=\"center\">123</td><td align=\"center\">234</td><td align=\"center\">345</td align=\"center\"><td align=\"center\">4.5</td>\n" +
                        "        </tr>\n" +
                        "    </table>\n" +
                        "  </body>\n" +
                        "</html>";

                }
            }

            VehicleInfo vehicleStatistics = new VehicleInfo();
            int carQuantity = 0;

            vehicleStatistics.setOdometerMilesTraveled((vehicleStatistics.getOdometerMilesTraveled() + vehicleInfo.getOdometerMilesTraveled()) / carQuantity);
            vehicleStatistics.setConsumption((vehicleStatistics.getConsumption()+ vehicleInfo.getConsumption()) / carQuantity);
            vehicleStatistics.setOdometerReading((vehicleStatistics.getOdometerReading() + vehicleInfo.getOdometerReading()) / carQuantity);
            vehicleStatistics.setEngineSize((vehicleStatistics.getEngineSize() + vehicleInfo.getEngineSize()) / carQuantity);

                carQuantity++;

                File dashboard = new File("dashboard.html");
                FileWriter dashboardInfo = new FileWriter(dashboard);

            String dashboardDisplay = "";

            dashboardDisplay += "<html>\n" +
                    "  <title>Vehicle Telematics Dashboard</title>\n" +
                    "  <body>\n" +
                    "    <h1 align=\"center\">Averages for" + carQuantity +  "vehicles</h1>\n" +
                    "    <table align=\"center\">\n" +
                    "        <tr>\n" +
                    "            <th>Odometer (miles) |</th><th>Consumption (gallons) |</th><th>Last Oil Change |</th><th>Engine Size (liters)</th>\n" +
                    "        </tr>\n" +
                    "        <tr>\n" +
                    "            <td align=\"center\"> " + vehicleStatistics.odometerMilesTraveled + " </td><td align=\"center\">" + vehicleStatistics.consumption + "</td><td align=\"center\"> " + vehicleStatistics.odometerReading + "</td align=\"center\"><td align=\"center\">"+ vehicleStatistics.engineSize  + "</td>\n" +
                    "        </tr>\n" +
                    "    </table>\n" +
                    "    <h1 align=\"center\">History</h1>\n" +
                    "    <table align=\"center\" border=\"1\">\n" +
                    "        <tr>\n" +
                    "            <th>VIN</th><th>Odometer (miles)</th><th>Consumption (gallons)</th><th>Last Oil Change</th><th>Engine Size (liters)</th>\n" +
                    "        </tr>\n" +
                    "        <tr>\n" +
                    "            <td align=\"center\"> "+ vehicleInfo.getOdometerMilesTraveled() + "</td><td align=\"center\"> "+ vehicleInfo.getConsumption() + " </td><td align=\"center\"> "+ vehicleInfo.getOdometerReading() +"</td><td align=\"center\">"+ vehicleInfo.getOdometerReading() +"</td align=\"center\"><td align=\"center\">"+ vehicleInfo.getEngineSize() +"</td>\n" +
                    "        </tr>\n" +
                    "        <tr>\n" +
                    "            <td align=\"center\">45435</td><td align=\"center\">123</td><td align=\"center\">234</td><td align=\"center\">345</td align=\"center\"><td align=\"center\">4.5</td>\n" +
                    "        </tr>\n" +
                    "    </table>\n" +
                    "  </body>\n" +
                    "</html>";

            dashboardInfo.write(dashboardDisplay);
            dashboardInfo.close();
        }
        catch (IOException ex) { //A general exception that covers many errors
            ex.printStackTrace();
        }






                }

    }







