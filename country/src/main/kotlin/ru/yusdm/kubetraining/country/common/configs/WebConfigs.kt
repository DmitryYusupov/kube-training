package ru.yusdm.kubetraining.country.common.configs

import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class WebConfigs(val yamlConfigs: YamlConfigs) {

    @Bean
    @LoadBalanced
    fun getLoadBalancedRestTemplate(): RestTemplate = RestTemplate()

    fun getCityServiceHttpUrl() = with(yamlConfigs) {
        "http://$cityServiceDnsName:$cityServicePort"
    }

    fun getAmbassadorHttpUrl() = with(yamlConfigs) {
        "http://$ambassadorServiceDnsName:$ambassadorServicePort"
    }

}