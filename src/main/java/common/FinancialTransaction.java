package common;

import java.io.Serializable;

import com.hazelcast.core.IMap;

import lombok.Data;
import com.google.common.collect.HashMultimap;

@Data
public class FinancialTransaction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String channelId;
	String messageType;
	String workflow;
	String primaryNumber;
	String acqId;
	HashMultimap<String,ServiceResponse> serviceResponseValues;

}
