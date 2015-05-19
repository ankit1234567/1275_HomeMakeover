package com.ravi.ravi;

public class inc {

    // private variables
    public int _id;
    public String _date;
    public String _amount;
    public String _note;


    public inc() {
    }

    // constructor
    public inc(int id, String date, String _amount, String _note) {
        this._id = id;
        this._date = date;
        this._amount = _amount;
        this._note = _note;

    }

    // constructor
    public inc(String _date, String _amount, String _note) {
        this._date = _date;
        this._amount = _amount;
        this._note = _note;
    }

    // getting ID
    public int getID() {
        return this._id;
    }

    // setting id
    public void setID(int id) {
        this._id = id;
    }

    // getting name
    public String getDate() {
        return this._date;
    }

    // setting name
    public void setDate(String date) {
        this._date= date;
    }

    // getting phone number
    public String getAmount() {
        return this._amount;
    }

    // setting phone number
    public void setAmount(String amount) {
        this._amount = amount;
    }

    // getting email
    public String getNote() {
        return this._note;
    }

    // setting email
    public void setNote(String note) {
        this._note = note;
    }

}