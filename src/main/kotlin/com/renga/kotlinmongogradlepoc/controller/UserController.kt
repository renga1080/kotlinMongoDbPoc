package com.renga.kotlinmongogradlepoc.controller

import com.renga.kotlinmongogradlepoc.endpoint.UserControllerEndpoint
import com.renga.kotlinmongogradlepoc.model.UserWrapper
import com.renga.kotlinmongogradlepoc.model.db.User
import com.renga.kotlinmongogradlepoc.service.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.util.StringUtils
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class UserController(val userService: UserService): UserControllerEndpoint {

    private val log: Logger = LoggerFactory.getLogger(UserController::class.java)

    override
    fun addUser(user: User): ResponseEntity<User> {
        log.info("Start adding user: {}", user)
        return try{
            val response = userService.addUser(user)
            ResponseEntity(response, HttpStatus.CREATED)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    override
    fun getAllUser(): ResponseEntity<List<User>> {
        log.info("Start getting all the user")
        return try{
            val response = userService.getAllUser()
            ResponseEntity(response, HttpStatus.OK)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    override
    fun getUserById(userId: String): ResponseEntity<User> {
        log.info("Start getting finding userId: {}", userId)
        return try{
            val user: User = userService.findUser(userId)
            if(Objects.isNull(user)){
                log.error("Given user id: {} not found", userId)
                return ResponseEntity(HttpStatus.BAD_REQUEST)
            }
            ResponseEntity(user, HttpStatus.OK)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    override
    fun deleteUserById(userId: String): ResponseEntity<Void> {
        log.info("Start deleting userId: {}", userId)
        return try{
            userService.removeUser(userId)
            ResponseEntity(HttpStatus.OK)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    override
    fun updateUser(userWrapper: UserWrapper): ResponseEntity<User> {
        log.error("Update UserWrapper : {} ", userWrapper)
        return try{
            if(Objects.isNull(userWrapper) || StringUtils.isEmpty(userWrapper)){
                log.error("Invalid user id or request body. Cannot update user")
                return ResponseEntity(HttpStatus.BAD_REQUEST)
            }
            val updateUser = userService.updateUser(userWrapper)
            ResponseEntity(updateUser, HttpStatus.OK)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}