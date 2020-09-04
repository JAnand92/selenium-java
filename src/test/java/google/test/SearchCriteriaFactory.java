package google.test;

import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class SearchCriteriaFactory {

    private static Predicate<List<WebElement>> male = (m) -> m.get(1).getText().equalsIgnoreCase("male");
    private static Predicate<List<WebElement>> female = (f) -> f.get(1).getText().equalsIgnoreCase("female");
    private static Predicate<List<WebElement>> allGender = male.or(female);
    private static Predicate<List<WebElement>> countryAU = (c) -> c.get(2).getText().equalsIgnoreCase("AU");
    private static Predicate<List<WebElement>> allFemaleAU = female.and(countryAU);

    private static final Map<String, Predicate<List<WebElement>>> MAP = new HashMap<>();

    static {
        MAP.put("male", male);
        MAP.put("female", female);
        MAP.put("allGender", allGender);
        MAP.put("countryAU", countryAU);
        MAP.put("allFemaleAU", allFemaleAU);
    }
    public static Predicate<List<WebElement>> getCriteria(String criteriaName) {
        return MAP.get(criteriaName);
    }

}
