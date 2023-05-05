package pw.ersms.emergencies.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import pw.ersms.emergencies.emergency.Emergency;

import java.util.Map;

public class EmergencySerializer implements Serializer<Emergency> {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    public byte[] serialize(java.lang.String topic, pw.ersms.emergencies.emergency.Emergency data) {
        try {
            if (data == null){
                System.out.println("Null received at serializing");
                return null;
            }
            System.out.println("Serializing...");
            return objectMapper.writeValueAsBytes(data);
        } catch (Exception e) {
            throw new SerializationException("Error when serializing MessageDto to byte[]");
        }
    }

    public void close() {
    }

}
