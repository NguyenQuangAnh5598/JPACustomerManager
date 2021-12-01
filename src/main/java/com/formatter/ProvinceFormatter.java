package com.formatter;

import com.model.Provinces;
import com.service.provinceService.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class ProvinceFormatter implements Formatter<Provinces> {

    private IProvinceService provinceService;

    @Autowired
    public ProvinceFormatter(IProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @Override
    public Provinces parse(String text, Locale locale) throws ParseException {
        Optional<Provinces> provinceOptional = provinceService.findById(Long.parseLong(text));
        return provinceOptional.orElse(null);
    }

    @Override
    public String print(Provinces object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
