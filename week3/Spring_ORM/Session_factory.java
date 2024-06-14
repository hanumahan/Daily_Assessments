package week3.Spring_ORM;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class Session_factory {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void saveUser(User user) {
        getSession().save(user);
    }

    @Transactional(readOnly = true)
    public User findUserById(int id) {
        return getSession().get(User.class, id);
    }

    @Transactional(readOnly = true)
    public List<User> findAllUsers() {
        return getSession().createQuery("from User", User.class).list();
    }

    @Transactional
    public void updateUser(User user) {
        getSession().update(user);
    }

    @Transactional
    public void deleteUser(User user) {
        getSession().delete(user);
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
