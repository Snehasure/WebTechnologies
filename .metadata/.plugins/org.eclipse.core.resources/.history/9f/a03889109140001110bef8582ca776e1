package com.bookstore;

import com.bookstore.entity.User;
import com.bookstore.util.HibernateUtil;
import org.hibernate.Session;

public class DatabaseConnection {

    // Validate user login using Hibernate
    public static boolean validateUser(String username, String password) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            User user = session.createQuery(
                    "FROM User WHERE username = :username AND password = :password",
                    User.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .uniqueResult();

            return user != null;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}