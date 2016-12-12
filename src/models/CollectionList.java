/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import Enums.MediaFormat;
import Enums.MediaType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dbClasses.AppMedia;
import dbClasses.AppMediaJpaController;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ivan
 */
public class CollectionList
{

    private ArrayList<Collection> allCollections = new ArrayList<>();
    private String FileName = "collections.json";

    public CollectionList() throws IOException
    {
        this.readCollectionsFile();
        if (allCollections.isEmpty() || allCollections == null)
        {
            this.createInitialCollection();
            this.writeCollectionsFile();
            this.readCollectionsFile();
        }
    }

    private void writeCollectionsFile() throws IOException
    {
        Writer writer = new FileWriter(FileName);

        Gson gson = new GsonBuilder().create();
        gson.toJson(getAllCollections(), writer);

        writer.close();
    }

    private void readCollectionsFile()
    {
        try (Reader reader = new FileReader((FileName)))//getResourceAsFile("/collections.json"), "UTF-8"))
        {
            Gson gson = new GsonBuilder().create();
            @SuppressWarnings("serial")
            java.lang.reflect.Type type = new TypeToken<ArrayList<Collection>>(){}.getType();
            allCollections = gson.fromJson(reader, type);
        } catch (UnsupportedEncodingException ex)
        {
            ex.printStackTrace();
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    private void createInitialCollection()
    {
        Collection col = new Collection("General", "A collection of all existing media items");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HomeLibraryManagerPU");
        AppMediaJpaController jpaMedia = new AppMediaJpaController(emf);
        List<AppMedia> Media = jpaMedia.findAppMediaEntities();
        ArrayList<Media> mediaCol = new ArrayList<>();

        for (AppMedia m : Media)
        {
            mediaCol.add(transferToMediaModel(m));
        }

        col.setItems(mediaCol);
        getAllCollections().add(col);
    }

    //Method that converts database model into program model for display in table
    private Media transferToMediaModel(AppMedia dbMedia)
    {
        if (MediaType.valueOf(dbMedia.getType()) == MediaType.Literature)
        {
            Literature literature = new Literature(dbMedia.getMediaId(), dbMedia.getTitle(), MediaType.valueOf(dbMedia.getType()), MediaFormat.valueOf(dbMedia.getFormat()), dbMedia.getUserId(), dbMedia.getAuthor());
            literature.setGenre(dbMedia.getGenre());
            literature.setEdition(dbMedia.getEdition());
            literature.setLoanedDate(dbMedia.getLoanedDate());
            literature.setLoanedTo(dbMedia.getLoanedTo());
            literature.setLocation(dbMedia.getLocation());
            literature.setPublisher(dbMedia.getPublisher());
            if (dbMedia.getRating() != null)
            {
                literature.setRating(dbMedia.getRating());
            }
            literature.setVersion(dbMedia.getVersion());
            literature.setVolume(dbMedia.getVolume());
            if (dbMedia.getYear() != null)
            {
                literature.setYear(dbMedia.getYear());
            }
            return literature;
        } else if (MediaType.valueOf(dbMedia.getType()) == MediaType.Movie)
        {
            Movie movie = new Movie(dbMedia.getMediaId(), dbMedia.getTitle(), MediaType.valueOf(dbMedia.getType()), MediaFormat.valueOf(dbMedia.getFormat()), dbMedia.getUserId(), dbMedia.getDirector());
            movie.setDuration(dbMedia.getDuration());
            movie.setGenre(dbMedia.getGenre());
            movie.setLoanedDate(dbMedia.getLoanedDate());
            movie.setLoanedTo(dbMedia.getLoanedTo());
            movie.setLocation(dbMedia.getLocation());
            if (dbMedia.getRating() != null)
            {
                movie.setRating(dbMedia.getRating());
            }
            if (dbMedia.getYear() != null)
            {
                movie.setYear(dbMedia.getYear());
            }
            return movie;
        } else if (MediaType.valueOf(dbMedia.getType()) == MediaType.Music)
        {
            Music music = new Music(dbMedia.getMediaId(), dbMedia.getTitle(), MediaType.valueOf(dbMedia.getType()), MediaFormat.valueOf(dbMedia.getFormat()), dbMedia.getUserId(), dbMedia.getArtist());
            return music;
        }

        return null;
    }

    public ArrayList<Collection> getAllCollections()
    {
        return allCollections;
    }
}
