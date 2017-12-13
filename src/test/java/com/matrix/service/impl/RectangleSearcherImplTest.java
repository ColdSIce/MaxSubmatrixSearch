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
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

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
        {0,1,0,1,0,1,0,0,0,1},
        {1,0,0,1,0,1,1,1,0,0},
        {1,0,1,0,1,0,1,1,1,0},
        {0,1,1,1,0,1,0,0,1,0},
        {0,1,1,1,0,0,0,1,0,1},
        {1,1,1,1,0,1,0,1,1,0},
        {1,1,0,1,1,1,0,0,0,0},
        {0,0,0,0,0,1,1,1,0,1},
        {1,0,0,0,0,0,0,1,1,1},
        {1,0,1,1,0,1,0,1,0,1}
    };

    @Autowired
    private RectangleSearcher rectangleSearcher;

    @Test
    public void findMax() throws Exception {
        Rectangle rectangle = rectangleSearcher.findMax(matrix);

        System.out.println("\nmatrix:\n");
        System.out.print(" |");
        for(int i = 0; i < matrix.length; i++){
            System.out.print(i);
        }
        System.out.println();
        System.out.print("--");
        for(int i = 0; i < matrix.length; i++){
            System.out.print("-");
        }

        System.out.println();
        for(int i = 0; i < matrix.length; i++){
            System.out.printf("%d|", i);
            for(int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        System.out.println("\nLargest zero-rectangle: " + rectangle);
        System.out.println();

        assertThat(rectangle, is(notNullValue()));
        assertThat(rectangle.getTopLeft().getX(), equalTo(1));
        assertThat(rectangle.getTopLeft().getY(), equalTo(7));
        assertThat(rectangle.getBottomRight().getX(), equalTo(4));
        assertThat(rectangle.getBottomRight().getY(), equalTo(8));
    }

}