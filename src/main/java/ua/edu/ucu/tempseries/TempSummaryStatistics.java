package ua.edu.ucu.tempseries;

import lombok.Getter;

@Getter
public class TempSummaryStatistics {
    public double averageTemperature;
    public double deviationTemperature;
    public double minimumTemperature;
    public double maximumTemperature;

    TempSummaryStatistics(double averageTemperature, double deviationTemperature, double minimumTemperature, double maximumTemperature) {
        this.averageTemperature = averageTemperature;
        this.deviationTemperature = deviationTemperature;
        this.minimumTemperature = minimumTemperature;
        this.maximumTemperature = maximumTemperature;
    }
}
