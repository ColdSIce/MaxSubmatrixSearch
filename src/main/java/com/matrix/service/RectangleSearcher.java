package com.matrix.service;

import com.matrix.model.Rectangle;
import org.springframework.stereotype.Service;

@Service
public interface RectangleSearcher {
    Rectangle findMax(int[][] matrix);
}
