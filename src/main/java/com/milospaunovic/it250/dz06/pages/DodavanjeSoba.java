
package com.milospaunovic.it250.dz06.pages;
import com.milospaunovic.it250.dz06.entities.Soba;
import java.util.ArrayList;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

public class DodavanjeSoba {
    @Property
    private Soba sob1;
    
    @Inject
    private Session session;
    
    @Property
    private ArrayList<Soba> listaSoba;
    
    void onActivate(){
        if (listaSoba == null){
            listaSoba = new ArrayList<Soba>();
        }
        listaSoba = (ArrayList<Soba>) session.createCriteria(Soba.class).list();
    }
    
    @CommitAfter
    Object onSuccess(){
        session.persist(sob1);
        return this;
    }
}
