package su.pushnoe.vk.common.utils;

import java.util.List;

import su.pushnoe.vk.model.Owner;
import su.pushnoe.vk.model.WallItem;
import su.pushnoe.vk.rest.module.response.ItemWithSenderResponse;

/**
 *
 */

public class VKListHelper {

    /**
     *
     * @param response
     * @return
     */
    public static List<WallItem> getWallList(ItemWithSenderResponse<WallItem> response){
        List<WallItem> wallItems = response.items;

        for (WallItem wallItem : wallItems){
            Owner sender = response.getSender(wallItem.getFromId());
            wallItem.setSenderName(sender.getFullName());
            wallItem.setSenderPhoto(sender.getPhoto());

            wallItem.setAttachmentString(Utils.convertAttachmentsToFontIcons(wallItem.getAttachments()));



            if (wallItem.haveSharedRepost()){
                Owner repostSender = response.getSender(wallItem.getSharedRepost().getFromId());
                wallItem.getSharedRepost().setSenderName(repostSender.getFullName());
                wallItem.getSharedRepost().setSenderPhoto(repostSender.getPhoto());

                wallItem.getSharedRepost().setAttachmentString(Utils.convertAttachmentsToFontIcons(
                        wallItem.getSharedRepost().getAttachments()
                ));

            }
        }
        return wallItems;

    }
}
