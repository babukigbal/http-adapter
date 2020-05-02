package com.orchestrator.httpadapter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Authorize {
    @GetMapping("/authorize")
    public AuthorizeResponse greeting() {
        return new AuthorizeResponse("S","Approved");
    }
}
