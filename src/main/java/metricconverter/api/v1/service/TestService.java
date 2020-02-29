package metricconverter.api.v1.service;

import metricconverter.api.v1.model.Request1;
import metricconverter.api.v1.model.Request2;
import metricconverter.api.v1.model.Response1;
import metricconverter.api.v1.model.Response2;
import org.springframework.http.ResponseEntity;

public interface TestService {

    ResponseEntity<Response1> testGet1(Request1 domainRequest1);

    ResponseEntity<Response2> testGet2(Request2 domainRequest2);

}

