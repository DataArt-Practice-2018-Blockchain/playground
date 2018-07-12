package sendmsg.controller;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
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
    public String sendMessage(@RequestParam(value = "msg", defaultValue = " ") String msg) {
        DBObject messageObject = BasicDBObjectBuilder.start().add("msg", msg).get();
        producerTemplate.sendBody("direct:insertMsg", messageObject);
        return "<h1>Thanks for your message</h1>\n";
    }

    @RequestMapping("/checkmsg")
    public String checkMessage(@RequestParam(value = "msg", defaultValue = " ") String msg) {
        DBObject messageObject = BasicDBObjectBuilder.start().add("msg", msg).get();
        DBObject result = (DBObject) producerTemplate.requestBody("direct:findMsgByQuery", messageObject);
        if (result != null)
            return "<h1>Message found!</h1>\n";
        else
            return "<h1>Message not found!</h1>\n";
    }
}
