package metricconverter;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.StringUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MetricConverterControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void test_index() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Converter!")));
    }

    @Test
    public void test_convertDistance() throws Exception {
        DistanceUnit base = DistanceUnit.METRES;
        for (DistanceUnit unit : DistanceUnit.values()) {
            String url = "/convertDistance?distance=1&fromUnit="+unit+"&toUnit="+base;
            System.out.println("Testing: "+url);
            mvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().string(equalTo(String.valueOf(Units.getDistanceUnits().get(unit)))));
        }
    }

    @Test
    public void test_convertMass() throws Exception {
        MassUnit base = MassUnit.KILOGRAM;
        for (MassUnit unit : MassUnit.values()) {
            String url = "/convertMass?mass=1&fromUnit="+unit+"&toUnit="+base;
            System.out.println("Testing: "+url);
            mvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().string(equalTo(String.valueOf(Units.getMassUnits().get(unit)))));
        }
    }

    @Test
    public void test_convertTemperature() throws Exception {
        double c = 0;
        double k = 273.15;
        double f = 32;

        String baseUrl = "/convertTemperature?temperature={temp}&fromUnit={from}&toUnit={to}";

        String url = baseUrl.replace("{temp}", String.valueOf(c))
                .replace("{from}", TemperatureUnit.CELSIUS.name())
                .replace("{to}", TemperatureUnit.FAHRENHEIT.name());
        mvc.perform(MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(String.valueOf(f))));

        url = baseUrl.replace("{temp}", String.valueOf(c))
                .replace("{from}", TemperatureUnit.CELSIUS.name())
                .replace("{to}", TemperatureUnit.KELVIN.name());
        mvc.perform(MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(String.valueOf(k))));

        url = baseUrl.replace("{temp}", String.valueOf(k))
                .replace("{from}", TemperatureUnit.KELVIN.name())
                .replace("{to}", TemperatureUnit.FAHRENHEIT.name());
        mvc.perform(MockMvcRequestBuilders.get(String.format(url, k, TemperatureUnit.KELVIN, TemperatureUnit.FAHRENHEIT))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(String.valueOf(f))));

    }

}