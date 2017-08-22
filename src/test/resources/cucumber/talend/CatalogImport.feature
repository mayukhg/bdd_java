Feature: Talend
  The Rakuten marketplace is a japanese marketplace and ebags is one of the merchants

  @wip
  Scenario Outline: I can upload a merchant catalog file to a marketplace
    Given a <merchant> is setup on <marketPlace>
    When I upload a <merchant> catalog feed
    Then the <marketPlace> <merchant> catalog is updated

    Examples:
      | marketPlace | merchant |
      | rakuten     | macy     |
#      | myntra      | ebags    |
#      | tmall       | saks     |

#  Scenario: uploaded catalog generated the correct price
#    Given I upload an ebags catalog feed
#    When I check the generated prices
#    Then they will be in JPY
#    And the prices will be correct
#
#  Scenario: Restricted skus do not appear in the rakuten catalog
#    Given I have an ebags catalog file containing restricted items
#    When I upload the catalog file
#    Then the rakuten ebags catalog will not contain the restricted items
#
#
#  Scenario: Invalid catalogs files are handled correctly
#
#  Scenario: invalid inventory files are handled correctly
#
#  Scenario: using the wrong merchant for upload is handled correctly
#
#  Scenario:

#      orders
#      products
#      parcels
#      inventory
#      catalog
