package sendmsg.controller;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRestController {

    @Produce(uri = "direct:rest-input")
    ProducerTemplate producerTemplate;

    @RequestMapping("/sendmsg")
    public String processMessage(@RequestParam(value = "msg", defaultValue = " ") String msg) {
        producerTemplate.sendBody(msg);
        return "<h1>Thanks for your message</h1>\n";
    }
}
