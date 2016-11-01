package com.softtek.java.academy.collections.service;

import com.softtek.java.academy.collections.domain.Party;

public class WorkNotification {

    private String todo;

    private Party user;

    public String getTodo() {

        return todo;
    }

    public void setTodo(String todo) {

        this.todo = todo;
    }

    public Party getUser() {

        return user;
    }

    public void setUser(Party user) {

        this.user = user;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + ((todo == null) ? 0 : todo.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof WorkNotification)) {
            return false;
        }
        WorkNotification other = (WorkNotification) obj;
        if (todo == null) {
            if (other.todo != null) {
                return false;
            }
        } else if (!todo.equals(other.todo)) {
            return false;
        }
        if (user == null) {
            if (other.user != null) {
                return false;
            }
        } else if (!user.equals(other.user)) {
            return false;
        }
        return true;
    }

}
