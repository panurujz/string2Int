package com.example.string2Int.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class String2IntController {

    @GetMapping("/string2Int/{stringInput}")
    public String string2Int(@PathVariable String stringInput) {
        String number = getNumberFromString(stringInput);
        return String.format("The number is %s", number);
    }

    private String getNumberFromString(String input) {

        String result = "";

        try {

            StringBuilder number = new StringBuilder();
            for (char item : input.toCharArray()) {
                if (item >= '0' && item <= '9') {
                    number.append(item);
                }
            }

            result = number.toString();
            log.info("number is:{}", number.toString());

        } catch (NumberFormatException ex) {
            log.error(ex.getMessage(), ex);
        }

        return result;
    }
}
