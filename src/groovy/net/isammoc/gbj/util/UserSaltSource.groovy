package net.isammoc.gbj.util

import org.springframework.security.authentication.dao.ReflectionSaltSource
import org.springframework.security.core.userdetails.UserDetails

class UserSaltSource extends ReflectionSaltSource {
   
    Object getSalt(UserDetails user) {
        user[userPropertyToUse]
    }
}