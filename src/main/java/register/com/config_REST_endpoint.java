package register.com;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/webapi")
public class config_REST_endpoint extends ResourceConfig {

    public config_REST_endpoint() {
        packages("register.com");

    }
}