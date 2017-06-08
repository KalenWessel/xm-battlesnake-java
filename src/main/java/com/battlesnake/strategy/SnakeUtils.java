package com.battlesnake.strategy;

import java.util.List;
import com.battlesnake.data.Snake;
import org.springframework.util.StringUtils;

public class SnakeUtils {

    Snake findSnakeByUUID(String uuid, List<Snake> snakes) {
        for (Snake snake: snakes) {
            if (uuid.equals(snake.getId())) {
                return snake;
            }
        }
        return null;
    }
}
