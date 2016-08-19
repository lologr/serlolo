package gr.lolo.util;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SlugifierTest {

    private Slugifier slugifier = new Slugifier();

    @Test
    public void slugify_test() {
        assertEquals("patata", slugifier.slugify("πατάτα"));
        assertEquals("patata", slugifier.slugify("πατατα"));
        assertEquals("patata", slugifier.slugify("Πατατα"));
    }

    @Test
    public void slugify_with_exclusions_test() {
        assertEquals("patata-1", slugifier.slugify("πατάτα", () -> Arrays.asList("patata")));
        assertEquals("patata-2", slugifier.slugify("πατάτα", () -> Arrays.asList("patata", "patata-2")));
    }

}