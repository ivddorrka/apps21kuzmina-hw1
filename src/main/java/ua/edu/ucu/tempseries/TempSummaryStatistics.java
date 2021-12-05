package ua.edu.ucu.tempseries;

import lombok.Getter;

@Getter
public class TempSummaryStatistics {
    private final double averageTemperature;
    private final double deviationTemperature;
    private final double minimumTemperature;
    private final double maximumTemperature;

    TempSummaryStatistics(double averageTemperature, double deviationTemperature,
                          double minimumTemperature, double maximumTemperature) {
        this.averageTemperature = averageTemperature;
        this.deviationTemperature = deviationTemperature;
        this.minimumTemperature = minimumTemperature;
        this.maximumTemperature = maximumTemperature;
    }
}
