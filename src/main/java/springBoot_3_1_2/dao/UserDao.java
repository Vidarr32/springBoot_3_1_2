package springBoot_3_1_2.dao;


import springBoot_3_1_2.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();

    User getUserById(long id);
    void saveUser(User user);
    void updateUser(long id, User updetedUser);
    void deleteUser(long id);
}
