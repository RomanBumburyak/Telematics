public class VehicleInfo {

           int vin;
        double odometerMilesTraveled;
        double consumption;
        double odometerReading;
        double engineSize;

//    public VehicleInfo() {
//
//    }

    public VehicleInfo () {
        this.vin = vin;
        this.odometerMilesTraveled = odometerMilesTraveled;
        this.consumption = consumption;
        this.odometerReading = odometerReading;
        this.engineSize = engineSize;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public double getOdometerMilesTraveled() {
        return odometerMilesTraveled;
    }

    public void setOdometerMilesTraveled(double odometerMilesTraveled) {
        this.odometerMilesTraveled = odometerMilesTraveled;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public double getOdometerReading() {
        return odometerReading;
    }

    public void setOdometerReading(double odometerReading) {
        this.odometerReading = odometerReading;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }



}
