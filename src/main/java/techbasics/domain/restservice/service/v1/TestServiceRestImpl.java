package techbasics.domain.restservice.service.v1;

import lombok.extern.slf4j.Slf4j;
import techbasics.api.restservice.v1.model.Request1;
import techbasics.api.restservice.v1.model.Request2;
import techbasics.api.restservice.v1.model.Response1;
import techbasics.api.restservice.v1.model.Response2;
import techbasics.api.restservice.v1.service.TestServiceRest;
import techbasics.mapper.Request1Mapper;
import techbasics.mapper.Request2Mapper;
import techbasics.mapper.Response1Mapper;
import techbasics.mapper.Response2Mapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testRestService/v1")
@Slf4j
public class TestServiceRestImpl implements TestServiceRest {

    @PostMapping(value = "/testPost1", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response1> testGet1(@RequestBody Request1 apiRequest1) {
        techbasics.domain.model.Request1 domainRequest1 = Request1Mapper.INSTANCE.toDomain(apiRequest1);

        techbasics.domain.model.Response1 domainResponse1 = new techbasics.domain.model.Response1(domainRequest1.getRequestString1() + domainRequest1.getRequestString1(), domainRequest1.getRequestInt1() * 2);

        Response1 apiResponse1 = Response1Mapper.INSTANCE.toApi(domainResponse1);
        return ResponseEntity.ok(apiResponse1);
    }

    @PostMapping(value = "/testPost2", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response2> testGet2(@RequestBody Request2 apiRequest2) {
        techbasics.domain.model.Request2 domainRequest2 = Request2Mapper.INSTANCE.toDomain(apiRequest2);

        techbasics.domain.model.Response2 domainResponse2 = new techbasics.domain.model.Response2(domainRequest2.getRequestString2() + domainRequest2.getRequestString2(), domainRequest2.getRequestInt2() * 2);

        Response2 apiResponse2 = Response2Mapper.INSTANCE.toApi(domainResponse2);
        return ResponseEntity.ok(apiResponse2);
    }


}

