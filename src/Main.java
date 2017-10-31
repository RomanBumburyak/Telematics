import java.util.Scanner;

public class Main {
    public static void main(String[] args) {          //you can only have this method once, it acts similarly to a server in JS.
        Scanner scanner = new Scanner(System.in);       //We use scanner because it allows a person to input information
        TelematicsService telematicsService = new TelematicsService();
                                                                                  // get the information for the VehicleInfo from the command line

        System.out.println("Please enter VIN number: ");
        String vininput = scanner.nextLine();
        int vin = Integer.parseInt(vininput);

        System.out.println("Odometer: Miles traveled");
        String odometerMilesTraveledinput = scanner.nextLine();
        double odometerMilesTraveled = Double.parseDouble(odometerMilesTraveledinput);

        System.out.println("Gasoline Consumption: ");
        String consumptioninput = scanner.nextLine();
        double consumption = Double.parseDouble(consumptioninput);

        System.out.println("Current Odometer Reading at: ");
        String odometerReadinginput = scanner.nextLine();
        double odometerReading = Double.parseDouble(odometerReadinginput);

        System.out.println("Vehicle Engine Size ");
        String engineSizeinput = scanner.nextLine();
        double engineSize = Double.parseDouble(engineSizeinput);



        VehicleInfo vehicleinfo = new VehicleInfo();       ///new instance of a car, vehicle info ////////This is my object
        vehicleinfo.setVin(vin);
        vehicleinfo.setOdometer(odometerMilesTraveled);
        vehicleinfo.setConsumption(consumption);
        vehicleinfo.setOilChange(odometerReading);
        vehicleinfo.setEngineSize(engineSize);

        telematicsService.report(vehicleinfo);

    }






}