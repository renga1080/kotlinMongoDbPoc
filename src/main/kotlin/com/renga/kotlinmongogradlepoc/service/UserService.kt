package com.renga.kotlinmongogradlepoc.service

import com.renga.kotlinmongogradlepoc.model.UserWrapper
import com.renga.kotlinmongogradlepoc.model.db.User

interface UserService {
    fun addUser(user: User): User
    fun getAllUser(): List<User>
    fun findUser(id: String): User
    fun removeUser(id: String)
    fun updateUser(userWrapper: UserWrapper): User
}