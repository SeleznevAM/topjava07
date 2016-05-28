package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

/**
 * GKislin
 * 31.05.2015.
 */
public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,11,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,9,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );
        getFilteredMealsWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000);
//        .toLocalDate();
//        .toLocalTime();
    }

    public static List<UserMealWithExceed>  getFilteredMealsWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // TODO return filtered list with correctly exceeded field
        Map<LocalDate, Integer> map = new HashMap<>();
        List <UserMealWithExceed> userMealWithExceeds = new ArrayList<>();
        for (UserMeal meal : mealList){
            if(!map.containsKey(meal.getDateTime().toLocalDate())){
                map.put(meal.getDateTime().toLocalDate(), meal.getCalories());
            }else {
                int c = map.get(meal.getDateTime().toLocalDate()) + meal.getCalories();
                map.put(meal.getDateTime().toLocalDate(), c);
            }
        }

        for (Map.Entry<LocalDate, Integer> pair : map.entrySet()){
            for (UserMeal meal : mealList){
                if(meal.getDateTime().toLocalDate().equals(pair.getKey())){
                    if(pair.getValue()>caloriesPerDay){
                        userMealWithExceeds.add(new UserMealWithExceed(meal.getDateTime(), meal.getDescription(), meal.getCalories(), true));
                    }
                    if(pair.getValue()<=caloriesPerDay){
                        userMealWithExceeds.add(new UserMealWithExceed(meal.getDateTime(), meal.getDescription(), meal.getCalories(), false));
                    }

                }
            }
        }
/*
        for (UserMealWithExceed userMealWithExcee : userMealWithExceeds){
            System.out.println(userMealWithExcee);
        }
*/

        return userMealWithExceeds;
    }


}
