package ListStuff;

import java.util.*;

/**
 * Created by lchan39 on 8/3/15.
 */
public class SortedSetUsage {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Welcome to CoderPad.");
        strings.add("");

        for (String string : strings) {
            System.out.println(string);
        }

        testCountriesForUi();
    }

    static final List<String> topCountries = Arrays.asList("United States", "Canada", "Mexico", "Canada");

    public static void testCountriesForUi() {
        // Assume this comes from some configurable data store
        final List<String> allCountries = Arrays.asList("Algeria", "Albania", "Zimbabwe", "United States", "Mexico", "Canada", "United Kingdom");

        for (String country : countriesForUi(allCountries, topCountries)) {
            System.out.println(country);
        }
    }

    /**
     * Given above code, implement the method countriesForUI()
     */

    // using LinkedHashMap
    // works, handles duplicates.
    // Issue: returns a set, which would be make random access expensive
    // nlogn: sorting
    public static Set<String> countriesForUi(List<String> allCountries, List<String> topCountries) {

        Set<String> result = new LinkedHashSet<String>();

        Collections.sort(allCountries); //nlogn
        for(String topCountry: topCountries){
            if(allCountries.contains(topCountry)){ // contains call does binary search (logn)
                result.add(topCountry);
            }
        }
        result.addAll(allCountries);
        return result;
    }

    // using SortedSet (TreeSet)
    // avoids having to do explicit sort , returns a list
    public static List<String> dfe_countriesForUi(Collection<String> allCountries, List<String> topCountries) {
        final SortedSet<String> allCountrySet = new TreeSet<String>(allCountries);
        final List<String> result = new ArrayList<String>(allCountries.size());
        for (String country : topCountries) {
            if (allCountrySet.remove(country)) {
                result.add(country);
            }
        }
        result.addAll(allCountrySet);
        return result;
    }
}
