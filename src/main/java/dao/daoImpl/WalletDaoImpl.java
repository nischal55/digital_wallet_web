package dao.daoImpl;

import dao.WalletDao;
import models.Wallet;

public class WalletDaoImpl extends BaseDaoImpl<Wallet> implements WalletDao {

    public WalletDaoImpl(){
        super(Wallet.class);
    }
}
