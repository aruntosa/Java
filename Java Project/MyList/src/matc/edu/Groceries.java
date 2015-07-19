/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matc.edu;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "GROCERIES", catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "Groceries.findAll", query = "SELECT g FROM Groceries g"),
    @NamedQuery(name = "Groceries.findByName", query = "SELECT g FROM Groceries g WHERE g.name = :name"),
    @NamedQuery(name = "Groceries.findByQuantity", query = "SELECT g FROM Groceries g WHERE g.quantity = :quantity"),
    @NamedQuery(name = "Groceries.findBySize", query = "SELECT g FROM Groceries g WHERE g.size = :size"),
    @NamedQuery(name = "Groceries.findByNote", query = "SELECT g FROM Groceries g WHERE g.note = :note")})
public class Groceries implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Column(name = "SIZE")
    private String size;
    @Column(name = "NOTE")
    private String note;

    public Groceries() {
    }

    public Groceries(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        Integer oldQuantity = this.quantity;
        this.quantity = quantity;
        changeSupport.firePropertyChange("quantity", oldQuantity, quantity);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        String oldSize = this.size;
        this.size = size;
        changeSupport.firePropertyChange("size", oldSize, size);
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        String oldNote = this.note;
        this.note = note;
        changeSupport.firePropertyChange("note", oldNote, note);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groceries)) {
            return false;
        }
        Groceries other = (Groceries) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "matc.edu.Groceries[ name=" + name + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
