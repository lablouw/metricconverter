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

    //Todo: other tests
}