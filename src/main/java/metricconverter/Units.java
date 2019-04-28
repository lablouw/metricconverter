package metricconverter;

import java.util.HashMap;
import java.util.Map;

public class Units {

    private static final Map<DistanceUnit, Double> diatanceUnits = new HashMap<>();
    private static final Map<MassUnit, Double> massUnits = new HashMap<>();
    public static final double CELSIUS_TO_KELVIN = -273.15;

    static {
        diatanceUnits.put(DistanceUnit.METRE, 1d);
        diatanceUnits.put(DistanceUnit.MILLIMETRE, 0.001d);
        diatanceUnits.put(DistanceUnit.INCHE, 0.0254d);
        diatanceUnits.put(DistanceUnit.FOOT, 0.3048d);
        diatanceUnits.put(DistanceUnit.YARD, 0.9144d);

        massUnits.put(MassUnit.KILOGRAM, 1d);
        massUnits.put(MassUnit.GRAM, 0.001d);
        massUnits.put(MassUnit.POUND, 0.4535929);
        massUnits.put(MassUnit.OUNCE, 0.0283495);
        massUnits.put(MassUnit.STONE, 6.35029);
    }

    public static Map<DistanceUnit, Double> getDistanceUnits() {
        return diatanceUnits;
    }

    public static Map<MassUnit, Double> getMassUnits() {
        return massUnits;
    }

}
