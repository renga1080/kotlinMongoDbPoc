package com.renga.kotlinmongogradlepoc.service.impl

import com.renga.kotlinmongogradlepoc.model.UserWrapper
import com.renga.kotlinmongogradlepoc.model.db.User
import com.renga.kotlinmongogradlepoc.repositories.UserRepository
import com.renga.kotlinmongogradlepoc.service.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserService {

    private val log: Logger = LoggerFactory.getLogger(UserServiceImpl::class.java)

    override
    fun addUser(user: User): User {
        val user = userRepository.save(user)
        log.info("User saved in database :{}", user)
        return user
    }

    override fun getAllUser(): List<User> {
        return userRepository.findAll()
    }

    override
    fun findUser(id: String): User {
        return userRepository.findById(id).orElseGet(null)
    }

    override
    fun removeUser(id: String) {
        return userRepository.deleteById(id)
    }

    override
    fun updateUser(userWrapper: UserWrapper): User {
        val user = findUser(userWrapper.id)
        if(Objects.isNull(user)){
            log.error("User id: {} not found in database. Cannot update", userWrapper.id)
            throw IllegalArgumentException("User id ${userWrapper.id} not found in database. Cannot update")
        }
        user.name = userWrapper.name
        return userRepository.save(user)
    }
}