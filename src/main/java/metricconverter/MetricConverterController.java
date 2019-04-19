package metricconverter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetricConverterController {

    @RequestMapping("/convertDistance")
    public double convertDistance(Double distance, DistanceUnit fromUnit, DistanceUnit toUnit) {
        return distance * Units.getDistanceUnits().get(fromUnit) / Units.getDistanceUnits().get(toUnit);
    }

    @RequestMapping("/convertTemperature")
    public double convertTemperature(Double temperature, TemperatureUnit fromUnit, TemperatureUnit toUnit) throws Exception {
        switch (fromUnit) {
            case KELVIN: {
                switch (toUnit) {
                    case FAHRENHEIT:
                        return celciusToFarenheit(temperature - Units.CELSIUS_TO_KELVIN);
                    case CELSIUS:
                        return temperature - Units.CELSIUS_TO_KELVIN;
                    case KELVIN:
                        return temperature;
                }
            }
            case CELSIUS: {
                switch (toUnit) {
                    case FAHRENHEIT:
                        return celciusToFarenheit(temperature);
                    case CELSIUS:
                        return temperature;
                    case KELVIN:
                        return temperature + Units.CELSIUS_TO_KELVIN;
                }
            }
            case FAHRENHEIT: {
                switch (toUnit) {
                    case FAHRENHEIT:
                        return temperature;
                    case CELSIUS:
                        return farenheitToCelcius(temperature);
                    case KELVIN:
                        return farenheitToCelcius(temperature) + Units.CELSIUS_TO_KELVIN;
                }
            }
        }

        throw new Exception("sjofdah");
    }

    @RequestMapping("/convertMass")
    public double convertMass(Double mass, MassUnit fromUnit, MassUnit toUnit){
        return mass * Units.getMassUnits().get(fromUnit) / Units.getMassUnits().get(toUnit);
    }

    private double celciusToFarenheit(double c) {
        return c * 9d / 5d + 32;
    }

    private double farenheitToCelcius(double f) {
        return (f - 32) * 5d / 9d;
    }


    @RequestMapping("/")
    public String index() {
        return "Converter!";
    }

}
