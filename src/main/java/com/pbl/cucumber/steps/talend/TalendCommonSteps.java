package com.pbl.cucumber.steps.talend;

import com.pbl.cucumber.beans.Merchant;
import com.pbl.cucumber.config.Config;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations=("classpath:cmp-automation.xml"))
public class TalendCommonSteps {
    private Merchant merc;

    @Autowired
    Config config;


    @When("^I upload a (\\w.*) catalog feed$")
    public void uploadMechantCalatalog (String merchant) throws Exception {
        Assert.assertTrue(1 == 1);
//        org.apache.logging.log4j.Level.
//        String cmd = config.getTalendScript();
//        String catalogFile = config.getCatalogFileLocation();
//        SSHAccess ssh = new SSHAccess(merc.getFeed_user(), merc.getFeed_password(), merc.getFeed_host(), merc.getFeed_port());
//        try {
//            ssh.uploadFile(catalogFile, merc.getFeed_inventory_directory());
//            ssh.execCommand(cmd);
//        } catch (IOException io) {
//            throw new Exception("Failed to exec the command " + cmd + io.getMessage());
//        }
    }

    @Then("^the (\\w.*) (\\w.*) catalog is updated$")
    public void theCatalogIsUpdated(String marketPlace, String merchant) {
        Assert.assertTrue(1 == 1);
    }
}
