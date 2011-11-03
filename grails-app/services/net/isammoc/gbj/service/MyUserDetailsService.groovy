package net.isammoc.gbj.service

import org.codehaus.groovy.grails.plugins.springsecurity.GormUserDetailsService
import org.codehaus.groovy.grails.plugins.springsecurity.GrailsUser
import org.springframework.security.core.userdetails.UserDetails

class MyUserDetailsService extends GormUserDetailsService {

	protected UserDetails createUserDetails(user, Collection authorities) {
		new MyUserDetails(
				(GrailsUser) super.createUserDetails(user, authorities), user.salt
				)
	}
}

class MyUserDetails extends GrailsUser {

	public final String salt

	MyUserDetails(GrailsUser base, String salt) {
		super(
		base.username,
		base.password,
		base.enabled,
		base.accountNonExpired,
		base.credentialsNonExpired,
		base.accountNonLocked,
		base.authorities,
		base.id)

		this.salt = salt;
	}
}