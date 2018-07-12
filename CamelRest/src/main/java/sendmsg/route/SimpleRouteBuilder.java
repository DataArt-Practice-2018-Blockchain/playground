package sendmsg.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:insertMsg")
                .to("mongodb:mongo?database=test&collection=msgs&operation=insert");

        from("direct:findMsgByQuery")
                .to("mongodb:mongo?database=test&collection=msgs&operation=findOneByQuery");
    }

}
