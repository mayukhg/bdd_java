package com.pbl.cucumber;

import com.pbl.cucumber.beans.Merchant;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Data
@Component
public class SharedData {

    private Map<String, Merchant> merchants = new HashMap<>();

    public void addMerchant(String key, Merchant m) {
        merchants.put(key, m);
    }

    public Merchant getMerchant(String key) {
        return merchants.get(key);
    }


}
