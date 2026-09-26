package register.com;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application; // or javax.ws.rs.* for older JAX-RS versions

@ApplicationPath("webapi")
public class config_REST_endpoint extends Application {
    // Leave body empty
}

