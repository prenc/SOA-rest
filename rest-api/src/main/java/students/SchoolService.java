package students;

import io.swagger.jaxrs.config.BeanConfig;
import students.api.StudentResource;
import students.auth.JWTTokenNeededFilter;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class SchoolService extends Application {
    public SchoolService() {
        init();
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<>();
        s.add(StudentResource.class);
        s.add(JWTTokenNeededFilter.class);

        s.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        s.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        return s;
    }

    private void init() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/rest-api");

        beanConfig.setResourcePackage("soap");
        beanConfig.setTitle("Swagger docs - school project");
        beanConfig.setScan(true);
    }
}
