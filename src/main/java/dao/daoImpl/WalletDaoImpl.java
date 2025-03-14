package dao.daoImpl;

import dao.WalletDao;
import models.Wallet;

import javax.persistence.TypedQuery;

public class WalletDaoImpl extends BaseDaoImpl<Wallet> implements WalletDao {

    public WalletDaoImpl(){
        super(Wallet.class);
    }

    @Override
    public Wallet findWalletByContact(String contact) {
        Wallet wallet = null;
            try {
                String jpql = "SELECT w FROM Wallet w JOIN w.user u WHERE u.contact = :contact";
                TypedQuery<Wallet> query = em.createQuery(jpql, Wallet.class);
                query.setParameter("contact", contact);
                wallet = query.getSingleResult();

                return wallet;
            }catch(Exception e){
                return wallet;
            }

    }
}
