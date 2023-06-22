package com.stas.guide.currencyguide.service;

import com.stas.guide.currencyguide.Utils;
import com.stas.guide.currencyguide.data.CurrencyDto;
import com.stas.guide.currencyguide.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {
    public static final String DEFAULT_NAME_CURRENCY_VALUE = "UNKNOWN";
    private final CurrencyRepository currencyRepository;

    @Override
    public CurrencyDto getByID(Long id) {
        return currencyRepository.findById(id).map(Utils::currencyDtoFromEntity).orElseGet(this::getDefaultCurrencyDto);
    }

    @Override
    public List<CurrencyDto> getAll() {
        return currencyRepository.findAll().stream().map(Utils::currencyDtoFromEntity).collect(Collectors.toList());
    }

    private CurrencyDto getDefaultCurrencyDto() {
        return new CurrencyDto(DEFAULT_NAME_CURRENCY_VALUE);
    }
}
