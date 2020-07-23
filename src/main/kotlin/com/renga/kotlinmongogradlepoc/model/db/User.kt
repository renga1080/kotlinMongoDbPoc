package com.renga.kotlinmongogradlepoc.model.db

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "user")
data class User(@Id val id:String? = null, var name:String)