package net.isammoc.gbj

import grails.test.*

class CardServiceTests extends GrailsUnitTestCase {

	def cardService
	def ace = new Card(name:"Ah",rank:"A",suit:"h")
	def jack = new Card(name:"Jc",rank:"J",suit:"c")
	def nine = new Card(name:"9s",rank:"9",suit:"s")

	protected void setUp() {
		super.setUp()
		cardService = new CardService()
	}

	protected void tearDown() {
		super.tearDown()
	}

	void testScoreToDisplay() {
		assert "1 / 11" == cardService.scoreToDisplay([ace])
		assert "Blackjack" == cardService.scoreToDisplay([ace, jack])
		assert "10 / 20" == cardService.scoreToDisplay([ace, nine])
		assert "11 / 21" == cardService.scoreToDisplay([ace, ace, nine])
	}

	void testCanCard() {
		// Possible card
		assert cardService.canCard([jack,nine])
		assert cardService.canCard([ace, ace, nine])
		
		// Impossible card
		assert !cardService.canCard([jack,jack,jack])
		assert !cardService.canCard([ace, jack])
	}
}
