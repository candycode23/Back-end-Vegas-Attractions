package domain.vegasattractions.models;

import com.vegasattractions.vegasmainattractions.domain.vegasattractions.models.VegasAttractions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VegasAttractionsTest {
    @Test
            public void constructorTest01(){
    VegasAttractions vegasAttractions = new VegasAttractions("Janet","McKoy","JM@user.com", "Night Life", "October 23rd 2023 - November 1st 2023");
    vegasAttractions.setId(1L);

    String expected = "1 Janet McKoy JM@user.com Night Life October 23rd 2023 - November 1st 2023";
    String actual = vegasAttractions.toString();

    Assertions.assertEquals(expected, actual);
}
}
