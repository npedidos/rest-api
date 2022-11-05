package red.softn.npedidos.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import red.softn.npedidos.entity.FoodDish;
import red.softn.npedidos.entity.TypeDish;
import red.softn.npedidos.repository.FoodDishRepository;
import red.softn.npedidos.repository.TypeDishRepository;
import red.softn.npedidos.request.fooddish.FoodDishRequest;
import red.softn.npedidos.request.typedishes.TypeDishFoodDishesRequest;
import red.softn.npedidos.request.typedishes.TypeDishRequest;
import red.softn.npedidos.response.ContentResponse;
import red.softn.npedidos.response.FoodDishResponse;
import red.softn.npedidos.response.PagingAndSortingResponse;
import red.softn.npedidos.response.TypeDishResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
public class TypeDishService extends CrudService<TypeDishRequest, TypeDishResponse, TypeDish, Integer> {
    
    private final TypeDishRepository repository;
    
    private final FoodDishRepository foodDishRepository;
    
    public ContentResponse<FoodDishResponse> saveFoodDishes(Integer id, TypeDishFoodDishesRequest request) {
        var typeDish = getRepository().getReferenceById(id);
        var foodDishes = request.getFoodDishes()
                                .stream()
                                .map(value -> getFoodDish(typeDish, value))
                                .toList();
        
        List<FoodDish> saveAll = this.foodDishRepository.saveAll(foodDishes);
        List<FoodDishResponse> response = getGsonUtil().convertTo(saveAll, FoodDishResponse.class);
        
        return new ContentResponse<>(response);
    }
    
    public PagingAndSortingResponse<FoodDishResponse> findAllFoodDishes(Integer id) {
        Page<FoodDish> allByTypesDishesId = foodDishRepository.findAllByTypeDishId(id, getDataRequestScope().getPageable());
        
        return pageToResponse(allByTypesDishesId, FoodDishResponse.class);
    }
    
    private FoodDish getFoodDish(TypeDish typeDish, FoodDishRequest value) {
        FoodDish foodDish;
        
        if (value.getId() == null) {
            foodDish = getGsonUtil().convertTo(value, FoodDish.class);
        } else {
            foodDish = this.foodDishRepository.getReferenceById(value.getId());
        }
        
        foodDish.setTypeDish(typeDish);
        
        return foodDish;
    }
    
}
