package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель данных счета
 *
 * @author OLGA REMNEVA
 */
public class Account {
    /**
     * Хранение номера счета осуществляется в поле requisite
     * Хранение остатка по счету осуществляется в поле balance
     */
    private String requisite;
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод позволяет получить номер счета
     *
     * @return возвращает номер счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод позволяет присвоить номер счета при его создании
     *
     * @param requisite номер счета и null, если номера нет
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод позволяет получить остаток по счету.
     *
     * @return остаток по счету или null, если остатка нет
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод позволяет назначить остаток по счету
     *
     * @param balance остаток по счету
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод принимает на вход Object o, проверяет, что он совпадает с текущим объектом
     * по полю requisite
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Метод возращает hash - код объекта, сгенерированному по полю requisite
     *
     * @return возвращает hash - код объекта, сгенерированному по полю requisite
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
