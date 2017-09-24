package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Contacts extends ForwardingSet<ContactsDate> {

    private Set<ContactsDate> delegate;

    public Contacts(Contacts contacts) {
        this.delegate = new HashSet<ContactsDate>(contacts.delegate);
    }

    public Contacts() {
    this.delegate = new HashSet<ContactsDate>();
    }

    public Contacts(Collection<ContactsDate> contacts) {
        this.delegate =  new HashSet<ContactsDate>();
    }

    @Override
    protected Set<ContactsDate> delegate() {
        return delegate;
    }

    public Contacts withAdded (ContactsDate contact){
    Contacts contacts = new Contacts(this);
    contacts.add(contact);
    return contacts;
    }
    public Contacts without (ContactsDate contact){
        Contacts contacts = new Contacts(this);
        contacts.remove(contact);
        return contacts;
    }
}

