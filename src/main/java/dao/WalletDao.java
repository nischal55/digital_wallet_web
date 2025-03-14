package dao;

import models.Wallet;

import java.util.List;

public interface WalletDao {
    boolean save(Wallet wallet);
    Wallet findById(Long id);
    List<Wallet> findAll();
    void update(Wallet wallet);
    void delete(Long id);
}
