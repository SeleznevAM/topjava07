package ru.javawebinar.topjava.model;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

/**
 * Created by alex on 08.06.2016.
 */
public class DAO {
    public static List<UserMeal> mealList = Arrays.asList(
            new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
            new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
            new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
            new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
            new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
            new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510)
    );

    public static List<UserMeal> addMeal(LocalDateTime ldt, String discr, Integer calories){
        mealList.add(new UserMeal(ldt, discr, calories));
        return mealList;
    }

    public static List<UserMeal> getMealList() {
        return mealList;
    }

    public static void setMealList(List<UserMeal> mealList) {
        DAO.mealList = mealList;
    }
}
