package com.suncode;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/")
@Log4j2
public class MainController {


    private final RowRepository rowRepository;

    public MainController(RowRepository rowRepository) {
        this.rowRepository = rowRepository;
    }

    @GetMapping("getColumns")
    public List<String> getColumns(){
        return Arrays.stream(Row.class.getDeclaredFields()).map(Field::getName).filter(i -> !i.equals("id")).collect(Collectors.toList());
    }

    @GetMapping("getRepetitive")
    public List<Row> getRowWithRepetitiveValue(@RequestParam String column){
        List<Row> list = new ArrayList<>();
        List<Row> dbRowList = rowRepository.findAll();
        switch (column){
            case "kolumna1":
                for(Row row : dbRowList){
                    if(Collections.frequency(dbRowList.stream().map(Row::getColumn1).collect(Collectors.toList()), row.getColumn1()) > 1){
                        list.add(row);
                        log.info("Added: " + row);
                    }
                }
                break;
            case "kolumna2":
                for(Row row : dbRowList){
                    if(Collections.frequency(dbRowList.stream().map(Row::getColumn2).collect(Collectors.toList()), row.getColumn2()) > 1){
                        list.add(row);
                        log.info("Added: " + row);
                    }
                }
                break;
            case "kolumna3":
                for(Row row : dbRowList){
                    if(Collections.frequency(dbRowList.stream().map(Row::getColumn3).collect(Collectors.toList()), row.getColumn3()) > 1){
                        list.add(row);
                        log.info("Added: " + row);
                    }
                }
                break;
            case "kolumna4":
                for(Row row : dbRowList){
                    if(Collections.frequency(dbRowList.stream().map(Row::getColumn4).collect(Collectors.toList()), row.getColumn4()) > 1){
                        list.add(row);
                        log.info("Added: " + row);
                    }
                }
                break;
            default:
                log.error("There is not such a column as: " + column);

        }
        return list;
    }

    @GetMapping("getNotRepetitive")
    public List<Row> getRowWithNotRepetitiveValue(@RequestParam String column){
        List<Row> list = new ArrayList<>();
        List<Row> dbRowList = rowRepository.findAll();
        switch (column){
            case "kolumna1":
                for(Row row : dbRowList){
                    if(Collections.frequency(dbRowList.stream().map(Row::getColumn1).collect(Collectors.toList()), row.getColumn1()) <= 1){
                        list.add(row);
                        log.info("Added: " + row);
                    }
                }
                break;
            case "kolumna2":
                for(Row row : dbRowList){
                    if(Collections.frequency(dbRowList.stream().map(Row::getColumn2).collect(Collectors.toList()), row.getColumn2()) <= 1){
                        list.add(row);
                        log.info("Added: " + row);
                    }
                }
                break;
            case "kolumna3":
                for(Row row : dbRowList){
                    if(Collections.frequency(dbRowList.stream().map(Row::getColumn3).collect(Collectors.toList()), row.getColumn3()) <= 1){
                        list.add(row);
                        log.info("Added: " + row);
                    }
                }
                break;
            case "kolumna4":
                for(Row row : dbRowList){
                    if(Collections.frequency(dbRowList.stream().map(Row::getColumn4).collect(Collectors.toList()), row.getColumn4()) <= 1){
                        list.add(row);
                        log.info("Added: " + row);
                    }
                }
                break;
            default:
                log.error("There is not such a column as: " + column);

        }
        return list;
    }
}
