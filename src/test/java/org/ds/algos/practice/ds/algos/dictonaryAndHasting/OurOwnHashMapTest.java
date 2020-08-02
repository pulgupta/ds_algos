package org.ds.algos.practice.ds.algos.dictonaryAndHasting;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class OurOwnHashMapTest {

    // Each test gets its own instance so we can initialise it here
    OurOwnHashMap map = new OurOwnHashMap();

    @Test
    void shouldAddElementSuccessfully() {
        map.add(1000000);
        assertThat(map.contains(1000000), is(true));
        assertThat(map.contains(11), is(false));
    }

    @Test
    void shouldRemoveOnlyTheRequiredElement() {
        map.add(0);
        map.add(10);
        map.add(10);
        map.add(10);
        assertThat(map.contains(10), is(true));
        assertThat(map.contains(0), is(true));
        map.remove(10);
        map.remove(100000);
        assertThat(map.contains(10), is(false));
        assertThat(map.contains(0), is(true));
    }

    @Test
    void shouldReturnTrueIfElementIsPresent() {
        map.add(10);
        assertThat(map.contains(10), is(true));
        assertThat(map.contains(11), is(false));
    }

    @Test
    void shouldWorkCorrectlyEvenInCaseOfRandomOperations() {
        map.add(100);
        map.add(99);
        map.add(34);
        map.add(199);

        assertThat(map.contains(99), is(true));
        assertThat(map.contains(199), is(true));

        map.remove(88);
        assertThat(map.contains(88), is(false));

        map.add(99);
        assertThat(map.contains(99), is(true));
        map.remove(99);
        assertThat(map.contains(99), is(false));
    }
}