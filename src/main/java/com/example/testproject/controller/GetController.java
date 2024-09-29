package com.example.testproject.controller;

import com.example.testproject.dto.MemberDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//Rest API 사용을 위함
@RestController
// 공통된 URL
@RequestMapping("/api/v1/get-api")

public class GetController {

    // http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello(){
        return "Hello World";
    }

    // http://localhost:8080/api/v1/get-api/name
    @GetMapping(value = "/name")
    public String getName(){
        return "Flature";
    }

    // http://localhost:8080/api/v1/get-api/variable1/{variable}
    // String 값으로 받은 값을 그대로 반환
    // variable 이름이 같아야한다.
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        return variable;
    }

    // http://localhost:8080/api/v1/get-api/variable2/dbswlsghkd2
    // String 값으로 받은 값을 그대로
    @GetMapping(value = "/variable2/{variable}")
    // 명칭이 다를 때 사용하는 방법
    public String getVariable2(@PathVariable("variable") String var){
        return var;
    }

    // http://localhost:8080/api/v1/get-api/request1?name=flature&organization=dbswlsghkd&email=dbswlsghkd@gmail.com
    @GetMapping(value = "/request1")
    public String getRequestParam1(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam String organization){
    return name + " " + email + " " + organization;
    }

    // http://localhost:8080/api/v1/get-api/request2?name=flature&organization=dbswlsghkd&email=dbswlsghkd@gmail.com
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> params){
        StringBuilder sb = new StringBuilder();

        params.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }
    // http://localhost:8080/api/v1/get-api/request3?name=flature&organization=dbswlsghkd&email=dbswlsghkd@gmail.com
    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDTO memberDTO){
        return memberDTO.toString();
    }
}
