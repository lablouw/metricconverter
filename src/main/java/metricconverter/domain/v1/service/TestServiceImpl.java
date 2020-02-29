package metricconverter.domain.v1.service;

import lombok.extern.slf4j.Slf4j;
import metricconverter.api.v1.model.Request1;
import metricconverter.api.v1.model.Request2;
import metricconverter.api.v1.model.Response1;
import metricconverter.api.v1.model.Response2;
import metricconverter.api.v1.service.TestService;
import metricconverter.mapper.Request1Mapper;
import metricconverter.mapper.Request2Mapper;
import metricconverter.mapper.Response1Mapper;
import metricconverter.mapper.Response2Mapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testService")
@Slf4j
public class TestServiceImpl implements TestService {

    @GetMapping(value = "/testGet1", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response1> testGet1(@RequestBody Request1 apiRequest1) {
        metricconverter.domain.model.Request1 domainRequest1 = Request1Mapper.INSTANCE.toDomain(apiRequest1);

        metricconverter.domain.model.Response1 domainResponse1 = new metricconverter.domain.model.Response1(domainRequest1.getRequestString1(), domainRequest1.getRequestInt1());

        Response1 apiResponse1 = Response1Mapper.INSTANCE.toApi(domainResponse1);
        return ResponseEntity.ok(apiResponse1);
    }

    @GetMapping(value = "/testGet2", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response2> testGet2(@RequestBody Request2 apiRequest2) {
        metricconverter.domain.model.Request2 domainRequest2 = Request2Mapper.INSTANCE.toDomain(apiRequest2);

        metricconverter.domain.model.Response2 domainResponse2 = new metricconverter.domain.model.Response2(domainRequest2.getRequestString2(), domainRequest2.getRequestInt2());

        Response2 apiResponse2 = Response2Mapper.INSTANCE.toApi(domainResponse2);
        return ResponseEntity.ok(apiResponse2);
    }


}

