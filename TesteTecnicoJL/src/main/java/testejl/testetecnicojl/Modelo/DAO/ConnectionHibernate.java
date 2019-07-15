package testejl.testetecnicojl.Modelo.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionHibernate {
    private static EntityManagerFactory factory;
    private static EntityManager manager;
    
    private ConnectionHibernate(){ }
    
    public static EntityManager getInstance(){
        if (manager == null){
            synchronized (ConnectionHibernate.class){
                if (manager == null){
                factory = Persistence.createEntityManagerFactory("POOII.utfpr_Memory-Game_jar_1.0-SNAPSHOTPU");
                manager = factory.createEntityManager();
                }
            }
        }
        return manager;
    }
    
    public static void close(){
        manager.close();
        factory.close();
    }
}
