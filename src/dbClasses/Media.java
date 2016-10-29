/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbClasses;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Ivan
 */
@Entity
@Table(name = "media")
@NamedQueries({
    @NamedQuery(name = "Media.findAll", query = "SELECT m FROM Media m")
    , @NamedQuery(name = "Media.findByMediaId", query = "SELECT m FROM Media m WHERE m.mediaId = :mediaId")
    , @NamedQuery(name = "Media.findByTitle", query = "SELECT m FROM Media m WHERE m.title = :title")
    , @NamedQuery(name = "Media.findByType", query = "SELECT m FROM Media m WHERE m.type = :type")
    , @NamedQuery(name = "Media.findByFormat", query = "SELECT m FROM Media m WHERE m.format = :format")
    , @NamedQuery(name = "Media.findByYear", query = "SELECT m FROM Media m WHERE m.year = :year")
    , @NamedQuery(name = "Media.findByGenre", query = "SELECT m FROM Media m WHERE m.genre = :genre")
    , @NamedQuery(name = "Media.findByLocation", query = "SELECT m FROM Media m WHERE m.location = :location")
    , @NamedQuery(name = "Media.findByRating", query = "SELECT m FROM Media m WHERE m.rating = :rating")
    , @NamedQuery(name = "Media.findByLoanedTo", query = "SELECT m FROM Media m WHERE m.loanedTo = :loanedTo")
    , @NamedQuery(name = "Media.findByLoanedDate", query = "SELECT m FROM Media m WHERE m.loanedDate = :loanedDate")
    , @NamedQuery(name = "Media.findByAuthor", query = "SELECT m FROM Media m WHERE m.author = :author")
    , @NamedQuery(name = "Media.findByVolume", query = "SELECT m FROM Media m WHERE m.volume = :volume")
    , @NamedQuery(name = "Media.findByPublisher", query = "SELECT m FROM Media m WHERE m.publisher = :publisher")
    , @NamedQuery(name = "Media.findByVersion", query = "SELECT m FROM Media m WHERE m.version = :version")
    , @NamedQuery(name = "Media.findByEdition", query = "SELECT m FROM Media m WHERE m.edition = :edition")
    , @NamedQuery(name = "Media.findByDirector", query = "SELECT m FROM Media m WHERE m.director = :director")
    , @NamedQuery(name = "Media.findByDuration", query = "SELECT m FROM Media m WHERE m.duration = :duration")
    , @NamedQuery(name = "Media.findByArtist", query = "SELECT m FROM Media m WHERE m.artist = :artist")
    , @NamedQuery(name = "Media.findByAlbum", query = "SELECT m FROM Media m WHERE m.album = :album")
    , @NamedQuery(name = "Media.findByTrackNumber", query = "SELECT m FROM Media m WHERE m.trackNumber = :trackNumber")})
public class Media implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "media_id")
    private Integer mediaId;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Column(name = "format")
    private String format;
    @Column(name = "year")
    private Integer year;
    @Column(name = "genre")
    private String genre;
    @Column(name = "location")
    private String location;
    @Column(name = "rating")
    private Integer rating;
    @Column(name = "loaned_to")
    private String loanedTo;
    @Column(name = "loaned_date")
    private String loanedDate;
    @Column(name = "author")
    private String author;
    @Column(name = "volume")
    private String volume;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "version")
    private String version;
    @Column(name = "edition")
    private String edition;
    @Column(name = "director")
    private String director;
    @Column(name = "duration")
    private String duration;
    @Column(name = "artist")
    private String artist;
    @Column(name = "album")
    private String album;
    @Column(name = "track_number")
    private Integer trackNumber;

    public Media() {
    }

    public Media(Integer mediaId) {
        this.mediaId = mediaId;
    }

    public Media(Integer mediaId, String title, String type) {
        this.mediaId = mediaId;
        this.title = title;
        this.type = type;
    }

    public Integer getMediaId() {
        return mediaId;
    }

    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getLoanedTo() {
        return loanedTo;
    }

    public void setLoanedTo(String loanedTo) {
        this.loanedTo = loanedTo;
    }

    public String getLoanedDate() {
        return loanedDate;
    }

    public void setLoanedDate(String loanedDate) {
        this.loanedDate = loanedDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Integer getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mediaId != null ? mediaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Media)) {
            return false;
        }
        Media other = (Media) object;
        if ((this.mediaId == null && other.mediaId != null) || (this.mediaId != null && !this.mediaId.equals(other.mediaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbClasses.Media[ mediaId=" + mediaId + " ]";
    }
    
}
