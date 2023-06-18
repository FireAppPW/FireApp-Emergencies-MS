package pw.ersms.emergencies.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class EmergencyWebSocketController {

    @MessageMapping("/newEmergency") // Handles messages sent to /app/newEmergency
    @SendTo("/topic/emergency") // Broadcasts the message to all subscribers of /topic/emergency
    public String handleNewEmergency(String message) {
        // Process the new emergency and send a notification to all subscribers
        return "New emergency created: " + message;
    }
}
