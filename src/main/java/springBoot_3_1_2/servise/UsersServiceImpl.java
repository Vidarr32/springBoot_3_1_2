package springBoot_3_1_2.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springBoot_3_1_2.repository.UsersRepository;
import springBoot_3_1_2.model.User;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;


    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<User> getUsers() {
        return usersRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return usersRepository.findById((int)id).orElse(null);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        usersRepository.save(user);
    }

    @Override
    @Transactional
    public void updateUser(long id, User updetedUser) {
        updetedUser.setId(id);
        usersRepository.save(updetedUser);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        usersRepository.deleteById((int)id);
    }
}
