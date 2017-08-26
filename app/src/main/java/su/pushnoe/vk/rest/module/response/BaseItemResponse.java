package su.pushnoe.vk.rest.module.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Базовый класс записи ответа
 */

public class BaseItemResponse<T> {

    public Integer count;
    public List<T> items = new ArrayList<>();

    public Integer getCount() {
        return count;
    }

    /**
     *
     * @return
     */
    public List<T> getItems() {
        return items;
    }
}
