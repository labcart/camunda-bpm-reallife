package camunda.order.service.controller;

import camunda.event.bus.connector.contracts.CamundaMessageStartEvent;
import camunda.event.bus.connector.contracts.ImmutableCamundaMessageStartEvent;
import camunda.order.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderApiService {

    @Autowired
    private Sink sink;

    @PostMapping("/create")
    public String create(Order order) {
        MessageBuilder<CamundaMessageStartEvent> payload = MessageBuilder.withPayload(ImmutableCamundaMessageStartEvent
                .builder()
                .build());
        sink.input().send(payload.build());
        return "Ok";
    }


    @GetMapping("/health")
    public String health() {
        return "alive";
    }

}
