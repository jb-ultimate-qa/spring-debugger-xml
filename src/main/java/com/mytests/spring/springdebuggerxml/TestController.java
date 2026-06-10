package com.mytests.spring.springdebuggerxml;

import com.mytests.spring.springdebuggerxml.beans.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/")
public class TestController {

 // normal bean from main config:
    @Autowired
    private Bean1 bean1;

    // prototype:
    @Autowired
    private Bean2 bean2;

    // primary:
    @Autowired
    private Bean3 bean3;

    // lazy==true
    @Autowired
    private Bean4 bean4;

    // lazy==default (true)
    @Autowired
    private Bean5 bean5;

    // abstract: not clickable inlay;
    // actual (non-abstract inherited bean) `mainConfigChidBean61` is not resolved
    @Autowired
    private Bean6 bean6;

    // normal bean from imported config
    @Autowired
    private Bean7 bean7;

    // autowire-candidate: alternative (autowire-candidate=true) from imported config
    @Autowired
    private Bean8 bean8;

    // init-destroy:
    @Autowired
    private Bean9 bean9;

    // static method factory
    @Autowired
    private Bean10 bean10;

    // instantiated by factory bean + factory instance method: no inlay
    @Autowired
    private Bean11 bean11;

    // qualifiers:
    @Qualifier("qualifier1")
    @Autowired
    private Bean12 bean12_1;

    @Qualifier("qualifier2")
    @Autowired
    private Bean12 bean12_2;

    // few `qualifier` elements: not resolved
    @Qualifier("qualifier5")
    @Autowired
    private Bean12 bean12_3;

    @MyQualifier1
    @Autowired
    private Bean12 bean12_4;

    @MyQualifier2("customQualifier2")
    @Autowired
    private Bean12 bean12_5;

    // not resolved, no inlay in non-suspended mode
    @MyQualifier3(attr1 = "customQualifier3Attr1", attr2 = "customQualifier3Attr2")
    @Autowired
    private Bean12 bean12_6;


    // normal bean from imported config
    // has `qualifier` element
    // inlay shows it as `@Qualifier`
    @Autowired
    private Bean13 bean13;

    // depends-on:
    @Autowired
    private Bean14 bean14;

    // lazy==false
    @Autowired
    private Bean15 lazyConfigDefaultBean15;



    @GetMapping("/")
    public String test() {
        return "test";
    }
}
