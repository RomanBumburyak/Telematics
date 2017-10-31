public class VehicleInfo {
    public int Vin;
    public double odometer;
    public double consumption;
    public double oilChange;
    public double engineSize;


    public VehicleInfo() {
        this.Vin = Vin;
        this.odometer = odometer;
        this.consumption = consumption;
        this.oilChange = oilChange;
        this.engineSize = engineSize;
    }

    //    getters for variables
    public int getVin() {
        return Vin;
    }

    public double getOdometer() {
        return odometer;
    }

    public double getConsumption() {
        return consumption;
    }

    public double getOilChange() {
        return oilChange;
    }

    public double getEngineSize() {
        return engineSize;
    }

    //    setters for variables
    public void setVin(int Vin) {
        this.Vin = Vin;
    }

    public void setOdometer(double odometer) {
        this.odometer = odometer;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public void setOilChange(double oilChange) {
        this.oilChange = oilChange;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }
}