import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }
    
    /**
     * List all files
     */
    public void listAllFiles() {
        int index = 0;
        int number = 1;
        while(index < files.size()) {
            System.out.println(number + ". " + files.get(index));
            index++;
            number = number + 1;
        }
    }
    
    /**
     * Search file with a String
     */
    public void listMatching(String searchString) {
        int foundSongs = 0;
        for (String filename : files) {
            if (filename.contains(searchString)) {
                System.out.println(filename);
                foundSongs = foundSongs + 1;
            }
        }
        if (foundSongs == 0) {
            System.out.println("No se ha encontrado ningún archivo con ese nombre");
        }
    }
    
    /**
     * Play first seconds of a song
     */
    public void playSamplesArtist(String artist) {
        for (String filename : files) {
            if (filename.contains(artist)) {
                player.playSample(filename);
            }
        }
    }
    
    /**
     * Localiza el índice del primer archivo que se corresponde con
     * la cadena indicada.
     * @param searchString La cadena que hay que buscar.
     * @return El índice de la primera aparición o -1 si
     * no se encuentra ninguna correspondencia
     */
    public int findFirst(String searchString) {
        int index = 0;
        int result = -1;
        boolean notFound = true;
        while (notFound && (index < files.size())) {
            if (files.get(index).contains(searchString)) {
                notFound = false;
            }
            else {
                index = index + 1;
            }
        }
        if (index < files.size()) {
            result = index;
        }
        return result;
    }
    
    //Si se quiere remover una canción con un bucle for-each no 
    //será posible ya que daría error
}
