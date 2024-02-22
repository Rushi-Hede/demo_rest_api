package com.example.demo.openapiconfig;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = " Employee API",
                description = "Crud Operation",
                contact = @Contact(
                        name = " Developer name",
                        email = " help@xyz.com"
                ),
                license =  @License(
                        name = " Your license no"
                )
        ),
        servers =
                {
                        @Server(
                                description = " Dev",
                                url = " http://localhost:6565"
                        ),
                        @Server(
                                description = " Test",
                                url = " http://localhost:6565"
                        )
                }
)
public class openapiconfig {

}
