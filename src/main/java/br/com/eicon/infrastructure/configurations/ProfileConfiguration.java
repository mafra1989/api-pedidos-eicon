package br.com.eicon.infrastructure.configurations;

import lombok.Getter;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Component
@PropertySource(ignoreResourceNotFound = true, value = "classpath:profile.${ambiente}.properties")
public class ProfileConfiguration {

}
