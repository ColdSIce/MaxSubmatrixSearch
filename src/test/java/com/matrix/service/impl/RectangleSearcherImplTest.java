package com.matrix.service.impl;

import com.matrix.model.Rectangle;
import com.matrix.service.RectangleSearcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RectangleSearcherImplTest {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public RectangleSearcher rectangleSearcher() {
            return new RectangleSearcherImpl();
        }
    }

    //10x10
    private final static int[][] matrix = {
        {0,1,0,1,0,1,0,1,0,1},
        {1,0,0,1,0,1,1,1,0,0},
        {1,0,0,1,1,0,1,1,1,0},
        {0,0,1,1,0,1,0,1,1,0},
        {0,1,1,1,0,0,0,1,0,1},
        {1,0,0,1,0,1,0,1,1,0},
        {1,1,0,1,1,1,0,1,0,1},
        {0,0,0,0,0,1,1,1,0,0},
        {1,0,0,0,0,0,0,1,1,1},
        {1,0,1,1,0,1,0,1,0,1},
    };

    @Autowired
    private RectangleSearcher rectangleSearcher;

    @Test
    public void findMax() throws Exception {
        Rectangle rectangle = rectangleSearcher.findMax(matrix);
        assertThat(rectangle.getTopLeft().getX(), equalTo(1));
        assertThat(rectangle.getTopLeft().getY(), equalTo(7));
        assertThat(rectangle.getBottomRight().getX(), equalTo(4));
        assertThat(rectangle.getBottomRight().getY(), equalTo(8));
    }

}