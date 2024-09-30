package com.example.testproject.controller;

import com.example.testproject.dto.MemberDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    @PutMapping(value = "/default")
    public String putMethod() {
        return "Hello World";
    }

    @PutMapping(value = "/member")
    public String putMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        postData.forEach((key, value) -> {
            sb.append(String.format("%s : %s%n", key, value));
        });

        return sb.toString();
    }

    @PutMapping(value = "/member1")
    public String putMemberDto1(@RequestBody MemberDTO memberDTO) {
        return memberDTO.toString();
    }

    @PutMapping(value = "/member2")
    public String putMemberDto2(@RequestBody MemberDTO memberDTO) {
        return memberDTO.toString();
    }

    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDTO> postMemberDto3(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDTO);
    }

}
