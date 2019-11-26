package com.darian.springbootweb.controller;

import com.darian.springbootweb.entity.Person;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

//@Controller
@RestController
public class HtmlRestController {

    //    @RequestMapping(value = {"/html/demo","/html/demo2"},method = RequestMethod.POST)
    @GetMapping("/html/demo3")
//    @ResponseBody
    public String htmlCode() {
        return "<html><body>hell<br/>world<hr/></body></html>"+"dd";
    }


    @GetMapping("/html/demo/{message}")
    public String htmlPathVariable(@PathVariable String message) {
        return "<html><body>hello<br/>world<hr/>" + message + "</body></html>";
    }

    @GetMapping("/html/demo/param")
    public String htmlRequestParam(@RequestParam(value = "p", required = false, defaultValue = "empty") String message,
                                   HttpServletRequest request,
                                   @RequestParam("age") Integer age) {
        String param2 = request.getParameter("param2");
        return "<html><body>RequestParam = " + message + "    param2=" + param2 + "</body></html>";
    }

    @GetMapping("/html/demo/header")
    public String htmlHeader(@RequestHeader("Accept") String acceptHeader,
                             @CookieValue String cookie) {
        return "<html><body>Accept = " + acceptHeader + "<br/> cookie" + cookie + " </body></html>";
    }

    @GetMapping("/html/demo/requestEntity")
    public RequestEntity htmlRequestEntity(RequestEntity<Person> personRequestEntity) {
        System.out.println(personRequestEntity);
        return personRequestEntity;
    }

    @GetMapping("/html/demo/responseEntity")
    public ResponseEntity htmlResponseEntity() {
//        return ResponseEntity.ok(new Person("darian"));

        HttpHeaders headers = new HttpHeaders();
        headers.put("myheaders", Arrays.asList("myheadersValue"));
        ResponseEntity<Person> responseEntity =
                new ResponseEntity(new Person("darian"), headers, HttpStatus.OK);
        return responseEntity;
    }
}
