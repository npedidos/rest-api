package red.softn.npedidos.utils.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GsonConfigTest {
    
    private Gson gson;
    
    private static GsonConfigTestUtil gsonConfigTestUtil;
    
    @BeforeAll
    static void beforeAll() {
        gsonConfigTestUtil = new GsonConfigTestUtil();
    }
    
    @BeforeEach
    void setUp() {
        this.gson = new GsonConfig().gson(new GsonBuilder());
    }
    
    @Test
    void testSerializeLocalDateTime() {
        var localDateTime = gsonConfigTestUtil.getLocalDateTime();
        var expected = gsonConfigTestUtil.getLocalDateTimeJson();
        var actual = this.gson.toJson(localDateTime);
        
        assertEquals(expected, actual);
    }
    
    @Test
    void testDeserializerLocalDateTime() {
        final var localDateTimeJson = gsonConfigTestUtil.getLocalDateTimeJson();
        final var expected = gsonConfigTestUtil.getLocalDateTime();
        final var actual = this.gson.fromJson(localDateTimeJson, LocalDateTime.class);
        
        assertEquals(expected, actual);
    }
    
}
