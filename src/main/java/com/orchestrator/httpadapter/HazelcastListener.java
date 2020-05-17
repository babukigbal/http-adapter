package com.orchestrator.httpadapter;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.NetworkConfig;

@Configuration
@Profile("laptop") 
public class HazelcastListener {

	@Bean
	public Config hazelCastConfig() {
		System.out.println("Inside Laptop profile Hazelcast Listener");
		Config config = new Config();
		NetworkConfig network = config.getNetworkConfig();
		network.setPort(5701).setPortCount(20);
		network.setPortAutoIncrement(true);
		JoinConfig join = network.getJoin();
		join.getMulticastConfig().setEnabled(false);
		config.setInstanceName("hazelcast-instance");
		return config;
	}
	
}
