package red.softn.npedidos.utils.gson;

import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class GsonConfigTest {
    
    GsonConfig sut;
    
    static class TestConverter {
        LocalDateTime timer;
        
        public LocalDateTime getTimer() {
            return this.timer;
        }
    }
    
    @BeforeEach
    void setUp() {
        sut = new GsonConfig();
    }
    
    @Test
    void shouldRegisterLocalDateTimeAdapter() {
        final var builder = new GsonBuilder();
        final var gson = sut.gson(builder);
        final var time  = LocalDateTime.of(2022, 3, 1, 10, 10, 19).toString();
        
        final var result = gson.fromJson("{\"timer\" : \"2022-03-01T10:10:19\"}", TestConverter.class);
        
        assertThat(result.getTimer()).isEqualTo(time);
    }
    
}
