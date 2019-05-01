package metricconverter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Units {

    private static final Map<DistanceUnit, Double> distanceUnits;
    private static final Map<MassUnit, Double> massUnits;
    public static final double CELSIUS_TO_KELVIN = -273.15;

    static {
        Map<DistanceUnit, Double> du = new HashMap<>();
        du.put(DistanceUnit.METRE, 1d);
        du.put(DistanceUnit.MILLIMETRE, 0.001d);
        du.put(DistanceUnit.INCHE, 0.0254d);
        du.put(DistanceUnit.FOOT, 0.3048d);
        du.put(DistanceUnit.YARD, 0.9144d);
        distanceUnits = Collections.unmodifiableMap(du);

        Map<MassUnit, Double> mu = new HashMap<>();
        mu.put(MassUnit.KILOGRAM, 1d);
        mu.put(MassUnit.GRAM, 0.001d);
        mu.put(MassUnit.POUND, 0.4535929);
        mu.put(MassUnit.OUNCE, 0.0283495);
        mu.put(MassUnit.STONE, 6.35029);
        massUnits = Collections.unmodifiableMap(mu);

    }

    public static Map<DistanceUnit, Double> getDistanceUnits() {
        return distanceUnits;
    }

    public static Map<MassUnit, Double> getMassUnits() {
        return massUnits;
    }

}
