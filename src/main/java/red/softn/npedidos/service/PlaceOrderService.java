package red.softn.npedidos.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import red.softn.npedidos.entity.FoodDish;
import red.softn.npedidos.entity.Menu;
import red.softn.npedidos.entity.TypeDish;
import red.softn.npedidos.exception.NotFoundException;
import red.softn.npedidos.repository.MenuRepository;
import red.softn.npedidos.repository.projection.PreviousAndNextMenuDTO;
import red.softn.npedidos.response.placeorder.PlaceOrderResponse;
import red.softn.npedidos.utils.message.MessageUtil;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaceOrderService {
    
    private final MenuRepository menuRepository;
    
    private final MessageUtil messageUtil;
    
    public PlaceOrderResponse placeOrder(Integer menuId) {
        var menuEntity = getMenuEntity(menuId);
        var menuDate = menuEntity.getDate();
        var fistLocalDateOfWeek = menuDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        var lastLocalDateOfWeek = menuDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        var previousAndNextDate = getPreviousAndNextDateMenuDTO(menuId, fistLocalDateOfWeek, lastLocalDateOfWeek);
        var previousAndNextWeek = getPreviousAndNextWeekMenuDTO(fistLocalDateOfWeek, lastLocalDateOfWeek);
        int weekOfYear = getWeekOfYear(menuDate);
        var typeDishes = getTypeDishes(menuEntity);
        Integer nexMenuId = previousAndNextDate.getNextMenuId();
        Integer previousMenuId = previousAndNextDate.getPreviousMenuId();
        Integer nextWeekMenuId = previousAndNextWeek.getNextMenuId();
        Integer previousWeekMenuId = previousAndNextWeek.getPreviousMenuId();
        var menu = new PlaceOrderResponse.Menu(menuDate, nexMenuId, previousMenuId);
        var menuWeek = new PlaceOrderResponse.MenuWeek(weekOfYear, fistLocalDateOfWeek.getDayOfMonth(), lastLocalDateOfWeek.getDayOfMonth(), nextWeekMenuId, previousWeekMenuId);
        
        return new PlaceOrderResponse(menu, menuWeek, typeDishes);
    }
    
    private PreviousAndNextMenuDTO getPreviousAndNextWeekMenuDTO(LocalDate fistLocalDateOfWeek, LocalDate lastLocalDateOfWeek) {
        Optional<PreviousAndNextMenuDTO> previousAndNextWeek = this.menuRepository.findPreviousAndNextWeek(fistLocalDateOfWeek, lastLocalDateOfWeek);
        
        if (previousAndNextWeek.isPresent()) {
            return previousAndNextWeek.get();
        }
        
        throw new NotFoundException(this.messageUtil.getMessage("error.previousAndNextWeek.notFound"));
    }
    
    private PreviousAndNextMenuDTO getPreviousAndNextDateMenuDTO(Integer menuId, LocalDate fistLocalDateOfWeek, LocalDate lastLocalDateOfWeek) {
        var localDateOfWeekDtoOptional = this.menuRepository.findPreviousAndNextDate(menuId, fistLocalDateOfWeek, lastLocalDateOfWeek);
        
        if (localDateOfWeekDtoOptional.isPresent()) {
            return localDateOfWeekDtoOptional.get();
        }
        
        throw new NotFoundException(this.messageUtil.getMessage("error.record-not-exist"));
    }
    
    private Menu getMenuEntity(Integer menuId) {
        var menuEntityOption = this.menuRepository.findById(menuId);
        
        if (menuEntityOption.isPresent()) {
            return menuEntityOption.get();
        }
        
        throw new NotFoundException(this.messageUtil.getMessage("error.record-not-exist"));
    }
    
    private List<PlaceOrderResponse.TypeDish> getTypeDishes(Menu menuEntity) {
        var mapping = Collectors.mapping(this::foodDishToFoodDishPlaceOrder, Collectors.toList());
        
        return menuEntity.getFoodDishes()
                         .stream()
                         .filter(value -> Objects.nonNull(value.getTypeDish()))
                         .collect(Collectors.groupingBy(FoodDish::getTypeDish, mapping))
                         .entrySet()
                         .stream()
                         .map(this::getTypeDishPlaceOrder)
                         .toList();
    }
    
    private int getWeekOfYear(LocalDate localDate) {
        var weekFields = WeekFields.of(Locale.getDefault());
        
        return localDate.get(weekFields.weekOfYear());
    }
    
    private PlaceOrderResponse.TypeDish getTypeDishPlaceOrder(Map.Entry<TypeDish, List<PlaceOrderResponse.FoodDish>> value) {
        var typeDish = value.getKey();
        
        return new PlaceOrderResponse.TypeDish(typeDish.getId(), typeDish.getName(), value.getValue());
    }
    
    private PlaceOrderResponse.FoodDish foodDishToFoodDishPlaceOrder(FoodDish foodDishEntity) {
        return new PlaceOrderResponse.FoodDish(foodDishEntity.getId(), foodDishEntity.getName());
    }
    
}
