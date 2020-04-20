package exceptions.examples;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Game {

    private static final String DATE = "yyy/MM/dd HH:mm:ss";
    private static final String NAME_SCORE = "score.txt";
    private static final String NAME_PROGRESS = "progress.txt";
    private static final String NAME_STATISTICS = "statistics.txt";

    public void saveGame() {
        try {
            saveProgress();
            saveScore();
            saveStatistics();
        } catch(SaveProgressException ex){
            System.err.println("Can't save Progress " + ex.getMessage());
        } catch (SaveScoreException ex) {
            ex.printStackTrace();
        } catch (SaveStatisticsException ex) {
            System.err.println("Can't save Statistics " + ex.getMessage());
        }
    }

    private void saveStatistics() throws SaveStatisticsException {
        FileWriter writer = null;
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE);

            writer = new FileWriter(NAME_STATISTICS,true);

            writer.append("Guardado: ").append(now.format(formatter)).append(System.lineSeparator());

            writer.close();
        } catch (IOException e) {
            throw new SaveStatisticsException();
        } finally {
            if(writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {

                }
            }
        }
    }

    private void saveScore() throws SaveScoreException {
        FileWriter writer = null;
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE);

            writer = new FileWriter(NAME_SCORE,true);

            writer.append("Guardado: ").append(now.format(formatter)).append(System.lineSeparator());

            writer.close();

            throw new IOException("IO exception de prueba");
        } catch (IOException e) {
            throw new SaveScoreException("Send Help", e);
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
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE);

            writer = new FileWriter(NAME_PROGRESS,true);

            writer.append("Guardado: ").append(now.format(formatter)).append(System.lineSeparator());

            writer.close();
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
