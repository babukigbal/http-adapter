package com.orchestrator.httpadapter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorizeResponse {
    String responseCode;
    String responseMessage;

}
