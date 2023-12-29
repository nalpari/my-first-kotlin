package net.devgrr.myfirstkotlin.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig() : WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedOrigins("*")
//            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowedMethods("*")
            .maxAge(3600)
    }
}