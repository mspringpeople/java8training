package candidate;

import entity.User;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * Created by marutsingh on 6/3/16.
 */
public class Class1Exercise {

    /**
     * Iterates the list in functional way
     * @param userList
     */
    void printByForEach(List<User> userList){
        throw new NotImplementedException();
    }

    /**
     * Iterates list using stream interface
     * @param userList
     */
    void printByForEachUsingStream(List<User> userList){
        throw new NotImplementedException();
    }

    /**
     * Filters Numbers starting with digit 2
     * @param userList
     * @return
     */
    void filterDigit2Numbers(List<User> userList){
        throw new NotImplementedException();
    }

    /**
     * Filters all users with even phone number
     * @param userList
     * @return
     */
    void filterUsersEndsWithEvenDigit(List<User> userList){
        throw new NotImplementedException();
    }

    /**
     * Filters users by Name and Phone
     * @param userList
     */
    void filterByNameAndPhoneUsingSingleFilter(List<User> userList,String name,long phone){
        throw new NotImplementedException();
    }

    /**
     * Filters users by Name and Phone
     * @param userList
     */
    void filterByNameAndPhoneUsingFilterChain(List<User> userList){
        throw new NotImplementedException();
    }
}
