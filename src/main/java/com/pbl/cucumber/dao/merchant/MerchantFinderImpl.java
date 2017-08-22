package com.pbl.cucumber.dao.merchant;

import com.pbl.cucumber.dao.Finder;
import com.pbl.cucumber.beans.Merchant;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static pbl.dao.tables.PblMrcMerchant.PBL_MRC_MERCHANT;



import javax.sql.DataSource;

/**
 * Created by Steven Satelle on 08/08/2017.
 */
@Component
public class MerchantFinderImpl extends Finder implements MerchantFinder {

    @Autowired
    public MerchantFinderImpl(DataSource dataSource) {
        super(dataSource);
    }

    public Merchant findMerchant(String merchantName ) {
        return find((dslContext) -> dslContext
                .select(PBL_MRC_MERCHANT.MERCHANT_ID,
                        PBL_MRC_MERCHANT.NAME,
                        PBL_MRC_MERCHANT.DATA_FEED_HOST,
                        PBL_MRC_MERCHANT.DATA_FEED_PORT,
                        PBL_MRC_MERCHANT.DATA_FEED_USER,
                        PBL_MRC_MERCHANT.DATA_FEED_PASSWORD,
                        PBL_MRC_MERCHANT.DATA_FEED_REMOTE_DIRECTORY,
                        PBL_MRC_MERCHANT.DATA_FEED_INVENTORY_DIRECTORY
                ).from(PBL_MRC_MERCHANT)
                .where(PBL_MRC_MERCHANT.MERCHANT_ID.equalIgnoreCase(merchantName))
                .limit(1).fetch()).into(Merchant.class).get(0);
    }

}
