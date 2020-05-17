package com.orchestrator.httpadapter;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.NetworkConfig;

@Configuration
public class HazelcastListener {

	@Bean
	public Config hazelCastConfig() {
		Config config = new Config();
		NetworkConfig network = config.getNetworkConfig();
		network.setPort(5701).setPortCount(20);
		network.setPortAutoIncrement(true);
		JoinConfig join = network.getJoin();
		join.getMulticastConfig().setEnabled(false);
//	    join.getKubernetesConfig().setEnabled(true);
		config.setInstanceName("hazelcast-instance");
		return config;
	}
	
}
