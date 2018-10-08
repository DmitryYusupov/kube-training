package ru.yusdm.kubetraining.country.common.configs

import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class WebConfigs(val yamlConfigs: YamlConfigs) {

    @Bean
    @LoadBalanced
    //We create a Ribbon backed RestTemplate

    //In case of Kubernetes it is overhead because we have one instance of service with its logical name
    //So it is sufficient only to obtain service host and port and we can call service using new RestTemplate(),
    //and later, service itself will provide  load balancing
    fun getLoadBalancedRestTemplate(): RestTemplate = RestTemplate()

    fun getCityServiceHttpUrl() = with(yamlConfigs) {
        "http://$cityServiceDnsName:$cityServicePort"
    }

    //Use it LoadBalanced RestTemplate
    fun getCityServiceRibbonHttpUrl() = "http://citysrvfeign"

    //Simple call in new RestTemplate()
    //Because URL is DNS url
    fun getAmbassadorHttpUrl() = with(yamlConfigs) {
        "http://$ambassadorServiceDnsName:$ambassadorServicePort"
    }

    //Use it LoadBalanced RestTemplate
    fun getAmbassadorRibbonHttpUrl() = "http://ambassadorfeign"

}