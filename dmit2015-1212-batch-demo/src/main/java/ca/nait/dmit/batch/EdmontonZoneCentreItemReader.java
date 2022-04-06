package ca.nait.dmit.batch;

import jakarta.batch.api.BatchProperty;
import jakarta.batch.api.chunk.AbstractItemReader;
import jakarta.batch.runtime.context.JobContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.nio.file.Paths;

@Named
public class EdmontonZoneCentreItemReader extends AbstractItemReader {

    @Inject
    private JobContext _jobContext;

    @Inject
    @BatchProperty(name = "input_file")
    private String _inputFile;

    private BufferedReader _reader;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        super.open(checkpoint);

        _reader = new BufferedReader(new FileReader(Paths.get(_inputFile).toFile()));
    }

    @Override
    public Object readItem() throws Exception {
        try {
            String line = _reader.readLine();
            return line;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
