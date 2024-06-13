/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0052_manage_the_geographic;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author trung
 */
public class BO_Manage_The_GeographicTest {

    private BO_Manage_The_Geographic boManageTheGeographic;

    public BO_Manage_The_GeographicTest() {
        boManageTheGeographic = new BO_Manage_The_Geographic();
    }

    @Test
    public void testAddCountryInformation() throws Exception {
        EastAsiaCountries country1 = new EastAsiaCountries("VN", "Vietnam", 331212, "S-shaped country");
        EastAsiaCountries country2 = new EastAsiaCountries("JP", "Japan", 377975, "Island nation");

        boManageTheGeographic.addCountryInformation(country1);
        boManageTheGeographic.addCountryInformation(country2);

        List<EastAsiaCountries> countries = boManageTheGeographic.searchInformationByName("");
        assertEquals(2, countries.size());
        assertEquals("Vietnam", countries.get(0).getCountryName());
        assertEquals("Japan", countries.get(1).getCountryName());

        // Test for duplicate entry
        try {
            boManageTheGeographic.addCountryInformation(country1);
            fail("Expected an Exception to be thrown");
        } catch (Exception e) {
            assertEquals("Country you just enter almost exists!", e.getMessage());
        }
    }

    @Test
    public void testGetRecentlyEnteredInformation() throws Exception {
        EastAsiaCountries country = new EastAsiaCountries("VN", "Vietnam", 331212, "S-shaped country");
        boManageTheGeographic.addCountryInformation(country);

        EastAsiaCountries recentCountry = boManageTheGeographic.getRecentlyEnteredInformation();
        assertNotNull(recentCountry);
        assertEquals("Vietnam", recentCountry.getCountryName());
    }

    @Test
    public void testSearchInformationByName() throws Exception {
        EastAsiaCountries country1 = new EastAsiaCountries("VN", "Vietnam", 331212, "S-shaped country");
        EastAsiaCountries country2 = new EastAsiaCountries("JP", "Japan", 377975, "Island nation");

        boManageTheGeographic.addCountryInformation(country1);
        boManageTheGeographic.addCountryInformation(country2);

        // Test search by full name
        List<EastAsiaCountries> result = boManageTheGeographic.searchInformationByName("Vietnam");
        assertEquals(1, result.size());
        assertEquals("Vietnam", result.get(0).getCountryName());

        // Test search by partial name
        result = boManageTheGeographic.searchInformationByName("Jap");
        assertEquals(1, result.size());
        assertEquals("Japan", result.get(0).getCountryName());

        // Test search with empty string
        result = boManageTheGeographic.searchInformationByName("");
        assertEquals(2, result.size());

        // Test search with no matching results
        result = boManageTheGeographic.searchInformationByName("China");
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSortInformationByAscendingOrder() throws Exception {
        EastAsiaCountries country1 = new EastAsiaCountries("VN", "Vietnam", 331212, "S-shaped country");
        EastAsiaCountries country2 = new EastAsiaCountries("JP", "Japan", 377975, "Island nation");
        EastAsiaCountries country3 = new EastAsiaCountries("CN", "China", 9596961, "Largest country in East Asia");

        boManageTheGeographic.addCountryInformation(country1);
        boManageTheGeographic.addCountryInformation(country2);
        boManageTheGeographic.addCountryInformation(country3);

        EastAsiaCountries[] sortedCountries = boManageTheGeographic.sortInformationByAscendingOrder();
        assertEquals(3, sortedCountries.length);
        assertEquals("China", sortedCountries[0].getCountryName());
        assertEquals("Japan", sortedCountries[1].getCountryName());
        assertEquals("Vietnam", sortedCountries[2].getCountryName());
    }

}
