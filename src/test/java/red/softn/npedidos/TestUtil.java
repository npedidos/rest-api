package red.softn.npedidos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.core.ResolvableType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public abstract class TestUtil {
    
    @Getter(value = AccessLevel.PROTECTED)
    private final Faker faker;
    
    public static Class<?> resolveGeneric(Class<?> clazz, int index) {
        return ResolvableType.forClass(clazz)
                             .getSuperType()
                             .resolveGeneric(index);
    }
    
    public Integer fakeRandomInteger() {
        return this.faker.random()
                         .nextInt(1, 1000);
    }
    
    public LocalDateTime fakeDateFutureDaysTime() {
        return this.faker.date()
                         .future(fakeRandomInteger(), TimeUnit.DAYS)
                         .toLocalDateTime();
    }
    
    public LocalDate fakeDateFutureDays() {
        return fakeDateFutureDaysTime().toLocalDate();
    }
    
    public String fakeRandomWord() {
        return this.faker.lorem()
                         .word();
    }
    
    public String fakeRandomEmail() {
        return this.faker.internet()
                         .emailAddress();
    }
    
    public String fakeRandomPassword() {
        return this.faker.internet()
                         .password(60, 60);
    }
    
}
