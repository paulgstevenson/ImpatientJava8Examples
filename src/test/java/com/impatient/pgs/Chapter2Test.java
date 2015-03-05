package com.impatient.pgs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Comparator;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

public class Chapter2Test {


    private Chapter2 chapter2;

    @Before
    public void setUp() throws IOException {
        chapter2 = new Chapter2();

    }


    @Test
    public void exercise1Test() throws IOException, URISyntaxException {
        assertThat(chapter2.countLongWords("/alice.txt")).isEqualTo(26);
    }

}
