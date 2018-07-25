package org.polushin.snet.api;

public interface User extends Chat {

    /**
     * @return Unique ID of this user.
     */
    long getUserId();

    /**
     * @return User's first name.
     */
    String getFirstName();

    /**
     * @return User's last name.
     */
    String getLastName();

}
