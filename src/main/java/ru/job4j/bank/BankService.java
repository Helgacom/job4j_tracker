package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского сервиса, который включает:
 * добавление пользователя, если такого пользователя еще нет в системе;
 * добавление нового счета к пользователю;
 * поиск пользователя по номеру паспорта;
 * поиск счета пользователя по реквизитам;
 * перевод с одного счета на другой
 *
 * @author OLGA REMNEVA
 * @version 1.0
 */
public class BankService {
    /**
     * поле содержит всех пользователей системы с привязанными к ним счетами
     * хранение в справочнике HashMap (ключ - User, значение - счета пользователя в ArrayList)
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового пользователя в систему
     * с использованием метода Map.put(), который принимает объект типа User и
     * добавляет к нему пустой список для хранения привязанных счетов,
     * пользователь должен быть уникален, для проверки используем putIfAbsent
     *
     * @param user объект типа User, пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет новый счет к пользователю:
     * находим пользователя по паспорту findByPassport,
     * получаем список всех счетов пользователя и добавляем новый счет к ним,
     * если этого счета еще нет в системе
     *
     * @param passport номер паспорта
     * @param account объект счета
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта:
     * используется перебор всех элементов через for-each
     * в коллекции, полученной через метод keySet()
     *
     * @param passport номер пасспорта
     * @return возвращает объект User
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод ищет пользователя по реквизитам:
     * сначала находим пользователя по паспорту, если он найден
     * получаем список счетов пользователя и находим нужный счет
     *
     * @param passport номер паспорта
     * @param requisite номер счета
     * @return возвращает объект Account или null, если такого пользователя или счета не существует
     */
    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
    }

    /**
     * Метод на вход принимает номер паспорта и номер счета для источника и цели.
     * Метод возвращает true, если счет - источника и цели не равен нулю,
     * и на счете - источнике достаточно средств для перевода.
     * Если хотя бы одно из условий не соблюдается, то возвращает false.
     * При переводе баланс счета источника уменьшается на amount
     *
     * @param srcPassport   номер паспорта юзера, со счета которого будет перевод
     * @param srcRequisite  номер счета, с которого будет перевод
     * @param destPassport  номер паспорта юзера, на счет которого будет перевод
     * @param destRequisite номер счета, на который будет перевод
     * @param amount        сумма перевода
     * @return возвращает true или false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            destAccount.setBalance(destAccount.getBalance() + amount);
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}
