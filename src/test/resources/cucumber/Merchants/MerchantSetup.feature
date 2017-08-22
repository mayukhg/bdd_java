Feature: Merchant Setup
  When a new merchant is setup on Complete Marketplace, there are certain entities which need to exist
  There needs to be:
  * Ftp logins configured
  * Ftp folders in place
  * Certain mapping files need to be in place

  Scenario Outline: A Merchant can correctly log into their FTP locations
    Given a <merchant> is setup on <marketPlace>
    When I log in to the ftp server using the <merchant> credentials
    Then I can see the expected directories

    Examples:
      | marketPlace | merchant |
      | rakuten     | macy     |
      | myntra      | ebags    |
      | tmall       | saks     |
      | myntra      | qa       |

