package uk.ac.ucl.model;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class DataLoader {
    public DataFrame loadData(String fileName)
    {
        DataFrame dataFrame = new DataFrame();

        try (Reader reader = new FileReader(fileName);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader()))  // The first row of the file contains the column headers, so is not actual data.
        {
            int numberOfColumns = csvParser.getHeaderMap().size();
            for (String columnName : csvParser.getHeaderNames())
            {
                dataFrame.addColumn(new Column(columnName));
            }

            for (CSVRecord csvRecord : csvParser)
            {
                for (String columnName : csvParser.getHeaderNames())
                {
                    dataFrame.addValue(columnName, csvRecord.get(columnName));
                }
            }
        } catch (IOException e)
        {
//            e.printStackTrace();
            System.out.println("File not found");
            //If file not found, request the user to input the correct file name and try again
        }
        return dataFrame;
    }
}


