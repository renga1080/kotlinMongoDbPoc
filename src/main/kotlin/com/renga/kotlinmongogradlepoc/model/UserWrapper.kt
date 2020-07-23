package com.renga.kotlinmongogradlepoc.model

class UserWrapper(){
    lateinit var id: String
    lateinit var name: String
    constructor(_id: String, _name: String): this(){
        this.id = _id
        this.name = _name
    }
}