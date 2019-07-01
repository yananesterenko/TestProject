package com.project.dao;

import com.project.models.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.util.List;
import java.util.logging.Logger;


public class ItemDaoImpl implements ItemDao{

    private static final  Logger logger =  Logger.getLogger(ItemDaoImpl.class.getName());

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public  void addItem(Item item) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(item);
        logger.info("Item " +item + " was added");
    }


    public void updateItem(Item item) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(item);
        logger.info("Item " +item + " was changed");
    }

    @Override
    public void deleteItem(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Item item = (Item) session.load(Item.class, new Integer(id));
        if (item != null){
            session.delete(item);
            logger.info("Item " +item + " was deleted");
        }

    }

    @Override
    public Item getItemById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Item item = (Item) session.load(Item.class, new Integer(id));
        if (item != null) {
            logger.info("Item successfuly loaded. Item details: " + item);
            return item;
        } else
            return null;
    }

    @Override
    public List<Item> listItems() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Item> itemList = session.createQuery("from Item").list();
        for (Item item: itemList){
            logger.info("Item " +  item);

        }
        return itemList;
    }
}

