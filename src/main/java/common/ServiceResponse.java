package common;

import lombok.Data;

@Data
public class ServiceResponse {
	String serviceName;
	String decisionCode1;
	String decision1Description;
	String subDecisionCode;
	String subDecision1Description;
}
