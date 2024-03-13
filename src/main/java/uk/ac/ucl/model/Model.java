package uk.ac.ucl.model;

import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Model {
    // The example code in this class should be replaced by your Model class code.
    // The data should be stored in a suitable data structure.

    private DataFrame data;

    // This method illustrates how to read csv data from a file.
    // The data files are stored in the root directory of the project (the directory your project is in),
    // in the directory named data.
    public void readFile(String fileName) {
      DataLoader dataLoader = new DataLoader();
      this.data = dataLoader.loadData(fileName);
    }

    public List<List<String>> getTable()
    {
      List<List<String>> table = new ArrayList<>();
      for (String columnName : data.getColumnNames())
      {
        table.add(get(columnName));
      }
      return table;
    }

    public List<String> get(String columnName)
    {
        List<String> column = new ArrayList<>();
        for (int i = 0; i < data.getRowCount(); i++)
        {
            column.add(data.getValue(columnName, i));
        }
        return column;
    }

    public List<String> getPatientNames()
    {
      List<String> patient_names = new ArrayList<>();
      for (int i = 0; i < data.getRowCount(); i++) {
        patient_names.add(data.getValue("FIRST", i) + " " + data.getValue("LAST", i));
      }
      return patient_names;
    }

    public Set<Integer> search(String keyword) {
        Set<Integer> matchingRowNumbers = new HashSet<>();

        for (List<String> column : this.getTable()) {
            List<Integer> matchingIndexes = IntStream.range(0, column.size())
                    .filter(i -> column.get(i).toLowerCase().contains(keyword.toLowerCase()))
                    .boxed()
                    .toList();

            matchingRowNumbers.addAll(matchingIndexes);
        }
        return matchingRowNumbers;
    }

    public List<List<String>> searchTable(String keyword) {
            Set <Integer> matchingRowNumbers = search(keyword);
            List<List<String>> Search_table;
            Search_table = this.getTable().stream()
                    .map(column ->
                            IntStream.range(0, column.size())
                                    .filter(matchingRowNumbers::contains)
                                    .mapToObj(column::get)
                                    .collect(Collectors.toList()))
                    .toList();
            return Search_table;
    }

    // This also returns dummy data. The real version should use the keyword parameter to search
    // the data and return a list of matching items.
    public List<String> searchFor(String keyword) {
      return List.of("Search keyword is: " + keyword, "result1", "result2", "result3");
    }
}
