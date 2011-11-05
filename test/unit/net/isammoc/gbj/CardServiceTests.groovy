package net.isammoc.gbj

import grails.test.*

class CardServiceTests extends GrailsUnitTestCase {
	def cardService
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testScoreToDisplay() {
		def cardService = new CardService()
		def ace = new Card(name:"Ah",rank:"A",suit:"h")
		def jack = new Card(name:"Jc",rank:"J",suit:"c")
		def nine = new Card(name:"9s",rank:"9",suit:"s")
		assert "1 / 11" == cardService.scoreToDisplay([ace]) 
		assert "Blackjack" == cardService.scoreToDisplay([ace, jack])
		assert "10 / 20" == cardService.scoreToDisplay([ace, nine])
		assert "11 / 21" == cardService.scoreToDisplay([ace,ace,nine])
    }
}
