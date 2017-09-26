package ru.stqa.pft.addressbook.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContactsDate;
import ru.stqa.pft.addressbook.model.GroupDate;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;

public class DbHelper {

    private final SessionFactory sessionFactory;

    public DbHelper(){
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    
    }

    public Groups groups(String where){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<GroupDate> result = session.createQuery("from GroupDate " + where).list();
        session.getTransaction().commit();
        session.close();
        return new Groups(result);
    }

    public Contacts contacts (){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<ContactsDate> result = session.createQuery( "from ContactsDate where deprecated='0000-00-00'" ).list();
        session.getTransaction().commit();
        session.close();
        return new Contacts (result);
    }
}
