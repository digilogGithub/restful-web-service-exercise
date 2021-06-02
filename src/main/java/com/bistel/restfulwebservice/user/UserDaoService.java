package com.bistel.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int userCount = 3;

    static {
        users.add(new User(1, "digilog", new Date()));
        users.add(new User(2, "sia", new Date()));
        users.add(new User(3, "alice", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }

        users.add(user);
        return user;
    }

    public User fineOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id) {
        Iterator<User> itr = users.iterator();
        while (itr.hasNext()) {
            User user = itr.next();
            if (user.getId() == id) {
                itr.remove();
                return user;
            }
        }
        return null;
    }
}
