package com.pbl.cucumber.steps.merchants;


import com.pbl.cucumber.SharedData;
import com.pbl.cucumber.beans.Merchant;
import com.pbl.cucumber.config.Config;
import com.pbl.cucumber.dao.merchant.MerchantFinder;
import com.pbl.cucumber.ssh.SSHAccess;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations=("classpath:cmp-automation.xml"))
public class MerchantCommonSteps {

    @Autowired
    MerchantFinder m;

    @Autowired
    Config config;

    @Autowired
    SharedData sharedData;

    private SSHAccess sshAccess;
    private Merchant merchant;

    @Given("^a (\\w.*) is setup on (\\w.*)$")
    public void merchantSetupOnMarketplace(String merchant, String marketPlace) {
        sharedData.addMerchant(merchant, m.findMerchant(getMerchID(merchant)));
        Assert.assertTrue("The merchant " + merchant + "cannot be found",sharedData.getMerchant(merchant) != null);
    }

    @When("I log in to the ftp server using the (\\w.*) credentials")
    public void logIntoFTPLocation (String merchantID) throws Exception {
        Assert.assertTrue(1 == 1);
        merchant = sharedData.getMerchant(merchantID);
        sshAccess = new SSHAccess(merchant.getFeed_user(), merchant.getFeed_password(), merchant.getFeed_host(), merchant.getFeed_port());
    }

    @Then("I can see the expected directories")
    public void canListFTPDirectories() {
        sshAccess.sftpFolderCheck(merchant.getFeed_remote_directory());
        sshAccess.sftpFolderCheck(merchant.getFeed_inventory_directory());
    }


    private String getMerchID(String m) {
        String merch;
        switch (m.toLowerCase()) {
            case "ebags": merch = "mebg";
                break;
            case "macy": merch = "macy";
                break;
            case "saks": merch = "saks";
                break;
            case "qa": merch = "qamc";
                break;
            default: merch = "";
                break;
        }
        return merch;
    }
}
