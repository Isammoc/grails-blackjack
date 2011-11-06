import net.isammoc.gbj.Card
import net.isammoc.gbj.auth.Role


class BootStrap {

	def init = { servletContext ->
		createCardsIfNeeded()
		createRolesIfNeeded()
	}
	
	def destroy = {
	}

	void createRolesIfNeeded() {
		if (!Role.findByAuthority("ROLE_USER")) {
			def userRole = new Role(
					authority: "ROLE_USER",
					description: "Registered user").save()
		}
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
