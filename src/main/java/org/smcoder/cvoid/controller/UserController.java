package org.smcoder.cvoid.controller;

import org.smcoder.cvoid.domain.SmUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    public Object register(@RequestBody SmUser user) {
        return null;
    }

    public Object login(@RequestBody SmUser user) {
        return null;
    }

    public Object logout() {
        return null;
    }
}
