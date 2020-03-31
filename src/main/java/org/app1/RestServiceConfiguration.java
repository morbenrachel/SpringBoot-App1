package org.app1;

import org.app2.UserDataServiceConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({UserDataServiceConfiguration.class})
public class RestServiceConfiguration {
}
