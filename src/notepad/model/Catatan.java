/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "catatan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catatan.findAll", query = "SELECT c FROM Catatan c"),
    @NamedQuery(name = "Catatan.findByJudul", query = "SELECT c FROM Catatan c WHERE c.judul = :judul"),
    @NamedQuery(name = "Catatan.findByTanggal", query = "SELECT c FROM Catatan c WHERE c.tanggal = :tanggal")})
public class Catatan implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "judul")
    private String judul;
    @Lob
    @Column(name = "isi")
    private String isi;
    @Column(name = "tanggal")
    @Temporal(TemporalType.DATE)
    private Date tanggal;

    public Catatan() {
    }

    public Catatan(String judul) {
        this.judul = judul;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        String oldJudul = this.judul;
        this.judul = judul;
        changeSupport.firePropertyChange("judul", oldJudul, judul);
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        String oldIsi = this.isi;
        this.isi = isi;
        changeSupport.firePropertyChange("isi", oldIsi, isi);
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        Date oldTanggal = this.tanggal;
        this.tanggal = tanggal;
        changeSupport.firePropertyChange("tanggal", oldTanggal, tanggal);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (judul != null ? judul.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catatan)) {
            return false;
        }
        Catatan other = (Catatan) object;
        if ((this.judul == null && other.judul != null) || (this.judul != null && !this.judul.equals(other.judul))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "notepad.model.Catatan[ judul=" + judul + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
