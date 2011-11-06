package net.isammoc.gbj

class UserFilters {
	
	def springSecurityService
	
    def filters = {
        all(controller:'*', action:'*') {
            before = {
                
            }
            after = { model ->
				if(model == null) {
					model = [:]
				}
				model.currentUser = springSecurityService.currentUser
            }
            afterView = {
                
            }
        }
    }
    
}
