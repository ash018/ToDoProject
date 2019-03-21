package com.smakash.todo.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Items")
public class Item extends Model implements Comparable<Item> {
    @Column(name = "Subject")
    public String subject;

    @Column(name = "DueDate")
    public String dueDate;

    @Column(name = "DueTime")
    public String dueTime;

    @Column(name = "Priority")
    public Priority priority;

    @SuppressWarnings("unused")
    public Item(){
        super();
    }

    public Item(String subject){
        super();
        this.subject = subject;
    }

    @Override
    public int compareTo(Item item) {

        if(item.dueDate != null && this.dueDate == null) {
            return 1;
        }
        if(item.dueDate == null && this.dueDate != null) {
            return -1;
        }

        if(item.dueDate != null && this.dueDate != null && item.dueDate.compareTo(this.dueDate) > 0) {
            return -1;
        } else if(item.dueDate != null && this.dueDate != null && item.dueDate.compareTo(this.dueDate) < 0) {
            return 1;
        } else {
            return this.priority.getValue() - item.priority.getValue();
        }
    }
}
