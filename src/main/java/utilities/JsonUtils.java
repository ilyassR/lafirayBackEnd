package utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public final class JsonUtils {
    public static String toJson(Object objects) throws JsonProcessingException {
        String jsonString = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            jsonString = mapper.writeValueAsString(objects);
        } catch (JsonProcessingException jsonProcessingException) {
            log.error(jsonProcessingException.getMessage());
            jsonProcessingException.printStackTrace();
        }
        return jsonString;
    }
}
