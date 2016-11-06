/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbClasses;

import Enums.MediaType;
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
@Table(name = "app_media")
@NamedQueries({
    @NamedQuery(name = "AppMedia.findAll", query = "SELECT a FROM AppMedia a")
    , @NamedQuery(name = "AppMedia.findByMediaId", query = "SELECT a FROM AppMedia a WHERE a.mediaId = :mediaId")
    , @NamedQuery(name = "AppMedia.findByTitle", query = "SELECT a FROM AppMedia a WHERE a.title = :title")
    , @NamedQuery(name = "AppMedia.findByType", query = "SELECT a FROM AppMedia a WHERE a.type = :type")
    , @NamedQuery(name = "AppMedia.findByFormat", query = "SELECT a FROM AppMedia a WHERE a.format = :format")
    , @NamedQuery(name = "AppMedia.findByYear", query = "SELECT a FROM AppMedia a WHERE a.year = :year")
    , @NamedQuery(name = "AppMedia.findByGenre", query = "SELECT a FROM AppMedia a WHERE a.genre = :genre")
    , @NamedQuery(name = "AppMedia.findByLocation", query = "SELECT a FROM AppMedia a WHERE a.location = :location")
    , @NamedQuery(name = "AppMedia.findByRating", query = "SELECT a FROM AppMedia a WHERE a.rating = :rating")
    , @NamedQuery(name = "AppMedia.findByLoanedTo", query = "SELECT a FROM AppMedia a WHERE a.loanedTo = :loanedTo")
    , @NamedQuery(name = "AppMedia.findByLoanedDate", query = "SELECT a FROM AppMedia a WHERE a.loanedDate = :loanedDate")
    , @NamedQuery(name = "AppMedia.findByAuthor", query = "SELECT a FROM AppMedia a WHERE a.author = :author")
    , @NamedQuery(name = "AppMedia.findByVolume", query = "SELECT a FROM AppMedia a WHERE a.volume = :volume")
    , @NamedQuery(name = "AppMedia.findByPublisher", query = "SELECT a FROM AppMedia a WHERE a.publisher = :publisher")
    , @NamedQuery(name = "AppMedia.findByVersion", query = "SELECT a FROM AppMedia a WHERE a.version = :version")
    , @NamedQuery(name = "AppMedia.findByEdition", query = "SELECT a FROM AppMedia a WHERE a.edition = :edition")
    , @NamedQuery(name = "AppMedia.findByDirector", query = "SELECT a FROM AppMedia a WHERE a.director = :director")
    , @NamedQuery(name = "AppMedia.findByDuration", query = "SELECT a FROM AppMedia a WHERE a.duration = :duration")
    , @NamedQuery(name = "AppMedia.findByArtist", query = "SELECT a FROM AppMedia a WHERE a.artist = :artist")
    , @NamedQuery(name = "AppMedia.findByAlbum", query = "SELECT a FROM AppMedia a WHERE a.album = :album")
    , @NamedQuery(name = "AppMedia.findByTrackNumber", query = "SELECT a FROM AppMedia a WHERE a.trackNumber = :trackNumber")})
public class AppMedia implements Serializable {

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
    

    public AppMedia() {
    }

    public AppMedia(Integer mediaId) {
        this.mediaId = mediaId;
    }

    public AppMedia(Integer mediaId, String title, String type) {
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
        if (!(object instanceof AppMedia)) {
            return false;
        }
        AppMedia other = (AppMedia) object;
        if ((this.mediaId == null && other.mediaId != null) || (this.mediaId != null && !this.mediaId.equals(other.mediaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbClasses.AppMedia[ mediaId=" + mediaId + " ]";
    }
    
    public String getCreator(){
    if(MediaType.LITERATURE.getValue().equals(this.type)){
        return this.author;
    }
    if(MediaType.MOVIE.getValue().equals(this.type)){
        return this.director;
    }
    if(MediaType.MUSIC.getValue().equals(this.type)){
        return this.artist;
    }
    return null;
}
    
}
