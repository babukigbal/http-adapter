package com.orchestrator.httpadapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizeResponse {
    String responseCode;
    String responseMessage;

}
