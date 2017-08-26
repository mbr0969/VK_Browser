package su.pushnoe.vk;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKSdk;

/**
 * Класс текущего пользователя
 */
public class CurrentUser {

    /**
     *
     * @return
     */
    public static String getAccessToken() {

        if (VKAccessToken.currentToken() == null){
            return null;
        }
            return VKAccessToken.currentToken().accessToken;
    }

    /**
     *
     * @return
     */
    public static String getId(){
        if (VKAccessToken.currentToken() == null){
            return null;
        }
        return VKAccessToken.currentToken().userId;
    }

    /**
     *
     * @return
     */
    public static boolean isAuthorized(){
        return VKSdk.isLoggedIn() && VKAccessToken.currentToken() !=null
                && !VKAccessToken.currentToken().isExpired();
    }
}
