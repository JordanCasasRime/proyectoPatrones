package Class;

import Interfaces.IClone;

public class Publication implements IClone {

    private String title;
    private String description;
    private String date;
    private String categoria;
    private int publicationId;

    public Publication(String title, String description, String date, String categoria, int publicationId) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.categoria = categoria;
        this.publicationId = publicationId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String Title) {
        this.title = Title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String Date) {
        this.date = Date;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(int publicactionId) {
        this.publicationId = publicactionId;
    }
    
    @Override
    public IClone clone() {
        IClone publication = new Publication(this.title, this.description, this.date, this.categoria, this.publicationId);
        return publication;
    }
    
}
