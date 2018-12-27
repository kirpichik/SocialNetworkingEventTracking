package org.polushin.snet.api;

import java.util.concurrent.Future;

public interface User extends Chat {

    /**
     * @return Unique ID of this user.
     */
    SnetUID getUserId();

    /**
     * @return User's first name.
     */
    Future<String> getFirstName();

    /**
     * @return User's last name.
     */
    Future<String> getLastName();

}
