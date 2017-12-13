package com.matrix.service.impl;

import com.matrix.model.Point;
import com.matrix.model.Rectangle;
import com.matrix.service.RectangleSearcher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Component
public class RectangleSearcherImpl implements RectangleSearcher {

    @Override
    public Rectangle findMax(int[][] matrix) {

        //инвертируем матрицу
        int[][] iMatrix = new int[matrix.length][matrix[0].length];
        for(int i = 1; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                iMatrix[i][j] = matrix[i][j] == 0 ? 1 : 0;
            }
        }

        //считаем кол-во единиц над каждой ячейкой
        int[][] pMatrix = new int[iMatrix.length][iMatrix[0].length];
        pMatrix[0] = iMatrix[0];

        for(int i = 1; i < iMatrix.length; i++){
            for(int j = 0; j < iMatrix[0].length; j++){
                pMatrix[i][j] = iMatrix[i][j] == 0 ? 0 : pMatrix[i-1][j] + 1;
            }
        }

        /*для каждой ячейки, в которой сейчас высота единичного прямоугольника,
        основание которого лежит в строке i, проверяем высоту в соседней ячейке.
        если такая же или больше, то двигаем индекс правой стороны прямоугольника на 1 вправо.
        Далее считаем площадь, объединяем данные в объект "прямоугольник".*/
        List<Rectangle> rList = new ArrayList<>();
        for(int i = 0; i < pMatrix.length; i++){
            for(int j = 0; j < pMatrix[0].length; j++){
                if(pMatrix[i][j] > 0){
                    int h = pMatrix[i][j];
                    int r = j;

                    int k = j+1;
                    while(k < pMatrix[i].length && pMatrix[i][j] <= pMatrix[i][k]){
                        r++;
                        k++;
                    }

                    int s = h * (r - j + 1);

                    rList.add(new Rectangle(new Point(j, i-h+1), new Point(r, i), s));
                }
            }
        }

        //ищем прямоугольник с макс площадью
        Optional<Rectangle> optional = rList.stream().max(Comparator.comparing(Rectangle::getS));

        return optional.orElse(null);
    }
}
