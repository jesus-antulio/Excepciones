package exceptions.examples;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Game {
    public void saveGame() {
        try {
            saveProgress();
            saveScore();
            saveStatistics();
        } catch(SaveProgressException ex){
            System.err.println("Can't save Progress" + ex.getMessage());
        } catch (SaveScoreException ex) {
            System.err.println("Can't save Score" + ex.getMessage());
        }
    }

    private void saveStatistics() {

    }

    private void saveScore() throws SaveScoreException {
        FileWriter writer = null;
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");

            writer = new FileWriter("score.txt",true);

            writer.append("Guardado: ").append(now.format(formatter)).append(System.lineSeparator());
        } catch (IOException e) {
            throw new SaveScoreException();
        } finally {
            if(writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {

                }
            }
        }
    }

    private void saveProgress() throws SaveProgressException {
        FileWriter writer = null;
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");

            writer = new FileWriter("progress.txt",true);

            writer.append("Guardado: ").append(now.format(formatter)).append(System.lineSeparator());
        } catch (IOException e) {
            throw new SaveProgressException();
        } finally {
            if(writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {

                }
            }
        }
    }
}
