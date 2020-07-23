package com.renga.kotlinmongogradlepoc.endpoint

import com.renga.kotlinmongogradlepoc.model.UserWrapper
import com.renga.kotlinmongogradlepoc.model.db.User
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

interface UserControllerEndpoint {
    @PostMapping("/api/v1/user")
    fun addUser(@RequestBody user: User) : ResponseEntity<User>

    @GetMapping("/api/v1/user")
    fun getAllUser(): ResponseEntity<List<User>>

    @GetMapping("/api/v1/user/{userId}")
    fun getUserById(@PathVariable userId:String): ResponseEntity<User>

    @DeleteMapping("/api/v1/user/{userId}")
    fun deleteUserById(@PathVariable userId:String): ResponseEntity<Void>

    @PutMapping("/api/v1/user")
    fun updateUser(@RequestBody userWrapper: UserWrapper) : ResponseEntity<User>

}