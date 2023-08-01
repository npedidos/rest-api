package red.softn.npedidos.runner;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.datafaker.Faker;
import net.datafaker.providers.base.DateAndTime;
import net.datafaker.providers.base.Options;
import net.datafaker.providers.food.Food;
import net.datafaker.service.RandomService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import red.softn.npedidos.entity.*;
import red.softn.npedidos.repository.*;
import red.softn.npedidos.utils.message.MessageUtil;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@RequiredArgsConstructor
@Log4j2
public class DatabaseSeeder {
    
    private final Faker faker;
    
    private final FoodDishRepository foodDishRepository;
    
    private final OrderRepository orderRepository;
    
    private final SettingRepository settingRepository;
    
    private final TypeDishRepository typeDishRepository;
    
    private final UserRepository userRepository;
    
    private final MenuRepository menuRepository;
    
    private final PasswordEncoder passwordEncoder;
    
    private final MessageUtil messageUtil;
    
    public void db() {
        log.info(this.messageUtil.getMessage("factory-seeder.inserting-test-data"));
        userFactory(50);
        typeDishFactory(10);
        foodDishFactory(100);
        orderingFactory(50);
        settingFactory(10);
        menuFactory(10);
        relationshipFactory();
        log.info(this.messageUtil.getMessage("factory-seeder.process_finished"));
    }
    
    public void fresh() {
        log.info(this.messageUtil.getMessage("factory-seeder.deleting-all-data"));
        this.foodDishRepository.deleteAll();
        this.typeDishRepository.deleteAll();
        this.orderRepository.deleteAll();
        this.settingRepository.deleteAll();
        this.userRepository.deleteAll();
        this.menuRepository.deleteAll();
        log.info(this.messageUtil.getMessage("factory-seeder.process_finished"));
    }
    
    private void relationshipFactory() {
        log.info(this.messageUtil.getMessage("factory-seeder.inserting-table-relationships"));
        Iterable<Order> orderings = this.orderRepository.findAll();
        Iterable<FoodDish> foodDishes = this.foodDishRepository.findAll();
        List<Menu> menus = this.menuRepository.findAll();
        
        orderings.forEach(value -> {
            Set<FoodDish> foodDishList = StreamSupport.stream(foodDishes.spliterator(), false)
                                                      .limit(10)
                                                      .collect(Collectors.toSet());
            
            value.setFoodDishes(foodDishList);
            
            this.orderRepository.save(value);
        });
        
        menus.forEach(value -> {
            Set<FoodDish> foodDishList = StreamSupport.stream(foodDishes.spliterator(), false)
                                                      .limit(3)
                                                      .collect(Collectors.toSet());
            
            value.setFoodDishes(foodDishList);
            
            this.menuRepository.save(value);
        });
    }
    
    private void userFactory(int count) {
        log.info(this.messageUtil.getMessage("factory-seeder.inserting-x-records", "User"));
        run(count, () -> {
            User user = new User();
            String username = this.faker.name()
                                        .username();
            
            user.setEmail(this.faker.internet()
                                    .emailAddress());
            user.setUsername(username);
            user.setPassword(this.passwordEncoder.encode(username));
            
            this.userRepository.save(user);
        });
    }
    
    private void typeDishFactory(int count) {
        log.info(this.messageUtil.getMessage("factory-seeder.inserting-x-records", "TypeDish"));
        run(count, () -> {
            TypeDish typeDish = new TypeDish();
            typeDish.setName(this.faker.funnyName()
                                       .name());
            
            this.typeDishRepository.save(typeDish);
        });
    }
    
    private void settingFactory(int count) {
        log.info(this.messageUtil.getMessage("factory-seeder.inserting-x-records", "Setting"));
        run(count, () -> {
            Setting setting = new Setting();
            setting.setKeyName(this.faker.letterify("???_???_???"));
            setting.setValue(this.faker.lorem()
                                       .paragraph());
            setting.setDescription(this.faker.lorem()
                                             .sentence(2));
            
            this.settingRepository.save(setting);
        });
    }
    
    private void menuFactory(int count) {
        log.info(this.messageUtil.getMessage("factory-seeder.inserting-x-records", "Menu"));
        DateAndTime date = this.faker.date();
        RandomService random = this.faker.random();
        
        run(count, () -> {
            Menu menu = new Menu();
            
            menu.setDate(date.future(random.nextInt(1, 100), TimeUnit.DAYS)
                             .toLocalDateTime()
                             .toLocalDate());
            
            this.menuRepository.save(menu);
        });
    }
    
    private void orderingFactory(int count) {
        log.info(this.messageUtil.getMessage("factory-seeder.inserting-x-records", "Order"));
        DateAndTime date = this.faker.date();
        RandomService random = this.faker.random();
        Iterable<User> all = this.userRepository.findAll();
        List<User> userList = StreamSupport.stream(all.spliterator(), false)
                                           .toList();
        Options options = this.faker.options();
        
        run(count, () -> {
            Order order = new Order();
            LocalDateTime localDateTime = date.future(random.nextInt(1, 100), TimeUnit.DAYS)
                                              .toLocalDateTime();
            
            order.setDateOrder(localDateTime);
            order.setUser(options.nextElement(userList));
            
            this.orderRepository.save(order);
        });
    }
    
    private void foodDishFactory(int count) {
        log.info(this.messageUtil.getMessage("factory-seeder.inserting-x-records", "FoodDish"));
        var all = this.typeDishRepository.findAll();
        var typeDishList = all.stream()
                              .toList();
        Options options = this.faker.options();
        Food food = this.faker.food();
        
        run(count, () -> {
            FoodDish foodDish = new FoodDish();
            
            foodDish.setTypeDish(options.nextElement(typeDishList));
            foodDish.setName(food.dish());
            
            this.foodDishRepository.save(foodDish);
        });
    }
    
    private void run(int count, Runnable runnable) {
        for (int i = 0; i < count; i++) {
            runnable.run();
        }
    }
    
}
