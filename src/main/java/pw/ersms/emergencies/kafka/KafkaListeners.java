package pw.ersms.emergencies.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pw.ersms.emergencies.answer.Answer;
import pw.ersms.emergencies.emergency.Emergency;

@Component
public class KafkaListeners {
    @KafkaListener(topics = "emergencies", groupId = "groupId")
    void listener(String data) {
        System.out.println("Listener received: " + data.toString() + " ");
    }

}
