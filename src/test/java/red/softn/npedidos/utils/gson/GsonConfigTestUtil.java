package red.softn.npedidos.utils.gson;

import lombok.Getter;
import red.softn.npedidos.TestUtil;

import java.time.LocalDateTime;

@Getter
public class GsonConfigTestUtil extends TestUtil {
    
    private final LocalDateTime localDateTime;
    
    private final String localDateTimeJson;
    
    public GsonConfigTestUtil() {
        this.localDateTime = fakeDateFutureDaysTime();
        this.localDateTimeJson = String.format("\"%s\"", localDateTime.toString());
    }
    
}
