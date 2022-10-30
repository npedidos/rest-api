package red.softn.npedidos;

import net.datafaker.Faker;
import org.springframework.core.ResolvableType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class TestUtil {
    
    public static final Faker faker;
    
    static {
        faker = new Faker();
    }
    
    public static Class<?> resolveGeneric(Class<?> clazz, int index) {
        return ResolvableType.forClass(clazz)
                             .getSuperType()
                             .resolveGeneric(index);
    }
    
    public static List<Integer> fakeRandomIntegerList() {
        return faker.collection(TestUtil::fakeRandomInteger)
                    .len(1, 100)
                    .generate();
    }
    
    public static Integer fakeRandomInteger() {
        return faker.random()
                    .nextInt(1, 1000);
    }
    
    public static LocalDateTime fakeDateFutureDaysTime() {
        return faker.date()
                    .future(fakeRandomInteger(), TimeUnit.DAYS)
                    .toLocalDateTime();
    }
    
    public static LocalDate fakeDateFutureDays() {
        return fakeDateFutureDaysTime().toLocalDate();
    }
    
    public static String fakeRandomWord() {
        return faker.lorem()
                    .word();
    }
    
    public static String fakeRandomEmail() {
        return faker.internet()
                    .emailAddress();
    }
    
    public static String fakeRandomPassword() {
        return faker.internet()
                    .password(60, 60);
    }
    
}
