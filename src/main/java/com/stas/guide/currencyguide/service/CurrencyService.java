package com.stas.guide.currencyguide.service;

import com.stas.guide.currencyguide.data.CurrencyDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CurrencyService {

    CurrencyDto getByID(Long id);

    List<CurrencyDto> getAll();

}
