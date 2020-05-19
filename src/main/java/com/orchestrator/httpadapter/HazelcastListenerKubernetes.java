package com.orchestrator.httpadapter;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.spi.properties.ClientProperty;
import com.hazelcast.config.Config;
import com.hazelcast.config.GroupConfig;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.HazelcastInstance;

@Configuration
public class HazelcastListenerKubernetes {

	@Bean
	public ClientConfig hazelCastConfig() {
		System.out.println("Inside openshift profile Hazelcast Listener- Updated ClientConfig");
//
//		Config config = new Config();
//		config.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(false);
//		config.getNetworkConfig().getJoin().getKubernetesConfig().setEnabled(true)
//		      .setProperty("namespace", "orch-project")
//		      .setProperty("service-name", "hzport");
		
		ClientConfig config = new ClientConfig();
        config.setGroupConfig(new GroupConfig("Orch", "8e4a897a4ee74e06a412ffa9e6601a9e"));
        config.setProperty("hazelcast.client.statistics.enabled", "true");
        config.setProperty(ClientProperty.HAZELCAST_CLOUD_DISCOVERY_TOKEN.getName(), "po5UbdkRpb7b9I0IH8aqmYvifgEysdkxwULqRJwUMp07IH6MeF");
		return config;
	}
//	@Bean
//	public Config hazelCastConfig1() {
//		System.out.println("Inside openshift profile Hazelcast Listener- Updated Config");
////
////		Config config = new Config();
////		config.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(false);
////		config.getNetworkConfig().getJoin().getKubernetesConfig().setEnabled(true)
////		      .setProperty("namespace", "orch-project")
////		      .setProperty("service-name", "hzport");
//		
//		Config config = new Config();
//        config.setGroupConfig(new GroupConfig("Orch", "8e4a897a4ee74e06a412ffa9e6601a9e"));
//        config.setProperty("hazelcast.client.statistics.enabled", "true");
//        config.setProperty(ClientProperty.HAZELCAST_CLOUD_DISCOVERY_TOKEN.getName(), "po5UbdkRpb7b9I0IH8aqmYvifgEysdkxwULqRJwUMp07IH6MeF");
//		return config;
//	}
//	
	@Bean
	public HazelcastInstance hazelcastInstance(ClientConfig clientconfig) {
		System.out.println("Inside hazelcastInstance bean creation");
		return  HazelcastClient.newHazelcastClient(clientconfig);

	}
	
}
