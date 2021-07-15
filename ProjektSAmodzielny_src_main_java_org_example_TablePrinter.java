package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class TablePrinter<T> {

    private static final int MAX_COLUMN_SIZE = 15;
    private static final int MAX_TABLE_SIZE = 100;
    private List<T> data;
    private List<ColumnPrinter> columns = new ArrayList<>();

    public TablePrinter withData(List<T> list) {
        // only first MAX_TABLE_SIZE rows are printed
        data = list.subList(0, Math.min(list.size(), MAX_TABLE_SIZE));
        return this;
    }

    public TablePrinter withColumn(String headerName, Function<T, String> getValueFunction) {
        columns.add(new ColumnPrinter(headerName, getValueFunction));
        return this;
    }

    public void printTable() {
        System.out.println(generateTable());
    }

    public String generateTable() {
        StringBuilder stringBuilder = new StringBuilder();
        generateSeparator(stringBuilder);
        generateHeaderRow(stringBuilder);
        generateSeparator(stringBuilder);
        for (T row : data) {
            generateRow(stringBuilder, row);
        }
        generateSeparator(stringBuilder);
        return stringBuilder.toString();
    }

    private void generateSeparator(StringBuilder stringBuilder) {
        stringBuilder.append("+");
        for (int columnIndex = 0; columnIndex < columns.size(); columnIndex++) {
            for (int i = 0; i < MAX_COLUMN_SIZE; i++) {
                stringBuilder.append("-");
            }
            stringBuilder.append("+");
        }
        stringBuilder.append(System.lineSeparator());
    }

    private void generateHeaderRow(StringBuilder stringBuilder) {
        stringBuilder.append("|");
        for (ColumnPrinter columnPrinter : columns) {
            stringBuilder.append(decorateValue(columnPrinter.header));
            stringBuilder.append("|");
        }
        stringBuilder.append(System.lineSeparator());

    }

    private void generateRow(StringBuilder stringBuilder, T dataRow) {
        stringBuilder.append("|");
        for (ColumnPrinter columnPrinter : columns) {
            stringBuilder.append(decorateValue((String) columnPrinter.getValueFunction.apply(dataRow)));
            stringBuilder.append("|");
        }
        stringBuilder.append(System.lineSeparator());

    }


    private String decorateValue(String header) {
        return String.format("%-" + MAX_COLUMN_SIZE + "s", header).substring(0, MAX_COLUMN_SIZE);
    }


    private static class ColumnPrinter {
        private String header;
        private Function getValueFunction;

        public ColumnPrinter(String header, Function getValueFunction) {
            this.header = header;
            this.getValueFunction = getValueFunction;

        }

    }

}