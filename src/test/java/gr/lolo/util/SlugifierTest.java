package gr.lolo.util;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SlugifierTest {

    private Slugifier slugifier = new Slugifier();

    @Test
    public void slugify_test() {
        assertEquals("patata", slugifier.slugify("πατάτα"));
        assertEquals("patata", slugifier.slugify("πατατα"));
        assertEquals("patata", slugifier.slugify("Πατατα"));
        assertEquals("keftedes", slugifier.slugify("ΚΕΦΤΕΔΕΣ"));
        assertEquals("keftedes", slugifier.slugify("ΚΕΦΤΈΔΕΣ"));

        assertEquals("elies-throumpes", slugifier.slugify("ελιές θρούμπες"));
        assertEquals("ksifias", slugifier.slugify("ξιφίας"));

        assertEquals("kounoupidi-me-arxidia", slugifier.slugify("Κουνουπίδι με αρχίδια"));
        assertEquals("a-la-krem", slugifier.slugify("Α-λα κρεμ"));

        assertEquals("m-aresoun-ta-paidakia", slugifier.slugify("μ' αρέσουν τα παϊδάκια"));

        assertEquals("mpap", slugifier.slugify("&μπαπ"));

    }

    @Test
    public void slugify_invalid_characters_test() {
        assertEquals("mpap", slugifier.slugify("μπαπ "));
        assertEquals("mpap", slugifier.slugify("μπαπ  "));
        assertEquals("mpap-mpoump", slugifier.slugify("μπαπ--μπουμπ"));
        assertEquals("mpap-mpoump", slugifier.slugify(" μπαπ- -μπουμπ"));
        assertEquals("mpap-mpoump", slugifier.slugify("μπαπ  μπουμπ"));
        assertEquals("mpap-mpoump", slugifier.slugify("-μπαπ  μπουμπ-"));
        assertEquals("mpap", slugifier.slugify("μπαπ!@#$%^&*()_+={}|[]\\:\";',./<>?"));
    }

    @Test
    public void slugify_with_exclusions_test() {
        assertEquals("patata-1", slugifier.slugify("πατάτα", () -> Arrays.asList("patata")));
        assertEquals("patata-2", slugifier.slugify("πατάτα", () -> Arrays.asList("patata", "patata-1")));

        assertEquals("elies-throumpes-2", slugifier.slugify("ελιές θρούμπες", () -> Arrays.asList("elies-throumpes", "elies-throumpes-1")));
    }

}