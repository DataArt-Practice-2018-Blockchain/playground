package sendmsg.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:rest-input")
                .to("direct:sout");

        from("direct:sout")
                .to("stream:out");
    }
}
