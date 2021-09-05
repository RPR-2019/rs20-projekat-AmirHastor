package ba.unsa.etf.rs;

public class Patient {
    private int id;
    private String name;
    private String surname;
    private int contact;

    public Patient(int id, String name, String surname, int contact) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.contact = contact;
    }

    public Patient() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    @Override
    public String toString() { return name; }
}
