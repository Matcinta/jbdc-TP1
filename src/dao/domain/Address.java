package dao.domain;

import java.util.Set;

public class Address {

    private Long id;
    private String details;
    private Set<Contact> contacts;


    // CONSTRUCTOR
        public Address() {

        }

    // ****** GETTERS ******

        public Long getId() {
            return id;
        }

        public String getDetails() {
            return details;
        }

    // ****** SETTERS ******

        public void setId(Long id) {
            this.id = id;
        }
        public void setDetails(String details) {
            this.details = details;
        }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address{");
        sb.append("id=").append(id);
        sb.append(", details='").append(details).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
