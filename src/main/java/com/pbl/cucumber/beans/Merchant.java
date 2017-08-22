package com.pbl.cucumber.beans;

import lombok.Getter;

/**
 * Created by Steven Satelle on 08/08/2017.
 */
public class Merchant {
    @Getter
    private String merch_id;
    @Getter
    private String merch_name;
    @Getter
    private String feed_host;
    @Getter
    private int feed_port;
    @Getter
    private String feed_user;
    @Getter
    private String feed_password;
    @Getter
    private String feed_remote_directory;
    @Getter
    private String feed_inventory_directory;

    public Merchant(String merchant_id, String name) {
        this.merch_id = merchant_id;
        this.merch_name = name;
    }


    public Merchant(
            String merchant_id,
            String name,
            String data_feed_host,
            int data_feed_port,
            String data_feed_user,
            String data_feed_password,
            String data_feed_remote_directory,
            String data_feed_inventory_directory
            ) {
        this.merch_id = merchant_id;
        this.merch_name = name;
        this.feed_host = data_feed_host;
        this.feed_port = data_feed_port;
        this.feed_user = data_feed_user;
        this.feed_password = data_feed_password;
        this.feed_remote_directory = data_feed_remote_directory;
        this.feed_inventory_directory = data_feed_inventory_directory;
    }
}
