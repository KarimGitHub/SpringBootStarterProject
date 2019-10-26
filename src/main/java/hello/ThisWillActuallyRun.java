package hello;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ThisWillActuallyRun {

	// http://localhost:8080/runTestCase - POST Call Pass Header
	@RequestMapping("/runTestCase")

	ResponseEntity<String> invokeMyTest(@RequestHeader Map<String, String> headers) {

		// Print the headers what you are passing , it has default header values
		headers.forEach((key, value) -> {
			System.out.println(String.format("Header '%s' = %s", key, value));
		});

		System.out.println(" Print Test Case Name :" + headers.get("name"));

		System.out.println(" Print Test Case Name :" + headers.get("testcase_name"));

		String testName = headers.get("testcase_name");

		return new ResponseEntity<String>(String.format("Listed %d headers", headers.size()), HttpStatus.OK);
	}

	// GET Call pass query as input

	// http://localhost:8080/runTestCaseQuery?testName=bita

	@RequestMapping("/runTestCaseQuery")

	String invokeMyTest(@RequestParam(required = false) String testName) {

		// Print the headers what you are passing , it has default header values

		System.out.println(" Print Test Case Name :" + testName);

		return "API Run for testcase :" + testName;
	}

}
