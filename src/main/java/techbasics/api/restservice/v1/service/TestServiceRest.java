package techbasics.api.restservice.v1.service;

import techbasics.api.restservice.v1.model.Request1;
import techbasics.api.restservice.v1.model.Request2;
import techbasics.api.restservice.v1.model.Response1;
import techbasics.api.restservice.v1.model.Response2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/testRestService/v1")
public interface TestServiceRest {

    @GetMapping(value = "/testGet1", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Response1> testGet1(@RequestBody Request1 apiRequest1);

    @GetMapping(value = "/testGet2", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Response2> testGet2(@RequestBody Request2 apiRequest2);
}

