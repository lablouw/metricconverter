package metricconverter.controller;

import lombok.extern.slf4j.Slf4j;
import metricconverter.domain.DomainRequest1;
import metricconverter.domain.DomainRequest2;
import metricconverter.domain.DomainResponse1;
import metricconverter.domain.DomainResponse2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testService")
@Slf4j
public class TestService {

	@GetMapping(value = "/testGet1", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DomainResponse1> testGet1(@RequestBody DomainRequest1 domainRequest1) {
		DomainResponse1 domainResponse1 = new DomainResponse1(domainRequest1.getRequestString1(), domainRequest1.getRequestInt1());

		return constructOkResponse(domainResponse1);
	}

	@GetMapping(value = "/testGet2", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DomainResponse2> testGet2(@RequestBody DomainRequest2 domainRequest2) {
		DomainResponse2 domainResponse2 = new DomainResponse2(domainRequest2.getRequestString2(), domainRequest2.getRequestInt2());

		return constructOkResponse(domainResponse2);
	}

	private ResponseEntity constructOkResponse(Object response) {
		return ResponseEntity.ok(response);
	}

}

