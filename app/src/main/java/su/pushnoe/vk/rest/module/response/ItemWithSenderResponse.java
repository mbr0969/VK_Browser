package su.pushnoe.vk.rest.module.response;


import su.pushnoe.vk.model.Group;
import su.pushnoe.vk.model.Owner;
import su.pushnoe.vk.model.Profile;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @param <T>
 */
public class ItemWithSenderResponse<T> extends BaseItemResponse<T>{
    private List<Profile> profiles = new ArrayList<>();
    private List<Group> groups = new ArrayList<>();


    /**
     *
     * @return
     */
    private List<Profile> getProfiles() {
        return profiles;
    }

    /**
     *
     * @return
     */
    private List<Group> getGroups() {
        return groups;
    }

    /**
     *
     * @return
     */
    private List<Owner> getAllSenders(){
        List<Owner> all = new ArrayList<>();
        all.addAll(getProfiles());
        all.addAll(getGroups());
        return all;
    }

    /**
     *
     * @param id
     * @return
     */
    public Owner getSender(int id){
        for (Owner owner : getAllSenders()){
            if (owner.getId() == Math.abs(id)){
                return owner;
            }
        }
       return null;
    }
}
