package springBoot_3_1_2.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import springBoot_3_1_2.model.User;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        return entityManager.createQuery("select user from User user", User.class).getResultList();
    }

    @Override
    public User getUserById(long id) {
        return (User) entityManager.createQuery("from User user where user.id = :id")
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(long id, User updetedUser){
        User user = entityManager.find(User.class, id);

        user.setName(updetedUser.getName());
        user.setLastname(updetedUser.getLastname());
        user.setEmail(updetedUser.getEmail());
    }

    @Override
    public void deleteUser(long id){
        entityManager.remove(entityManager.find(User.class, id));
    }
}
