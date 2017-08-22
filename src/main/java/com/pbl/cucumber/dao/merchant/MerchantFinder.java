package com.pbl.cucumber.dao.merchant;

import com.pbl.cucumber.beans.Merchant;

/**
 * Created by Steven Satelle on 08/08/2017.
 */
public interface MerchantFinder {

    Merchant findMerchant(String merchantName);
}
