package ua.edu.ucu.tempseries;

import java.util.Arrays;
import java.util.InputMismatchException;


public class TemperatureSeriesAnalysis {
    public double[] temperatureSeries;
    public static int size = 0;
    public static int capacity = 0;


    public TemperatureSeriesAnalysis() {
        temperatureSeries = new double[]{};
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        for (double check: temperatureSeries) {
            if (check < -273) {
                throw new InputMismatchException();
            }
        }
        this.temperatureSeries = Arrays.copyOf(temperatureSeries,
                temperatureSeries.length);
        size = temperatureSeries.length;
        capacity = temperatureSeries.length;
    }

    public double average() {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }

        double answer = 0;
        for (double temp : this.temperatureSeries) {
            answer += temp/temperatureSeries.length;
        }
        return answer;
    }

    public double deviation() {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double aver = average();
        double answer = 0;
        for (double temp : temperatureSeries) {
            answer += temp * temp;
        }
        answer /=temperatureSeries.length;
        double averageSquare = aver*aver;
        return Math.sqrt(answer-averageSquare);
    }

    public double min() {
        double minHere = temperatureSeries[0];
        for (double temp : temperatureSeries) {
            if (temp < minHere) {
                minHere = temp;
            }
        }
        return minHere;
    }

    public double max() {
        double maxHere = temperatureSeries[0];
        for (double temp : temperatureSeries) {
            if (temp > maxHere) {
                maxHere = temp;
            }
        }
        return maxHere;
    }


    public double findTempClosestToZero() {
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double minLength = tempValue - temperatureSeries[0];
        double closest = temperatureSeries[0];
        for (double temp : temperatureSeries) {
            double curDif = Math.abs(temp-tempValue);
            if (minLength > curDif) {
                minLength = curDif;
                closest = temp;
            }
        }
        return closest;
    }

    public double[] findTempsLessThen(double tempValue) {
        int sizeLessArray = 0;
        for (double temp : temperatureSeries) {
            if (temp < tempValue) {
                sizeLessArray += 1;
            }
        }
        int curElement = 0;
        double[] lessArray = new double[sizeLessArray];
        for (double temper : temperatureSeries) {
            if (temper < tempValue) {
                lessArray[curElement] += 1;
            }
        }
        return lessArray;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        int sizeMoreArray = 0;
        for (double temp : temperatureSeries) {
            if (temp < tempValue) {
                sizeMoreArray += 1;
            }
        }
        int curElement = 0;
        double[] moreArray = new double[sizeMoreArray];
        for (double temper : temperatureSeries) {
            if (temper > tempValue) {
                moreArray[curElement] += 1;
            }
        }
        return moreArray;
    }

    public TempSummaryStatistics summaryStatistics() {
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }

    public double addTemps(double... temps) {
        for (double check: temperatureSeries) {
            if (check < -273) {
                throw new InputMismatchException();
            }
        }

        int sizeNewArray = 0;
        if (temps.length + size > capacity) {
            capacity *= 2;
        }

        int elPoint = size+1;
        for ( double temp : temps) {
            temperatureSeries[elPoint] = temp;
        }

        double sum = 0;
        for (double alltemp : temps) {
            sum += alltemp;
        }
        return sum;
    }
}
