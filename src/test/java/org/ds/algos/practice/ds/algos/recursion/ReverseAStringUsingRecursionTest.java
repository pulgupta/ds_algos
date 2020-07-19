package org.ds.algos.practice.ds.algos.recursion;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.*;
import static org.junit.jupiter.api.Assertions.*;

class ReverseAStringUsingRecursionTest {

    @Test
    void shouldNotThrowErrorForEmptyString() {
        assertDoesNotThrow(() -> new ReverseAStringUsingRecursion().reverseString(new char[0]));
    }

    @Test
    void shouldNotThrowErrorForStringWithOneCharacter() {
        char[] string = {'h'};
        assertDoesNotThrow(() -> new ReverseAStringUsingRecursion().reverseString(string));
        assertThat(string[0], is('h'));
    }

    @Test
    void shouldReverseTheStringWithTwoCharacters() {
        char[] string = {'h', 'e'};
        new ReverseAStringUsingRecursion().reverseString(string);
        assertThat(string, is(new char[]{'e', 'h'}));
    }

    @Test
    void shouldReverseTheStringWithManyCharacters() {
        char[] string = {'h', 'e', 'l', 'l','o'};
        new ReverseAStringUsingRecursion().reverseString(string);
        assertThat(string, is(new char[]{'o', 'l', 'l', 'e','h'}));
    }

}