package com.stas.guide.currencyguide;

import com.stas.guide.currencyguide.data.CurrencyDto;
import com.stas.guide.currencyguide.data.CurrencyEntity;

public class Utils {

    public static CurrencyDto currencyDtoFromEntity(CurrencyEntity currencyEntity) {
        return new CurrencyDto(currencyEntity.getNameCurrency());
    }

}
