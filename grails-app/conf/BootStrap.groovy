import net.isammoc.gbj.Card


class BootStrap {

	def init = { servletContext -> createCardsIfNeeded() }
	def destroy = {
	}

	void createCardsIfNeeded() {
		['s', 'h', 'd', 'c'].each { suit ->
			[
				'A',
				'K',
				'Q',
				'J',
				'9',
				'8',
				'7',
				'6',
				'5',
				'4',
				'3',
				'2'
			].each { rank ->
				if(!Card.findByRankAndSuit(rank,suit)){
					def card = new Card(name:"$rank$suit",rank:rank,suit:suit).save()
				}
			}
		}
	}
}
