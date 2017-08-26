package su.pushnoe.vk.model;
import com.vk.sdk.api.model.Identifiable;
/**
 * Класс вывода хедера
 * Created by papa on 25.08.17.
 */

public interface Owner extends Identifiable {
    String getFullName();
    String getPhoto();
}
