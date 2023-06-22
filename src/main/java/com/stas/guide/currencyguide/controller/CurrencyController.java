package com.stas.guide.currencyguide.controller;

import com.stas.guide.currencyguide.data.CurrencyDto;
import com.stas.guide.currencyguide.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.stas.guide.currencyguide.service.CurrencyServiceImpl.DEFAULT_NAME_CURRENCY_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/guide/currency")
public class CurrencyController {

    private final CurrencyService currencyService;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<CurrencyDto> getByID(@PathVariable("id") Long id) {

        var result = currencyService.getByID(id);

        if (DEFAULT_NAME_CURRENCY_VALUE.equals(result.getCurrencyName())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    public ResponseEntity<List<CurrencyDto>> getAll() {

        return new ResponseEntity<>(currencyService.getAll(), HttpStatus.OK);

    }

}
