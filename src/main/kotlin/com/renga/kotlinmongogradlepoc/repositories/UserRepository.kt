package com.renga.kotlinmongogradlepoc.repositories

import com.renga.kotlinmongogradlepoc.model.db.User
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: MongoRepository<User, String>{
    fun findOneById(id: ObjectId): User
}