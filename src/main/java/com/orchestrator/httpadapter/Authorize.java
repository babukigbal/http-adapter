package com.orchestrator.httpadapter;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.core.IQueue;
import com.orchestrator.*;

import common.FinancialTransaction;
@RestController
public class Authorize {
	HazelcastInstance hazelcastInstance;
	
	Authorize(){
		this.hazelcastInstance=Hazelcast.newHazelcastInstance();
	}
	
    @GetMapping("/authorize")
    public AuthorizeResponse greeting() {
    	IMap<String, FinancialTransaction> transactionMap=this.hazelcastInstance.getMap("TransactionsMap");
    	FinancialTransaction financialTransaction=new FinancialTransaction();
    	financialTransaction.setAcqId("gdfgdf");
    	financialTransaction.setPrimaryNumber("5435345453");
    	   int leftLimit = 97; // letter 'a'
    	    int rightLimit = 122; // letter 'z'
    	    int targetStringLength = 10;
    	   Random random = new Random();
    	   
			String generatedString = random.ints(leftLimit, rightLimit + 1)
    	      .limit(targetStringLength)
    	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
    	      .toString();
    	transactionMap.put(generatedString, financialTransaction);
    	IQueue<String> transactionsQueue=this.hazelcastInstance.getQueue("TransactionsQueue");
    	transactionsQueue.add(generatedString);

    	System.out.println("greeting: " + financialTransaction.toString());
        return new AuthorizeResponse("S","Approved Transaction");
    }
}
