package techbasics.domain.metricconverter.service;

import lombok.extern.slf4j.Slf4j;
import techbasics.unit.DistanceUnit;
import techbasics.unit.MassUnit;
import techbasics.unit.TemperatureUnit;
import techbasics.unit.Units;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/metricConverter")
@Slf4j
public class MetricConverterController {

    @GetMapping
    public String index() {
        return "Converter!";
    }

    @GetMapping("/convertDistance")
    public Double convertDistance(Double value, DistanceUnit fromUnit, DistanceUnit toUnit) {
        return value * Units.getDistanceUnits().get(fromUnit) / Units.getDistanceUnits().get(toUnit);
    }

    @GetMapping("/convertTemperature")
    public Double convertTemperature(Double value, TemperatureUnit fromUnit, TemperatureUnit toUnit) throws Exception {
        switch (fromUnit) {
            case KELVIN: {
                switch (toUnit) {
                    case FAHRENHEIT:
                        return celsiusToFahrenheit(value + Units.CELSIUS_TO_KELVIN);
                    case CELSIUS:
                        return value + Units.CELSIUS_TO_KELVIN;
                    case KELVIN:
                        return value;
                }
            }
            case CELSIUS: {
                switch (toUnit) {
                    case FAHRENHEIT:
                        return celsiusToFahrenheit(value);
                    case CELSIUS:
                        return value;
                    case KELVIN:
                        return value - Units.CELSIUS_TO_KELVIN;
                }
            }
            case FAHRENHEIT: {
                switch (toUnit) {
                    case FAHRENHEIT:
                        return value;
                    case CELSIUS:
                        return fahrenheitToCelsius(value);
                    case KELVIN:
                        return fahrenheitToCelsius(value) - Units.CELSIUS_TO_KELVIN;
                }
            }
        }

        throw new Exception("sjofdah");
    }

    @GetMapping("/convertMass")
    public Double convertMass(Double value, MassUnit fromUnit, MassUnit toUnit) {
        return value * Units.getMassUnits().get(fromUnit) / Units.getMassUnits().get(toUnit);
    }

    @GetMapping("/availableMassUnits")
    public List<String> getAvailableMassUnits() {
        List<String> vals = new ArrayList<>();
        for (MassUnit m : MassUnit.values()) {
            vals.add(m.name());
        }
        return vals;
    }

    @GetMapping("/availableTemperatureUnits")
    public List<String> getAvailableTemperatureUnits() {
        List<String> vals = new ArrayList<>();
        for (TemperatureUnit m : TemperatureUnit.values()) {
            vals.add(m.name());
        }
        return vals;
    }

    @GetMapping("/availableDistanceUnits")
    public List<String> getAvailableDistanceUnit() {
        List<String> vals = new ArrayList<>();
        for (DistanceUnit m : DistanceUnit.values()) {
            vals.add(m.name());
        }
        return vals;
    }

    private double celsiusToFahrenheit(double c) {
        return c * 9d / 5d + 32;
    }

    private double fahrenheitToCelsius(double f) {
        return (f - 32) * 5d / 9d;
    }



}
